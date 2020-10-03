package sequential.sorting.bubblesort

import _util.*


fun IntArray.bubbleSort() {
    for (i in 0..lastIndex) {
        var exchanged = false
        for (j in 0 until lastIndex - i) {
            if (this[j + 1] < this[j]) {
                exch(j + 1, j)
                exchanged = true
            }
        }
        if (!exchanged) return
    }
}


fun main() {
    val array = randomIntArray(size = 20)
    array.print()

    array.bubbleSort()

    println("Sorting is successful: ${array.isSorted()}")
    array.print()
}