plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.assessment.universityandroid"
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.assessment.universityandroid"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        dataBinding = true

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.multiDex)

    //coroutine
    implementation(Dependencies.coroutineAndroid)
    implementation(Dependencies.coroutineCore)

    //room
    implementation(Dependencies.roomKtx)
    implementation(Dependencies.roomRuntime)
    kapt (Dependencies.roomCompiler)

    //lifecycle
    implementation(Dependencies.lifeCycleRuntimeCompose)
    implementation(Dependencies.lifeCycleViewmodelCompose)
    implementation(Dependencies.lifeCycleExtensions)

    //retrofit & okhttp
    implementation(Dependencies.retrofit)
    implementation(Dependencies.gson)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.okhttp)


    //dagger
    implementation(Dependencies.dagger)
    implementation(Dependencies.daggerCompiler)

    implementation(Dependencies.timber)

    implementation(project(Modules.UniList))
    implementation(project(Modules.core))

    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.extJunit)
    androidTestImplementation(Dependencies.espressoCore)
}