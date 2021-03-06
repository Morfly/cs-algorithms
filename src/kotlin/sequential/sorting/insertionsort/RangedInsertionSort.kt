package sequential.sorting.insertionsort.ranged

import _util.*


fun IntArray.insertionSort(start: Int, end: Int) {
    if (end - start < 1) return

    // Setting sentinel
    var exchanges = 0
    for (i in end - 1 downTo start + 1) {
        if (this[i] < this[i - 1]) {
            exch(i, i - 1)
            exchanges++
        }
    }
    if (exchanges == 0) return

    // Actual insertion sort
    for (i in (start + 2) until end) {
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

    array.insertionSort(0, array.size)

    println("Sorting is successful: ${array.isSorted()}")
    array.print()
}