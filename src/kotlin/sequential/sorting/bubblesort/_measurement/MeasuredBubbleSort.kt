package sequential.sorting.bubblesort._measurement

import _util.isSorted
import _util.print
import _util.randomIntArray
import sequential.sorting._measurement.measured


fun IntArray.bubbleSort() = measured {
    for (i in 0..lastIndex) {
        var exchanged = false
        for (j in 0 until lastIndex - i) {
            if (this[j + 1] < this[j]) {
                exch(j + 1, j)
                exchanged = true
            }
        }
        if (!exchanged) return@measured
    }
}


fun main() {
    val array = randomIntArray(size = 20)
    array.print()

    val measurement = array.bubbleSort()

    println("Sorting is successful: ${array.isSorted()}")
    array.print()

    println("$measurement")
}