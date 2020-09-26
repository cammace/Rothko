package com.cammace.rothko

import android.app.Application
import timber.log.Timber

/**
 * Initialization of the application.
 */
class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
