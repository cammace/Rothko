package com.cammace.rothko.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

/**
 * Defines all the classes that need to be provided in the scope of the app.
 *
 * @author cammace
 * @since 9/30/20
 */
@InstallIn(ApplicationComponent::class)
@Module
class AppModule {


//    @ApplicationScope
//    @Singleton
//    @Provides
//    fun providesApplicationScope(
//        @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
//    ): CoroutineScope = CoroutineScope(SupervisorJob() + defaultDispatcher)
//
//    @Singleton
//    @Provides
//    @MainThreadHandler
//    fun provideMainThreadHandler(): IOSchedHandler = IOSchedMainHandler()


}
