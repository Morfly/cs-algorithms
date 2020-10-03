package sequential.graph.bfs

import java.util.*


private typealias Graph<T> = Map<T, List<T>>

private typealias Queue<T> = ArrayDeque<T>


fun <T> Graph<T>.bfs(root: T): Collection<T> {
    val graph = this

    val explored = linkedSetOf<T>()
    val searchQueue = Queue<T>()

    searchQueue += root
    while (searchQueue.isNotEmpty()) {
        val node = searchQueue.removeFirst()
        if (node !in explored) {
            explored += node
            searchQueue += graph[node].orEmpty()
        }
    }

    return explored
}


fun main() {
    val socialNetwork: Graph<String> = mapOf(
        "you" to listOf("tony", "steve", "nick"),
        "tony" to listOf("clint"),
        "nick" to listOf("thor", "natasha"),
        "steve" to listOf("phil", "clint")
    )

    println(
        socialNetwork.bfs("you")
    )
}