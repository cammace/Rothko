object Libs {

    object Android {
        const val CORE_KTX = "androidx.core:core-ktx:1.3.1"
        const val APPCOMPAT = "androidx.appcompat:appcompat:1.2.0"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:1.2.5"
        const val ACTIVITY_KTX = "androidx.activity:activity-ktx:1.1.0"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.0.1"

        object Lifecycle {
            const val LIVE_DATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
            const val VIEW_MODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
        }

        object Navigation {
            const val FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:2.3.0"
            const val UI_KTX = "androidx.navigation:navigation-ui-ktx:2.3.0"
        }
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:1.2.1"
    }

    object Dagger {
        const val  HILT_GRADLE_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
        const val HILT = "com.google.dagger:hilt-android:2.28-alpha"
        const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:2.28-alpha"

        object Android {
            const val VIEW_MODEL = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
            const val COMPILER = "androidx.hilt:hilt-compiler:1.0.0-alpha01"
        }
    }

    object Coil {

    }

    object Testing {
        const val JUNIT = "junit:junit:4.13"

        object Android {
            const val JUNIT = "androidx.test.ext:junit:1.1.2"
        }

        object Espresso {
            const val CORE = "androidx.test.espresso:espresso-core:3.3.0"
        }
    }

    const val TIMBER = "com.jakewharton.timber:timber:4.7.1"
}
