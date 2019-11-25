object ApplicationId {
    val id = "br.com.rafaelhfernandes.walletstone"
}

object Modules {

    val app = ":app"
    val buildSrc = ":buildSrc"

    val common = ":common"
    val core = ":core"
    val data = ":data"
    val domain = ":domain"
}

object Features {
    val splashscreen = ":splashscreen"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val buildToolsVersion = "29.0.2"
    val gradle = "3.5.1"
    val compileSdk = 29
    val minSdk = 21
    val targetSdk = 29

    val androidxVersion = "1.1.0"
    val constraintlayoutxVersion = "1.1.3"

    val navigationVersion = "2.1.0"
    val lifecycle = "2.0.0"
    val roomLifecycleVersion = "1.1.1"
    val roomRXVersion = "1.1.1"

}

object Libraries {
    val appcompactx = "androidx.appcompat:appcompat:${Versions.androidxVersion}"
    val androidcorex = "androidx.core:core-ktx:${Versions.androidxVersion}"
    val constraintlayoutx =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayoutxVersion}"

    val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"

    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val roomCompiler = "android.arch.persistence.room:compiler:${Versions.roomLifecycleVersion}"
    val roomRX = "android.arch.persistence.room:rxjava2:${Versions.roomRXVersion}"
    val roomLifecycle = "android.arch.persistence.room:runtime:${Versions.roomLifecycleVersion}"
}

object SupportLibraries {

}

object TestLibraries {
}