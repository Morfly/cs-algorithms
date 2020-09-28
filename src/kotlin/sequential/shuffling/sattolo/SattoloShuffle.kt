package sequential.shuffling.sattolo

import sequential.sorting._util.swap
import kotlin.random.Random


fun IntArray.sattoloShuffle() {
    for (i in lastIndex downTo 1) {
        val j = Random.nextInt(i)
        swap(i, j)
    }
}


fun main() {
    println("SattoloShuffle")
}