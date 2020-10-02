package _util

import sequential.shuffling.fisheryates.fisherYatesShuffle
import kotlin.random.Random


private const val MAX_ARRAY_VALUE = 999
private const val ARRAY_SIZE = 50

fun randomIntArray(size: Int = ARRAY_SIZE, range: IntRange = 0..MAX_ARRAY_VALUE) = 
    IntArray(size) { 
        Random.nextInt(range.first, range.last + 1) 
    }

fun IntArray.shuffle() {
    fisherYatesShuffle()
}

fun IntArray.exch(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}

fun IntArray.isSorted(): Boolean {
    for (i in 1..lastIndex)
        if (this[i] < this[i - 1]) return false
    return true
}

fun IntArray.print() {
    println(contentToString())
}