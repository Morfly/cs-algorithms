package sequential.sorting.selectionsort

import _util.*


fun IntArray.selectionSort() {
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

    array.selectionSort()

    println("Sorting is successful: ${array.isSorted()}")
    array.print()
}