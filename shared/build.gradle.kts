plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.kotlinx.serialization)
  alias(libs.plugins.sqldelight)
}

sqldelight {
  databases {
    create("Database") {
      packageName = "shared.storage.sql"
//      dialect("app.cash.sqldelight:postgresql-dialect:2.0.1")
      deriveSchemaFromMigrations = true
    }
  }
}

//dependencies {
//  implementation("app.cash.sqldelight:jdbc-driver:2.0.1")
//}

kotlin {
  androidTarget {
    compilations.all {
      kotlinOptions {
        jvmTarget = "1.8"
      }
    }
  }

  jvm()

  sourceSets {
//    androidMain.dependencies {
//      implementation(libs.sqldelight.driver.android)
//    }
//    nativeMain.dependencies {
//      implementation(libs.sqldelight.driver.native)
//    }
//    jvmMain.dependencies {
//      implementation(libs.sqldelight.extensions.coroutines)
//    }
    commonMain.dependencies {
      implementation(libs.kotlinx.serialization.json)
      implementation(libs.kotlinx.coroutine)
      implementation(libs.ktor.client.core)
      implementation(libs.ktor.client.okhttp)
      implementation(libs.ktor.serialization)

//      implementation(libs.sqldelight.extensions.coroutines)
    }
  }
}

android {
  namespace = "org.example.project.shared"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
  }
}

kotlin {
  sourceSets.androidMain.dependencies {
    implementation("app.cash.sqldelight:android-driver:2.0.1")
  }

  // or iosMain, windowsMain, etc.
  sourceSets.nativeMain.dependencies {
    implementation("app.cash.sqldelight:native-driver:2.0.1")
  }

  sourceSets.jvmMain.dependencies {
    implementation("app.cash.sqldelight:sqlite-driver:2.0.1")
  }

  sourceSets.commonMain.dependencies {
    implementation("app.cash.sqldelight:sqlite-driver:2.0.1")
  }
}
