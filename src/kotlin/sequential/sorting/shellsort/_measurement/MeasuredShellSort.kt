package sequential.sorting.shellsort._measurement

import _util.isSorted
import _util.print
import _util.randomIntArray
import sequential.sorting._measurement.measured
import sequential.sorting.shellsort.gapsequence.ShellGapSequence


/**
 * Sorts given array with Shellsort using provided gap sequence.
 */
fun IntArray.shellSort(gaps: IntArray) = measured {
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

    val gapSequence = ShellGapSequence.compute(array.size)
    val measurement = array.shellSort(gapSequence)

    println("Sorting is successful: ${array.isSorted()}")
    array.print()

    println("$measurement")
}