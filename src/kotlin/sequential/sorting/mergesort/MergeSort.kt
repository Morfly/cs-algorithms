package sequential.sorting.mergesort

import _util.*


/**
 * In-place merge sort for the given array.
 */
fun IntArray.mergeSort() {
    mergeSort(this, copyOf(), 0, size)
}

private fun mergeSort(arrA: IntArray, arrB: IntArray, start: Int, end: Int) {
    if (end - start < 2) return

    val mid = (start + end) / 2

    mergeSort(arrB, arrA, start, mid)
    mergeSort(arrB, arrA, mid, end)
    merge(arrB, arrA, start, mid, end)
}

private fun merge(arr: IntArray, aux: IntArray, start: Int, mid: Int, end: Int) {
    var i = start
    var j = mid
    for (k in start until end) {
        if (i < mid && (j >= end || arr[i] <= arr[j]))
            aux[k] = arr[i++]
        else aux[k] = arr[j++]
    }
}


fun main() {
    val array = randomIntArray(size = 20)
    array.print()

    array.mergeSort()

    println("Sorting is successful: ${array.isSorted()}")
    array.print()
}