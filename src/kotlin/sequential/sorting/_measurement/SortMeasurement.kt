package sequential.sorting._measurement


abstract class MeasuredCollection<T : Comparable<T>> {

    private var comparisons: Int = 0
    private var exchanges: Int = 0
    private var halfExchanges: Int = 0


    fun beginMeasurement() {
        comparisons = 0
        exchanges = 0
        halfExchanges = 0
    }

    fun <R> endMeasurement(algorithmResult: R) =
        MeasurementResult(algorithmResult, comparisons, exchanges, halfExchanges)

    fun exch(i: Int, j: Int) {
        exchanges++
        this[i] = this[j].also { this[j] = this[i] }
    }
    
    fun onCompare() {
        comparisons++
    }

    operator fun set(index: Int, value: MeasuredElement<T>) {
        halfExchanges++
        setAt(index, value)
    }

    operator fun get(index: Int) = getAt(index)


    abstract fun setAt(index: Int, value: MeasuredElement<T>)

    abstract fun getAt(index: Int): MeasuredElement<T>
}

class MeasuredElement<T : Comparable<T>>(
    private val measurer: MeasuredCollection<T>,
    val value: T
) {

    operator fun compareTo(other: MeasuredElement<T>): Int {
        measurer.onCompare()
        return value.compareTo(other.value)
    }

    operator fun compareTo(other: T): Int {
        measurer.onCompare()
        return value.compareTo(other)
    }
}

data class MeasurementResult<R>(
    val algorithmOutput: R,
    val comparisons: Int,
    val exchanges: Int,
    val halfExchanges: Int
) {
    val totalExchanges = exchanges + halfExchanges / 2.0

    @Suppress("IMPLICIT_CAST_TO_ANY")
    override fun toString() = """
            Algorithm output: ${if (algorithmOutput !is Unit) algorithmOutput else "N/A"}
            Number of comparisons: $comparisons
            Number of exchanges: $exchanges
            Number of half-exchanges: $halfExchanges
            Total number of exchanges: $totalExchanges
        """.trimIndent()
}

class MeasuredIntArray(private val array: IntArray) : MeasuredCollection<Int>() {

    override fun getAt(index: Int) = MeasuredElement(this, array[index])

    override fun setAt(index: Int, value: MeasuredElement<Int>) {
        array[index] = value.value
    }
}


fun <R> IntArray.measured(algorithm: MeasuredIntArray.() -> R): MeasurementResult<R> {
    val measuredArray = MeasuredIntArray(array = this)
    return measuredArray
        .apply { beginMeasurement() }
        .run(algorithm)
        .let { measuredArray.endMeasurement(algorithmResult = it) }
}