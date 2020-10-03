package sequential.sorting.shellsort.gapsequence


/**
 * Experimentally derived gap sequence by Marcin Ciura (2001).
 * Originally the sequence consisted of the  first 8 elements but was extended by Roman Dovgopolov
 * in 2011 by adding 1750.
 *
 * @see [Best Increments for the Average Case of Shellsort](https://doi.org/10.1007/3-540-44669-9_12)
 */
object CiuraGapSequence {

    /**
     * Experimentally derived gap sequence.
     */
    val get = intArrayOf(
            1750, 701, 301, 132, 57, 23, 10, 4, 1
    )
}