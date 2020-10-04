package sequential.graph.postorder


private typealias Graph<T> = Map<T, List<T>>


fun <T> Graph<T>.postorder(root: T): Collection<T> {
    val graph = this

    val explored = mutableSetOf<T>()

    fun explore(node: T) {
        val successors = graph[node].orEmpty()
        for (succ in successors) {
            if (succ !in explored) explore(succ)
        }
        explored.add(node)
    }
    explore(root)

    return explored.toList().asReversed()
}


fun main() {
    val graph = mapOf(
        "A" to listOf("C", "B", "T"),
        "C" to listOf("B", "E"),
        "B" to listOf("D"),
        "T" to listOf("B"),
        "E" to listOf("D")
    )

    println(
        graph.postorder(root = "A")
    )
}