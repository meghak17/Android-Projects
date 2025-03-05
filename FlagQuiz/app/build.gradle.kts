plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("androidx.navigation.safeargs")
}

android {
    namespace = "com.megha.flagquiz"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.megha.flagquiz"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures{
        viewBinding = true;
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":app"))
    implementation(project(":app"))
    val navVersion = "2.7.7"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //noinspection UseTomlInstead
    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")
    //noinspection KtxExtensionAvailable,UseTomlInstead
    implementation("androidx.navigation:navigation-fragment:$navVersion")
    //noinspection KtxExtensionAvailable,UseTomlInstead,KtxExtensionAvailable
    implementation("androidx.navigation:navigation-ui:$navVersion")
}