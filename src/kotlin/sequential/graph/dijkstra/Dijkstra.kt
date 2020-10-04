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

    var node = costs.findMinCostNode(explored)
    while (node != null) {
        explored += node
        val nodeCost = costs[node]!!

        val successors = graph[node].orEmpty()
        for ((succ, edgeWeight) in successors) {
            if (nodeCost + edgeWeight < costs[succ] ?: INFINITY) {
                costs[succ] = nodeCost + edgeWeight
                parents[succ] = node
            }
        }
        node = costs.findMinCostNode(explored)
    }

    return buildPathToNode(target, parents)
}

private fun <T> Map<T, Double>.findMinCostNode(explored: Collection<T>): T? = 
    // turning costs to sequence to improve performance of further operations.
    asSequence()
        // ignoring already explored nodes.
        .filter { (node, _) -> node !in explored } 
        // finding the min cost node.
        .minBy { (_, cost) -> cost} 
        // returning node object or `null` if the node was not found.
        ?.key 

/**
 * Build path from root to target node.
 */
private fun <T> buildPathToNode(target: T, parents: Map<T, T>): List<T> {
    if (target !in parents) error("Invalid arguments provided.")

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