package com.euproff.plugins

import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.sql.*
import kotlinx.coroutines.*
//import org.h2.engine.Database
import org.jetbrains.exposed.sql.Database

//fun Application.configureDatabases() {
//    val dbConnection: Connection = connectToPostgres(embedded = true)
//    val cityService = CityService(dbConnection)
//    routing {
//        // Create city
//        post("/cities") {
//            val city = call.receive<City>()
//            val id = cityService.create(city)
//            call.respond(HttpStatusCode.Created, id)
//        }
//        // Read city
//        get("/cities/{id}") {
//            val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
//            try {
//                val city = cityService.read(id)
//                call.respond(HttpStatusCode.OK, city)
//            } catch (e: Exception) {
//                call.respond(HttpStatusCode.NotFound)
//            }
//        }
//        // Update city
//        put("/cities/{id}") {
//            val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
//            val user = call.receive<City>()
//            cityService.update(id, user)
//            call.respond(HttpStatusCode.OK)
//        }
//        // Delete city
//        delete("/cities/{id}") {
//            val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
//            cityService.delete(id)
//            call.respond(HttpStatusCode.OK)
//        }
//    }
//}
//
///**
// * Makes a connection to a Postgres database.
// *
// * In order to connect to your running Postgres process,
// * please specify the following parameters in your configuration file:
// * - postgres.url -- Url of your running database process.
// * - postgres.user -- Username for database connection
// * - postgres.password -- Password for database connection
// *
// * If you don't have a database process running yet, you may need to [download]((https://www.postgresql.org/download/))
// * and install Postgres and follow the instructions [here](https://postgresapp.com/).
// * Then, you would be able to edit your url,  which is usually "jdbc:postgresql://host:port/database", as well as
// * user and password values.
// *
// *
// * @param embedded -- if [true] defaults to an embedded database for tests that runs locally in the same process.
// * In this case you don't have to provide any parameters in configuration file, and you don't have to run a process.
// *
// * @return [Connection] that represent connection to the database. Please, don't forget to close this connection when
// * your application shuts down by calling [Connection.close]
// * */
//fun Application.connectToPostgres(embedded: Boolean): Connection {
//    Class.forName("org.postgresql.Driver")
//    if (embedded) {
//        return DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "root", "")
//    } else {
//        val url = environment.config.property("postgres.url").getString()
//        val user = environment.config.property("postgres.user").getString()
//        val password = environment.config.property("postgres.password").getString()
//
//        return DriverManager.getConnection(url, user, password)
//    }
//}
object DatabasesFactory{
    private val appConfig = HoconApplicationConfig(ConfigFactory.load())
    private val dbURL = System.getenv("DB_URL")
    private val dbUser = System.getenv("DB_USERNAME")
    private val dbPassword = System.getenv("DB_PASSWORD")
    fun Application.configureDatabases(){
        Database.connect(getHikariDataSource())

    }
    private fun getHikariDataSource(): HikariDataSource{
        val config = HikariConfig()
        config.driverClassName = "org.postgresql.Driver"
        config.jdbcUrl = dbURL
        config.username = dbUser
        config.password = dbPassword
        config.validate()
        return HikariDataSource(config)
    }
}