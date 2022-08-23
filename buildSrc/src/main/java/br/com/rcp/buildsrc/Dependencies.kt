package br.com.rcp.buildsrc

object Dependencies {
    object Versions {
        object Builds {
            const val buildGradle                     = "4.1.2"
            const val kotlinGradlePlugin              = "1.4.21"
            const val navigationSafeArgsGradlePlugin  = "2.3.4"
        }

        object Libraries {
            const val kotlinStandardLibrary           = "1.4.21"
            const val androidCoreKTX                  = "1.3.2"
            const val androidAPPCompat                = "1.2.0"
            const val androidMaterial                 = "1.3.0"
            const val retrofit                        = "2.5.0"
            const val koin                            = "2.1.5"
            const val sharedPreference                = "1.1.1"
            const val picasso                         = "2.71828"
            const val navigationKTX                   = "2.3.2"
            const val constraintLayout                = "2.0.4"
            const val lifecycle                       = "2.2.0"
            const val swipeRefresh                    = "1.1.0"
            const val multidex                        = "1.0.3"
            const val okhttp                          = "3.12.0"
            const val converter                       = "2.6.4"
            const val playServices                    = "18.1.0"
        }

        object Tests {
            const val jUnit                           = "4.13.1"
            const val jUnitExtension                  = "1.1.2"
            const val espressoCore                    = "3.3.0"
            const val testRules                       = "0.5"
            const val mockk                           = "1.9.3"
            const val kotlinCoroutineTests            = "1.4.3"
        }
    }

    object Libraries {
        const val kotlinStandardLibrary           = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Libraries.kotlinStandardLibrary}"
        const val androidCoreKTX                  = "androidx.core:core-ktx:${Versions.Libraries.androidCoreKTX}"
        const val androidAPPCompat                = "androidx.appcompat:appcompat:${Versions.Libraries.androidAPPCompat}"
        const val androidMaterial                 = "com.google.android.material:material:${Versions.Libraries.androidMaterial}"

        const val picasso                         = "com.squareup.picasso:picasso:${Versions.Libraries.picasso}"
        const val navigationFragmentKTX           = "androidx.navigation:navigation-fragment-ktx:${Versions.Libraries.navigationKTX}"
        const val navigationKTX                   = "androidx.navigation:navigation-ui-ktx:${Versions.Libraries.navigationKTX}"
        const val constraintLayout                = "androidx.constraintlayout:constraintlayout:${Versions.Libraries.constraintLayout}"
        const val swipeRefresh                    = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.Libraries.swipeRefresh}"
        const val lifecycle                       = "androidx.lifecycle:lifecycle-extensions:${Versions.Libraries.lifecycle}"
        const val lifecycleKTX                    = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Libraries.lifecycle}"
        const val lifecycleLiveData               = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Libraries.lifecycle}"
        const val lifecycleCommon                 = "androidx.lifecycle:lifecycle-common:${Versions.Libraries.lifecycle}"

        const val okhttp                          = "com.squareup.okhttp3:okhttp:${Versions.Libraries.okhttp}"
        const val retrofit                        = "com.squareup.retrofit2:retrofit:${Versions.Libraries.retrofit}"
        const val gsonConverter                   = "com.squareup.retrofit2:converter-gson:${Versions.Libraries.converter}"

        const val koinViewModel                   = "org.koin:koin-androidx-viewmodel:${Versions.Libraries.koin}"
        const val koinScope                       = "org.koin:koin-androidx-scope:${Versions.Libraries.koin}"
        const val koin                            = "org.koin:koin-android:${Versions.Libraries.koin}"
        const val sharedPreference                = "androidx.preference:preference-ktx:${Versions.Libraries.sharedPreference}"

        const val playServices                    = "com.google.android.gms:play-services:${Versions.Libraries.playServices}"
        const val multidex                        = "com.android.support:multidex:${Versions.Libraries.multidex}"

        const val playServicesMap                 = "com.google.android.gms:play-services-maps:${Versions.Libraries.playServices}"
        const val playServicesLocation            = "com.google.android.gms:play-services-maps:${Versions.Libraries.playServices}"
    }

    object Tests {
        const val jUnit                           = "junit:junit:${Versions.Tests.jUnit}"
        const val jUnitExtension                  = "androidx.test.ext:junit:${Versions.Tests.jUnitExtension}"
        const val espressoCore                    = "androidx.test.espresso:espresso-core:${Versions.Tests.espressoCore}"
        const val testRules                       = "com.android.support.test:rules:${Versions.Tests.espressoCore}"
        const val mockk                           = "io.mockk:mockk:${Versions.Tests.mockk}"
        const val kotlinCoroutineTests            = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Tests.kotlinCoroutineTests}"
    }

    object Builds {
        const val buildGradle                     = "com.android.tools.build:gradle:${Versions.Builds.buildGradle}"
        const val kotlinGradlePlugin              = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Builds.kotlinGradlePlugin}"
        const val navigationSafeArgsGradlePlugin  = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Builds.navigationSafeArgsGradlePlugin}"
    }
}
