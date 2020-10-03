package sequential.graph.bfs

import java.util.*


private typealias Graph<T> = Map<T, List<T>>

private typealias Queue<T> = ArrayDeque<T>


fun <T> Graph<T>.bfs(root: T): Collection<T> {
    val graph = this

    val explored = mutableSetOf<T>()
    val searchQueue = Queue<T>()

    searchQueue.addLast(root)
    while (searchQueue.isNotEmpty()) {
        val node = searchQueue.removeFirst()
        explored.add(node)

        val successors = graph[node].orEmpty()
        for (succ in successors) {
            if (succ !in explored) searchQueue.addLast(succ)
        }
    }

    return explored
}


fun main() {
    // TODO
}