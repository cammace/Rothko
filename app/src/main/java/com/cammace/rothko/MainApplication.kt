package com.cammace.rothko

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy.Builder
import coil.Coil
import coil.ImageLoader
import coil.util.CoilUtils
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient
import timber.log.Timber
import javax.inject.Inject

/**
 * Initialization of the application.
 */
@HiltAndroidApp
class MainApplication : Application() {

    @Inject
    internal lateinit var okHttpClient: OkHttpClient

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        // Enable strict mode before Dagger creates graph
        if (BuildConfig.DEBUG) {
            enableStrictMode()
        }

        buildImageLoader()
    }

    private fun buildImageLoader() {
        val coilOkHttpClient = okHttpClient.newBuilder()
            .cache(CoilUtils.createDefaultCache(this))
            .build()
        Coil.setImageLoader {
            ImageLoader.Builder(this)
                // Hardware bitmaps break with our transitions, disable them for now
                .allowHardware(false)
                // Since we don't use hardware bitmaps, we can pool bitmaps and use a higher
                // ratio of memory
                .bitmapPoolPercentage(0.5)
                .okHttpClient(coilOkHttpClient)
                .build()
        }
    }

    private fun enableStrictMode() {
        StrictMode.setThreadPolicy(
            Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build()
        )
    }
}
