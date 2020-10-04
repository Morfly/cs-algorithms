package sequential.graph.dfs.iterative

import java.util.*


private typealias Graph<T> = Map<T, List<T>>

private typealias Stack<T> = ArrayDeque<T>


fun <T> Graph<T>.dfs(root: T): Collection<T> {
    val graph = this

    val explored = mutableSetOf<T>()
    val searchStack = Stack<T>()

    searchStack.addLast(root)
    while (searchStack.isNotEmpty()) {
        val node = searchStack.removeLast()
        if (node !in explored) {
            explored += node
            searchStack += graph[node].orEmpty()
        }
    }

    return explored
}


fun main() {
    val graph: Graph<String> = mapOf(
        "you" to listOf("tony", "steve", "nick"),
        "tony" to listOf("clint"),
        "nick" to listOf("thor", "natasha"),
        "steve" to listOf("phil", "clint")
    )

    println(
        graph.dfs(root = "you")
    )
}