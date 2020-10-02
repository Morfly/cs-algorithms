package sequential.shuffling.fisheryates

import _util.*
import kotlin.random.Random


fun IntArray.fisherYatesShuffle() {
    for (i in lastIndex downTo 1) {
        val j = Random.nextInt(i + 1)
        exch(i, j)
    }
}


fun main() {
    val array = randomIntArray(20)
    array.sort()
    array.print()

    array.fisherYatesShuffle()

    println("Shuffling is successful: ${!array.isSorted()}")
    array.print()
}