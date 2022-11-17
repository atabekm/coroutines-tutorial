
import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

/**
 * Concurrent execution
 */
fun main(): Unit = runBlocking {
    launch {
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { getRandomNumber1() }
            val two = async(start = CoroutineStart.LAZY) { getRandomNumber2() }
            one.start()
            two.start()
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

private suspend fun getRandomNumber2(): Int {
//    println("start getRandomNumber2")
    delay(2000)
    return Random.nextInt(100)
}