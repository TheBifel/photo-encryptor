
plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "dev.bifel.photoencryptor"
        minSdk = 26
        targetSdk = 32
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.6.10")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.databinding:databinding-runtime:7.1.2")
    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")


    // glide support
    implementation("com.github.bumptech.glide:glide:4.11.0")
    kapt("com.github.bumptech.glide:compiler:4.11.0")

    // pinch zoom
    implementation("com.github.chrisbanes:PhotoView:2.3.0")

    //koin
    implementation("org.koin:koin-android:2.0.1")
    implementation("org.koin:koin-android-viewmodel:2.0.1")

    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    //zip
    implementation("net.lingala.zip4j:zip4j:2.9.0")

    //fragment navigation
    implementation("com.ncapdevi:frag-nav:2.4.0")
    implementation("androidx.navigation:navigation-compose:2.4.1")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
}
