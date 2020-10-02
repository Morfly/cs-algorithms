package sequential.sorting.quicksort.partition

import _util.exch


/**
 * Partitioning algorithm for quick sort introduced by Nico Lomuto.
 */
fun IntArray.lomutoPartition(start: Int, end: Int): Int {
    val pivot = this[end - 1]
    var i = start
    for (j in start until end) {
        if (this[j] < pivot) {
            exch(i++, j)
        }
    }
    exch(i, end - 1)
    return i
}