package sequential.graph.dfs.iterative

import java.util.*


private typealias Graph<T> = Map<T, List<T>>

private typealias Stack<T> = ArrayDeque<T>


fun <T> Graph<T>.iterativeDfs(root: T): Collection<T> {
    val graph = this

    val explored = mutableSetOf<T>()
    val stack = Stack<T>()

    stack.addLast(root)
    while (stack.isNotEmpty()) {
        val node = stack.removeLast()
        explored.add(node)

        val successors = graph[node].orEmpty()
        for (succ in successors) {
            if (succ !in explored) stack.addLast(succ)
        }
    }

    return explored
}


fun main() {

}