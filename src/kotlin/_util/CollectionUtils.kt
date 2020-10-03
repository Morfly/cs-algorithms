package _util

import kotlin.random.Random


private const val MAX_LIST_VALUE = 999
private const val LIST_SIZE = 50

fun randomList(size: Int = LIST_SIZE, range: IntRange = 0..MAX_LIST_VALUE) =
    List(size) {
        Random.nextInt(range.first, range.last + 1)
    }

fun <T : Comparable<T>> Collection<T>.isSorted(): Boolean =
    asSequence().zipWithNext { a, b -> a <= b }.all { it }