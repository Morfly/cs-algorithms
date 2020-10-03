package sequential.sorting.insertionsort._measurement

import _util.*
import sequential.sorting._measurement.*


fun IntArray.insertionSort() = measured {

    // Setting sentinel
    var exchanges = 0
    for (i in lastIndex downTo 1) {
        if (this[i] < this[i - 1]) {
            exch(i, i - 1)
            exchanges++
        }
    }
    if (exchanges == 0) return@measured

    // Actual insertion sort
    for (i in 2..lastIndex) {
        var j = i
        val arri = this[i]
        while (arri < this[j - 1]) {
            this[j] = this[j - 1]
            j--
        }
        this[j] = arri
    }
}


fun main() {
    val array = randomIntArray(size = 20)
    array.print()

    val measurement = array.insertionSort()

    println("Sorting is successful: ${array.isSorted()}")
    array.print()

    println("$measurement")
}