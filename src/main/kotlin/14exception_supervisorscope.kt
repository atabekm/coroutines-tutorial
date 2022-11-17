
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main() = runBlocking {
    val result = supervisorScope {
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
