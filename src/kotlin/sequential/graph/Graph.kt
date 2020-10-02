package sequential.graph


/**
 * Graph representation using hash table.
 * Properties: unweighted, directed.
 */
private typealias GraphMap<T> = Map<T, List<T>>

val socialNetwork: GraphMap<String> = mapOf(
    "you" to listOf("tony", "steve", "nick"),
    "tony" to listOf("clint"),
    "steve" to listOf("phil", "clint"),
    "nick" to listOf("thor", "natasha")
)


/**
 * Graph representation using hash table.
 * Properties: weighted, directed.
 */
private typealias WeightedGraphMap<T> = Map<T, Map<T, Int>>

val waypoints: WeightedGraphMap<String> = mapOf(
    "Start" to mapOf("A" to 5),
    "A" to mapOf("B" to 4, "C" to 7),
    "B" to mapOf("Finish" to 4),
    "C" to mapOf("Finish" to 3)
)


/**
 * Graph representation using boolean adjacency matrix.
 * Properties: unweighted, directed/undirected. (If matrix is symmetric - undirected, otherwise - directed).
 */
private typealias GraphAdjMatrix = Array<BooleanArray>

val graphAdjMatrix: GraphAdjMatrix = arrayOf(
    booleanArrayOf(true, false, false, false),
    booleanArrayOf(false, true, false, false),
    booleanArrayOf(false, true, true, false),
    booleanArrayOf(false, true, false, true)
)


/**
 * Graph representation using int adjacency matrix.
 * Properties: weighted, directed/undirected. (If matrix is symmetric - undirected, otherwise - directed).
 */
private typealias WeightedGraphAdjMatrix = Array<IntArray>

val weightedGraphAdjMatrix: WeightedGraphAdjMatrix = arrayOf(
    intArrayOf(0, 0, 1, 5),
    intArrayOf(0, 1, 0, 0),
    intArrayOf(0, 0, 1, 5),
    intArrayOf(0, 0, 1, 5)
)