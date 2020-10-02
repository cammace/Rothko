package com.cammace.rothko.core.data

import com.cammace.rothko.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * An OkHttp [Interceptor] which adds the required headers to the request for authorization.
 */
class AuthInterceptor : Interceptor {

    companion object {
        private const val USER_ID_HEADER = "x-user-id"
        private const val TOKEN_HEADER = "x-access-token"
    }

    @Throws(IOException::class, Exception::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(USER_ID_HEADER, BuildConfig.ARTSY_ACCESS_TOKEN)
            .addHeader(TOKEN_HEADER, BuildConfig.ARTSY_USER_ID)
            .build()

        return chain.proceed(request)
    }
}
