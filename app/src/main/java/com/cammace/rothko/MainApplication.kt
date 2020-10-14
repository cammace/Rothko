package com.cammace.rothko

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy.Builder
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

/**
 * Initialization of the application.
 */
@HiltAndroidApp
class MainApplication : Application(), ImageLoaderFactory {

    @Inject
    internal lateinit var imageLoader: ImageLoader

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        // Enable strict mode before Dagger creates graph
        if (BuildConfig.DEBUG) {
            enableStrictMode()
        }

        // Make EpoxyController diffing async by default
        val asyncHandler = EpoxyAsyncUtil.getAsyncBackgroundHandler()
        EpoxyController.defaultDiffingHandler = asyncHandler
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

    override fun newImageLoader(): ImageLoader {
        return imageLoader
    }
}
