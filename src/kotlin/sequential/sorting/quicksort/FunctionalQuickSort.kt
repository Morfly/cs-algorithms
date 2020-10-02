package sequential.sorting.quicksort

import _util.*


fun <T : Comparable<T>> List<T>.quickSort(): List<T> = when {
    size < 2 -> toList()
    else -> {
        val pivot = first()
        val (smaller, greater) = drop(1).partition { it <= pivot }
        smaller.quickSort() + pivot + greater.quickSort()
    }
}


fun main() {
    randomList(size = 20)
        .also(::println)
        .run { quickSort() }
        .also { println("Sorting is successful: ${it.isSorted()}") }
        .also(::println)
}