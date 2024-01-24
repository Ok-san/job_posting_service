package com.servak.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class Tables(
    val name: String,
    val email: String,
    val city: String,
    val address: String
)

fun Application.configureRouting() {
    routing {
        post("/api/CreateTable"){
            val Table = call.receive<Tables>()
            println(Table)
            call.respond(HttpStatusCode.OK)
        }
        get("/api/getinfo"){
            call.respond(Tables(name="Buba", email = "yamaksy287@mail.ru", city = "SPB", address = "ITMO" ))
        }
    }
}
