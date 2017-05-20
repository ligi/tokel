import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.http.ContentType
import org.jetbrains.ktor.netty.embeddedNettyServer
import org.jetbrains.ktor.response.respondText
import org.jetbrains.ktor.routing.get

import org.jetbrains.ktor.routing.routing

fun main(args: Array<String>) {
    var current = true
    embeddedNettyServer(9999) {

        routing {
            get("/on") {
                current = true
                call.respondText("OK", ContentType.Text.Html)
            }
            get("/off") {
                current = false
                call.respondText("OK", ContentType.Text.Html)
            }
            get("/") {
                call.respondText(if (current) "ON" else "OFF", ContentType.Text.Html)
            }

        }
    }.start(wait = false)

}


