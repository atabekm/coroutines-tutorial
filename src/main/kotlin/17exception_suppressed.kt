
import kotlinx.coroutines.*

private val scope = CoroutineScope(Job() + Dispatchers.Default)

fun main(): Unit = runBlocking {
    scope.launch {
        launch {
            delay(100)
            throw IllegalStateException("First Boom!")
        }

        launch {
            delay(105)
            println("second")
            throw IllegalStateException("Second Boom!")
        }
    }
    delay(500)
}
