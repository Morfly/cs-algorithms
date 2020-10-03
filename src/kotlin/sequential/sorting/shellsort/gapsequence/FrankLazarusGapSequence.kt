package sequential.sorting.shellsort.gapsequence

import kotlin.math.floor
import kotlin.math.pow


/**
 * Gap sequence for Shellsort introduced by Frank & Lazarus in 1960.
 */
object FrankLazarusGapSequence {

    /**
     * Computes gap sequence for the given array size.
     *
     * Note: sequence values differ depending on the array size. Thus, it can not be precomputed.
     */
    fun compute(arraySize: Int): IntArray {
        var k = 1
        // Determine gap sequence size and it's largest element.
        while (computeTerm(k, arraySize) != 1) {
            k++
        }

        val gaps = IntArray(k)
        k = 1
        for (i in 0..gaps.lastIndex) {
            gaps[i] = computeTerm(k++, arraySize)
        }

        return gaps
    }

    /**
     * General term of the gap sequence.
     *
     * @param N array size.
     * @param k sequence term number (starting from 1).
     * @return k-th term of the sequence.
     */
    private fun computeTerm(k: Int, N: Int): Int {
        val gap = 2 * floor(N / 2.0.pow(k + 1)) + 1
        return gap.toInt()
    }
}