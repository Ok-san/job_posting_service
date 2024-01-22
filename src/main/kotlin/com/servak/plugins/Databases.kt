package com.servak.plugins

import com.typesafe.config.ConfigFactory
import io.ktor.server.application.*
import io.ktor.server.config.*
import org.jetbrains.exposed.sql.Database
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource

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