
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val result = coroutineScope {
        launch {
            delay(100)
            throw IllegalArgumentException("A total fiasco!")
        }

        launch {
            delay(200)
            println("Hi there!")
        }

        "Result!"
    }

    println("Got result: $result")
}
