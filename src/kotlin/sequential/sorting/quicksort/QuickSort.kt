package sequential.sorting.quicksort

import sequential.sorting.insertionsort.ranged.insertionSort
import sequential.sorting.quicksort.partition.lomutoPartition
import sequential.sorting.quicksort.partition.hoarePartition
import _util.shuffle


/**
 * Minimum threshold for which quick sort algorithm will be applied. Otherwise, insertion sort will be used.
 */
private const val INSERTION_SORT_THRESHOLD = 47


/**
 * In-place quick sort for the given array.
 */
fun IntArray.quickSort() {
    shuffle()
    quickSort(0, size)
}

/**
 * In-place quick sort for the given range.
 *
 * It is possible to partition an array by the following algorithms:
 * [hoarePartition], [lomutoPartition].
 *
 * @param start start of the sorting range inclusive.
 * @param end end of the sorting range exclusive.
 */
private fun IntArray.quickSort(start: Int, end: Int) {
    if (end - start < 2) return

    if (end - start <= INSERTION_SORT_THRESHOLD) {
        insertionSort(start, end)
        return
    }

    val pivot = partition(start, end)
    quickSort(start, pivot)
    quickSort(pivot + 1, end)
}


/**
 * Currently selected partitioning algorithm which is used in [quickSort].
 * Can be [lomutoPartition] or [hoarePartition].
 */
var partition: PartitioningFunction = IntArray::hoarePartition

typealias PartitioningFunction = IntArray.(start: Int, end: Int) -> Int


fun main() {
    println("QuickSort")
}