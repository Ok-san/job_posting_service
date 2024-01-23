plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.kotlinx.serialization)
  alias(libs.plugins.sqldelight)
}

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
    commonMain.dependencies {
      implementation(libs.kotlinx.serialization.json)
      implementation(libs.kotlinx.coroutine)
      implementation(libs.ktor.client.core)
      implementation(libs.ktor.client.okhttp)
      implementation(libs.ktor.serialization)
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

sqldelight {
  databases {
    create("Database") {
      packageName = "storage"
      dialect("app.cash.sqldelight:postgresql-dialect:2.0.1")
      deriveSchemaFromMigrations = true
    }
  }
}

dependencies {
  implementation("app.cash.sqldelight:jdbc-driver:2.0.1")
}
