object WalletApplication {
    val id = "br.com.rafaelhfernandes.walletstone"
    val walletApplicationName = "WalletStone"
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
    val accountmanager = ":accountmanager"
    val home = ":transactions"
    val shop = ":shop"
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

    val rxandroid = "2.0.1"

    val navigationVersion = "2.1.0"
    val lifecycle = "2.0.0"
    val roomLifecycleVersion = "1.1.1"
    val roomRXVersion = "1.1.1"
    val design = "1.0.0"
    val appcompatx = "1.0.2"
}

object Libraries {
    val appcompactx = "androidx.appcompat:appcompat:${Versions.androidxVersion}"
    val androidcorex = "androidx.core:core-ktx:${Versions.androidxVersion}"
    val constraintlayoutx =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayoutxVersion}"

    val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"


    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val roomCompiler = "android.arch.persistence.room:compiler:${Versions.roomLifecycleVersion}"
    val roomRX = "android.arch.persistence.room:rxjava2:${Versions.roomRXVersion}"
    val roomLifecycle = "android.arch.persistence.room:runtime:${Versions.roomLifecycleVersion}"

    val design = "com.google.android.material:material:${Versions.design}"

}


object TestLibraries {
}