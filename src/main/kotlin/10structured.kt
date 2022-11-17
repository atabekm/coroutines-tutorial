
import kotlinx.coroutines.*

private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

fun main() {
    runBlocking {
        val mainJob = scope.launch {
            println("Starting the main job!")
            // this is an independent coroutine,
            // not a child coroutine
            launch {
                while (isActive) {
                    delay(100)
                    println("I'm alive!!!")
                }
            }
        }
        mainJob.invokeOnCompletion {
            println("The main job is completed/cancelled!")
        }

        delay(200)

        mainJob.cancel()

        delay(500)
        println("Finishing main()...")
    }
}

private fun reason() {
/**
 * Similar to the example where we introduced a new Job into the context, there is no parent-child relationship between
 * these two coroutines, which might not be immediately apparent to less experienced developers.
 */
}