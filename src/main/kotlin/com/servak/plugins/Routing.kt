package com.servak.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import kotlinx.datetime.LocalDate


@Serializable
data class Tables(
    var userId: Int,
    var name: String,
    var phoneNumber: String?,
    var email: String?,
    var city: String?,
    var birthdate: LocalDate?,
    var address: String?,
    val avatar: String?,
    val isMaster: Boolean = false,
    var services: MutableList<Int>,
    var orders: MutableList<Int>,
)

fun Application.configureRouting() {
    routing {
        post("/api/CreateTable"){
            val Table = call.receive<Tables>()
            println(Table)
            call.respond(HttpStatusCode.OK)
        }
        get("/api/getinfo"){
            call.respond(Tables(name="Buba",
                                email = "yamaksy287@mail.ru",
                                city = "SPB",
                                address = "ITMO",
                                userId = 1,
                                phoneNumber = "89999999999",
                                birthdate = LocalDate.parse("2000-11-15"),
                                avatar = "",
                                isMaster = false,
                                services = mutableListOf(),
                                orders = mutableListOf() ))
        }
    }
}
