package br.com.rcp.buildsrc

object Build {
    object Version {
        const val compileSDKVersion = 30
        const val minSDKVersion     = 19
        const val targetSDKVersion  = 30
        const val buildToolsVersion = "30.0.3"
        const val versionCode       = 1
        const val versionName       = "1.0"
    }

    object Name {
        const val applicationID             = "br.com.rcp.eventos"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}