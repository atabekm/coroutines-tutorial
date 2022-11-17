
import kotlinx.coroutines.*

private val scope = CoroutineScope(Job() + Dispatchers.Default)

fun main(): Unit = runBlocking {
    // Main Job
    scope.launch {
        // Child 1
        launch {
            while (true) {
                // run
            }
        }.printOnComplete("Child 1 is cancelled!")

        // Child 2
        launch {
            delay(500)
            println("Here goes boom...")
            throw IllegalArgumentException("Boom!")
        }.printOnComplete("Child 2 is cancelled!")
    }.printOnComplete("Main Job has completed!")

    // Random coroutine on the same scope
    scope.launch {
        while (isActive) {
            // run
        }
    }.printOnComplete("Random coroutine is cancelled!")

    delay(1000)
}
