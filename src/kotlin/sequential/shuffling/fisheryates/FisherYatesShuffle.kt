package sequential.shuffling.fisheryates

import _util.swap
import kotlin.random.Random


fun IntArray.fisherYatesShuffle() {
    for (i in lastIndex downTo 1) {
        val j = Random.nextInt(i + 1)
        swap(i, j)
    }
}


fun main() {
    println("FisherYatesShuffle")
}