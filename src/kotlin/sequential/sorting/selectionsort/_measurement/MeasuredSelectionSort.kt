package sequential.sorting.selectionsort._measurement

import _util.*
import sequential.sorting._measurement.*


fun IntArray.selectionSort() = measured {
    for (i in 0..lastIndex) {
        var minIndex = i
        for (j in i + 1..lastIndex)
            if (this[j] < this[minIndex])
                minIndex = j
        exch(i, minIndex)
    }
}


fun main() {
    val array = randomIntArray(size = 20)
    array.print()

    val measurement = array.selectionSort()

    println("Sorting is successful: ${array.isSorted()}")
    array.print()

    println("$measurement")
}