
import kotlinx.coroutines.*

private val scope = CoroutineScope(Job() + Dispatchers.Default)

fun main(): Unit = runBlocking {
    scope.launch {
        launch {
            try {
                delay(10)
                throw IllegalArgumentException("A complete failure!")
            } catch (e: Exception) {
                println("Child 1 has recovered from: ${e.message}")
            }
        }

        launch {
            delay(50)
            println("Child 2 is OK!")
        }
    }

    delay(100)

    println("Main is done!")
}
