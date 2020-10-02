package sequential.shuffling.sattolo

import _util.*
import kotlin.random.Random


fun IntArray.sattoloShuffle() {
    for (i in lastIndex downTo 1) {
        val j = Random.nextInt(i)
        exch(i, j)
    }
}


fun main() {
    val array = randomIntArray(20)
    array.sort()
    array.print()

    array.sattoloShuffle()

    println("Shuffling is successful: ${!array.isSorted()}")
    array.print()
}