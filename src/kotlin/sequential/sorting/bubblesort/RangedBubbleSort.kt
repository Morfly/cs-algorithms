package sequential.sorting.bubblesort.ranged

import _util.*


fun IntArray.bubbleSort(start: Int, end: Int) {
    if (end - start < 1) return

    for (i in start until end) {
        var exchanged = false
        for (j in start until (end - 1) - (i - start)) {
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

    array.bubbleSort(0, array.size)

    println("Sorting is successful: ${array.isSorted()}")
    array.print()
}