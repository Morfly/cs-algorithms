package sequential.sorting.shellsort

import _util.isSorted
import _util.print
import _util.randomIntArray
import sequential.sorting.shellsort.gapsequence.ShellGapSequence


/**
 * Sorts given array using Shellsort.
 */
fun IntArray.shellSort() {
    shellSort(ShellGapSequence.compute(size))
}

/**
 * Sorts given array with Shellsort using provided gap sequence.
 */
fun IntArray.shellSort(gaps: IntArray) {
    for (gap in gaps) {
        for (i in gap..lastIndex) {
            var j = i
            val arri = this[i]
            while (j >= gap && arri < this[j - gap]) {
                this[j] = this[j - gap]
                j -= gap
            }
            this[j] = arri
        }
    }
}


fun main() {
    val array = randomIntArray(size = 20)
    array.print()

    array.shellSort()

    println("Sorting is successful: ${array.isSorted()}")
    array.print()
}