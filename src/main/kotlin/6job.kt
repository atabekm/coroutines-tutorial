
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main(): Unit = runBlocking {
    var job: Job? = null

    fun onStart() {
        job = launch {
            val time = measureTimeMillis {
                val one = getRandomNumber1()
                val two = getRandomNumber2()
                println("The answer is ${one + two}")
            }
            println("Completed in $time ms")
        }
    }

    fun onStop() {
        job?.cancel()
    }
}

private suspend fun getRandomNumber1(): Int {
    delay(1000)
    return Random.nextInt(100)
}

private suspend fun getRandomNumber2(): Int {
    delay(2000)
    return Random.nextInt(100)
}