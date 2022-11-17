
import kotlinx.coroutines.*

private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

fun main(): Unit = runBlocking {
    val parentJob = scope.launch {
        println("Starting the parent job!")

        launch {
            while (isActive) {
                delay(10)
                println("Doing some work...")
            }
        }.invokeOnCompletion {
            println("Cancelling all work! ")
        }
    }

    parentJob.invokeOnCompletion {
        println("The parent job is cancelled!")
    }

    delay(50)

    parentJob.cancelAndJoin()

    println("Main is done!")
}
