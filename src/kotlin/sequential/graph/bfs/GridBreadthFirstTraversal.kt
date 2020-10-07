package sequential.graph.bfs.grid

import java.util.*


private typealias Graph<T> = Array<Array<out T>>

private typealias Queue = ArrayDeque<Pair<Int, Int>>


// Grid traversal directions represented as (row, col): left, up, right, down.
private val DIRECTIONS = arrayOf(0 to -1, -1 to 0, 0 to 1, 1 to 0)


fun <T> Graph<T>.bfs(rootRow: Int, rootCol: Int): Collection<T> {
    val graph = this
    require(graph.isValid(rootRow, rootCol)) { "Invalid graph." }

    val rows = graph.size
    val cols = graph[0].size
    val rowBounds = 0 until rows
    val colBounds = 0 until cols

    val explored = Array(rows) { BooleanArray(cols) { false } }
    val traversed = mutableListOf<T>()
    val searchQueue = Queue()

    searchQueue += rootRow to rootCol
    while (searchQueue.isNotEmpty()) {
        val (row, col) = searchQueue.removeFirst()

        if (!explored[row][col] && graph[row][col] != null) {
            explored[row][col] = true
            traversed += graph[row][col]

            for ((stepRow, stepCol) in DIRECTIONS) {
                val nextRow = row + stepRow
                val nextCol = col + stepCol

                if (nextRow in rowBounds && nextCol in colBounds)
                    searchQueue += nextRow to nextCol
            }
        }
    }

    return traversed
}


private fun <T> Graph<T>.isValid(rootRow: Int, rootCol: Int): Boolean {
    val graph = this

    // check if graph is not empty.
    if (graph.isEmpty() || graph[0].isEmpty()) return false
    // check if root vertex is valid.
    if (graph.getOrNull(rootRow)?.getOrNull(rootCol) == null) return false

    val cols = graph[0].size

    // check if graph dimensions are valid.
    for (row in graph)
        if (row.size != cols) return false

    return true
}


fun main() {

    val graph = arrayOf(
        arrayOf(3, 2, 1),
        arrayOf(1, 4, 4),
        arrayOf(9, 3, null)
    )

    println(
        graph.bfs(0, 0)
    )
}