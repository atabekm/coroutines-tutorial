
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

/**
 * Concurrent execution
 */
fun main(): Unit = runBlocking {
    launch {
        val time = measureTimeMillis {
            val one = async { getRandomNumber1() }
            val two = async { getRandomNumber2(one.await()) }
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }
    println("Done")
}

private suspend fun getRandomNumber1(): Int {
//    println("start getRandomNumber1")
    delay(1000)
    return Random.nextInt(100)
}

private suspend fun getRandomNumber2(number: Int): Int {
//    println("start getRandomNumber2")
    delay(2000)
    return Random.nextInt(100)
}