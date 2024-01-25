import app.cash.sqldelight.db.SqlDriver
import shared.storage.sql.Database

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): Database {
  val driver = driverFactory.createDriver()
  return Database(driver)
}
