package sequential.sorting.quicksort

import sequential.sorting.insertionsort.insertionSort
import sequential.sorting.quicksort.partition.lomutoPartition
import sequential.sorting.quicksort.partition.hoarePartition
import _util.*


/**
 * Minimum threshold for which quick sort algorithm should be applied. Otherwise, insertion sort is used.
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
 * In-place quick sort for the given range in array.
 *
 * @param start inclusive.
 * @param end exclusive.
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
 * Partitioning function for the [quickSort].
 * Can be [lomutoPartition] or [hoarePartition] algorithms.
 */
var partition: IntArray.(start: Int, end: Int) -> Int = IntArray::hoarePartition


fun main() {
    val array = randomIntArray(size = 20)
    array.print()

    partition = IntArray::lomutoPartition
    array.quickSort()

    println("Sorting is successful: ${array.isSorted()}")
    array.print()
}