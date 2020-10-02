package com.cammace.rothko.core.di

import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.cammace.rothko.core.BuildConfig
import com.cammace.rothko.core.data.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Cache
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Dagger module for all things related to retrieving remote data.
 */
@InstallIn(ApplicationComponent::class)
@Module
object RemoteModule {

    private const val BASE_URL = "https://metaphysics-production.artsy.net/v2"
    private const val TIMEOUT_TIME = 10L
    private const val CACHE_SIZE: Long = 10 * 1024 * 1024 // 10MB

    @Singleton
    @Provides
    fun provideApiClient(okHttpClient: OkHttpClient): ApolloClient {
        val client = okHttpClient.newBuilder()
            .addInterceptor(AuthInterceptor())
            .build()

        return ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }
            cache(Cache(context.cacheDir, CACHE_SIZE))
            connectTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
            readTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
            writeTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
        }.dispatcher(
            Dispatcher().apply {
                // Allow for high number of concurrent image fetches on same host.
                maxRequestsPerHost = 15
            }
        )
            .build()
    }
}
