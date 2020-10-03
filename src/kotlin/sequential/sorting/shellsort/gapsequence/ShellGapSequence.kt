package sequential.sorting.shellsort.gapsequence

import kotlin.math.log2


/**
 * Original Shell's gap sequence for Shellsort.
 */
object ShellGapSequence {

    /**
     * Computes gap sequence for the given array size.
     */
    fun compute(arraySize: Int): IntArray {
        if (arraySize <= 1) return intArrayOf(1)

        // Compute sequence size.
        val k = log2(arraySize.toFloat()).toInt()

        val gaps = IntArray(k)

        var gap = arraySize
        for (i in 0..gaps.lastIndex) {
            gap = computeTerm(gap)
            gaps[i] = gap
        }

        return gaps
    }


    /**
     * General term of the gap sequence.
     *
     * @param h previous sequence term.
     * @return next sequence term.
     */
    private fun computeTerm(h: Int) = h / 2
}