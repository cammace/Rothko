object Libs {

    object Android {
        const val GRADLE_PLUGIN = "com.android.tools.build:gradle:4.0.1"
        const val CORE_KTX = "androidx.core:core-ktx:1.3.2"
        const val APPCOMPAT = "androidx.appcompat:appcompat:1.2.0"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:1.2.5"
        const val ACTIVITY_KTX = "androidx.activity:activity-ktx:1.1.0"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.0.4"

        object Lifecycle {
            private const val VERSION = "2.2.0"
            const val LIVE_DATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:$VERSION"
            const val VIEW_MODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:$VERSION"
        }

        object Navigation {
            private const val VERSION = Versions.NAVIGATION
            const val GRADLE_PLUGIN = "androidx.navigation:navigation-safe-args-gradle-plugin:$VERSION"
            const val FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:$VERSION"
            const val UI_KTX = "androidx.navigation:navigation-ui-ktx:$VERSION"
        }
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:1.2.1"
    }

    object Hilt {
        private const val VERSION = "2.30.1-alpha"
        const val GRADLE_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:$VERSION"
        const val CORE = "com.google.dagger:hilt-android:$VERSION"
        const val COMPILER = "com.google.dagger:hilt-android-compiler:$VERSION"
        const val TESTING = "com.google.dagger:hilt-android-testing:$VERSION"

        object Android {
            private const val VERSION = "1.0.0-alpha02"
            const val VIEW_MODEL = "androidx.hilt:hilt-lifecycle-viewmodel:$VERSION"
            const val COMPILER = "androidx.hilt:hilt-compiler:$VERSION"
        }
    }

    object Apollo {
        private const val VERSION = Versions.APOLLO
        const val RUNTIME = "com.apollographql.apollo:apollo-runtime:$VERSION"
        const val COROUTINE = "com.apollographql.apollo:apollo-coroutines-support:$VERSION"
    }

    object OkHttp {
        private const val VERSION = "4.9.0"
        const val CORE = "com.squareup.okhttp3:okhttp:$VERSION"
        const val LOGGING = "com.squareup.okhttp3:logging-interceptor:$VERSION"
    }

    object Coil {
        const val CORE = "io.coil-kt:coil:1.1.0"
    }

    object Epoxy {
        private const val VERSION = "4.2.0"
        const val CORE = "com.airbnb.android:epoxy:$VERSION"
        const val PAGING = "com.airbnb.android:epoxy-paging3:$VERSION"
        const val PROCESSOR = "com.airbnb.android:epoxy-processor:$VERSION"
    }

    object Testing {
        const val JUNIT = "junit:junit:4.13.1"

        object Android {
            const val JUNIT = "androidx.test.ext:junit:1.1.2"
        }

        object Espresso {
            const val CORE = "androidx.test.espresso:espresso-core:3.3.0"
        }
    }

    const val TIMBER = "com.jakewharton.timber:timber:4.7.1"
}
