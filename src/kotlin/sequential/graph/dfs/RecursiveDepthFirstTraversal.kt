package sequential.graph.dfs


private typealias Graph<T> = Map<T, List<T>>


fun <T> Graph<T>.dfs(root: T): Collection<T> {
    val graph = this

    val explored = mutableSetOf<T>()

    fun explore(node: T) {
        explored.add(node)

        val successors = graph[node].orEmpty()
        for (succ in successors) {
            if (succ !in explored) explore(succ)
        }
    }
    explore(root)

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
        socialNetwork.dfs(root = "you")
    )
}