package sequential.sorting.quicksort.partition

import _util.exch


/**
 * Partitioning algorithm for quick sort introduced by Tony Hoare.
 */
fun IntArray.hoarePartition(start: Int, end: Int): Int {
    val pivotPosition = (start + end - 1) / 2
    exch(pivotPosition, start)

    val pivot = this[start]
    var i = start
    var j = end
    while (true) {
        do i++
        while (i < end && this[i] < pivot)

        do j--
        while (this[j] > pivot)

        if (i >= j) break
        exch(i, j)
    }
    exch(start, j)
    return j
}