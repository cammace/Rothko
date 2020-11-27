package com.cammace.rothko.di

import android.content.Context
import coil.ImageLoader
import coil.util.CoilUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * Defines all the classes that need to be provided in the scope of the app.
 *
 * @author cammace
 * @since 9/30/20
 */
@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providesImageLoader(@ApplicationContext context: Context, okHttpClient: OkHttpClient): ImageLoader {
        val coilOkHttpClient = okHttpClient.newBuilder()
            .cache(CoilUtils.createDefaultCache(context))
            .build()
        return ImageLoader.Builder(context)
            // Hardware bitmaps break with our transitions, disable them for now
            .allowHardware(false)
            // Since we don't use hardware bitmaps, we can pool bitmaps and use a higher
            // ratio of memory
            .bitmapPoolPercentage(0.25)
            .okHttpClient(coilOkHttpClient)
            .build()
    }
}
