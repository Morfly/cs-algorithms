package sequential.graph.dijkstra


/**
 * Weighted graph representation using hash table.
 * @param T graph value type.
 */
private typealias Graph<T> = Map<T, Map<T, Double>>

/**
 * Infinity value which is used as graph edge weight.
 */
private val INFINITY = Double.POSITIVE_INFINITY


/**
 * Finds shortest path to the [target] node using Dijkstra algorithm.
 */
fun <T> Graph<T>.dijkstra(root: T, target: T): Collection<T> {
    val graph = this

    val costs = graph[root].orEmpty().toMutableMap()
    val explored = mutableSetOf<T>()
    val parents = graph[root].orEmpty().mapValues { root }.toMutableMap()

    var node = costs.minCostNode(explored)
    while (node != null) {
        val nodeCost = costs[node]!!

        val successors = graph[node].orEmpty()
        for ((succ, edgeWeight) in successors) {
            if (nodeCost + edgeWeight < costs[succ] ?: INFINITY) {
                costs[succ] = nodeCost + edgeWeight
                parents[succ] = node
            }
        }
        explored += node
        node = costs.minCostNode(explored)
    }

    return pathToNode(target, parents)
}

private fun <T> Map<T, Double>.minCostNode(explored: Collection<T>): T? {
    val costs = this

    var minCostNode: T? = null
    var minCost = INFINITY
    for ((node, cost) in costs) {
        if (node !in explored && cost < minCost) {
            minCostNode = node
            minCost = cost
        }
    }
    return minCostNode
}

/**
 * Build path from root to target node.
 */
private fun <T> pathToNode(target: T, parents: Map<T, T>): List<T> {
    if (target !in parents) return emptyList()

    val path = mutableListOf<T>()
    var node: T? = target
    while (node != null) {
        path += node
        node = parents[node]
    }
    return path.reversed()
}


fun main() {
    val waypoints: Graph<String> = mapOf(
        "Start" to mapOf("A" to 5.0),
        "A" to mapOf("B" to 7.0, "C" to 4.0),
        "B" to mapOf("Finish" to 4.0),
        "C" to mapOf("Finish" to 3.0)
    )

    println(
        waypoints.dijkstra("Start", "Finish")
    )
}