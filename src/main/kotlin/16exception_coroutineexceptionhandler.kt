
import kotlinx.coroutines.*

val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
    println("Handler has caught: ${throwable.message}")
}

private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default + handler)

fun main(): Unit = runBlocking {
    // we are adding a handler to the
    // context of a root coroutine
    scope.launch {
        delay(10)
        throw IllegalArgumentException("An awful crash!")
    }

    delay(100)
    println("Main is done!")
}