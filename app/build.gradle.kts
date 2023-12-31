plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.kupujemprodajemaplikacija"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kupujemprodajemaplikacija"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    viewBinding{
        enable = true
    }
    dataBinding{
        enable = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }


}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Paging
    implementation ("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    //Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    //Navigation component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.4")
}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}