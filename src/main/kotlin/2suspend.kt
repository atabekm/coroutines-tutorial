
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

/**
 * Sequential execution
 */
fun main(): Unit = runBlocking {
    launch {
        val time = measureTimeMillis {
            val one = getRandomNumber1()
            val two = getRandomNumber2()
            println("The answer is ${one + two}")
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