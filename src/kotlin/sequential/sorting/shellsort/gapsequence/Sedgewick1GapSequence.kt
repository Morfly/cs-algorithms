package sequential.sorting.shellsort.gapsequence

import kotlin.math.floor
import kotlin.math.pow


object Sedgewick1GapSequence {

    /**
     * Precomputed gap sequence for arrays of integer range.
     */
    val get = intArrayOf(
            1073790977, 268460033, 67121153, 16783361, 4197377, 1050113, 262913, 65921, 16577, 4193,
            1073, 281, 77, 23, 8, 1
    )

    /**
     * Computes gap sequence for the given array size.
     */
    fun compute(arraySize: Int): IntArray {
        var k = 1
        while (computeTerm(k) < arraySize) {
            k++
        }

        val gaps = IntArray(k--)
        for (i in 0..gaps.lastIndex) {
            gaps[i] = if (i == gaps.lastIndex) 1
            else {
                computeTerm(k--)
            }
        }

        return gaps
    }


    /**
     * General term of the gap sequence.
     *
     * @param k sequence term number (starting from 1).
     * @return k-th term of the sequence.
     */
    private fun computeTerm(k: Int) =
            floor(
                    4.0.pow(k) + 3 * 2.0.pow(k - 1) + 1
            ).toInt()
}