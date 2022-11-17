
import kotlinx.coroutines.*

private val scope = CoroutineScope(Job() + Dispatchers.Default)

fun main(): Unit = runBlocking {
    // Main Job
    val job = scope.launch {
        // Child 1
        launch {
            while (true) {
                // run
            }
        }.printOnComplete("Child 1 is cancelled!")

        // Child 2
        launch {
            delay(500)
        }.printOnComplete("Child 2 is cancelled!")
    }.apply {
        printOnComplete("Parent is cancelled!")
    }

    job.cancelAndJoin()
}
