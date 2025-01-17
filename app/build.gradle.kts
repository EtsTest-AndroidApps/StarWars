import org.gradle.kotlin.dsl.precompile.PrecompiledProjectScript.NullPluginDependencySpec.version

plugins{
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 31
    buildToolsVersion = "30.0.2"
    defaultConfig {
        applicationId = "ir.heydarii.starwars"
        minSdk = 21
        targetSdk = 31
        versionCode = 300
        versionName = "3.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release")  {
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles( getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.5"
    }
}

dependencies {

    // Kotlin
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    // Support libraries
    implementation ("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation ("androidx.appcompat:appcompat:1.4.0")
    implementation ("com.google.android.material:material:1.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    //test libraries
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test:runner:1.4.0")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

    // Retrofit and Moshi
    implementation ("com.squareup.retrofit2:retrofit:${rootProject.extra["retrofit_version"]}")
    implementation ("com.squareup.retrofit2:converter-moshi:${rootProject.extra["retrofit_version"]}")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")

    // Hilt
    implementation ("com.google.dagger:hilt-android:${rootProject.extra["hilt_version"]}")
    kapt ("com.google.dagger:hilt-compiler:${rootProject.extra["hilt_version"]}")

    // ViewModel and LiveData
    implementation ("androidx.lifecycle:lifecycle-extensions:${rootProject.extra["lifecycle_version"]}")

    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:${rootProject.extra["nav_version"]}")
    implementation ("androidx.navigation:navigation-ui-ktx:${rootProject.extra["nav_version"]}")

    // Compose
    implementation ("androidx.compose.material:material:1.0.5")
    implementation ("androidx.compose.foundation:foundation:1.0.5")
    implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling-preview:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")

}
