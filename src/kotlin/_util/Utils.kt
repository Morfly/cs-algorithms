package _util

import sequential.shuffling.fisheryates.fisherYatesShuffle


fun IntArray.shuffle() {
    fisherYatesShuffle()
}

fun IntArray.swap(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}