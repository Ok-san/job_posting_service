package com.euproff.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class Test(
    val text: String
)
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respond(Test(text="hello world"))
        }
        post("/login"){

        }
    }
}
