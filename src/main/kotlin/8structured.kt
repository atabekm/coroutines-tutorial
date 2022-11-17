
import kotlinx.coroutines.*

private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

fun main() = runBlocking {
    val mainJob = scope.launch {
        println("Starting the main job!")

        launch { // start a child coroutine 1
            while (isActive) {
                delay(10)
                println("I am child 1!")
            }
        }

        launch {  // start a child coroutine 2
            while (isActive) {
                delay(20)
                println("I am child 2!")
            }
        }
    }
    mainJob.invokeOnCompletion {
        println("The main job is completed/cancelled!")
    }

    delay(50)

    // this will cancel the main coroutine
    // and all its children
    scope.cancel()

    delay(500)
    println("Finishing main()...")
}