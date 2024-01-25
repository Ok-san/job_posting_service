import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import shared.storage.sql.Database

actual class DriverFactory {
  actual fun createDriver(): SqlDriver {
    val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    Database.Schema.create(driver)
    return driver
  }
}
