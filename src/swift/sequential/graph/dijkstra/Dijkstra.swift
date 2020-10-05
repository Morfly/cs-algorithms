/// Weighted graph representation using dictionary.
typealias Graph<T: Hashable> = [T: [T: Double]]


/// Infinity as a default node cost value.
let infinity = Double.infinity


/**
 Finds fastest path between specified nodes in the given graph.

 - Parameters:
    - graph: Given graph.
    - root: Beginning of the path.
    - target: End of the path.

 - Returns: Array representing path to the `target` node starting from `root` or `nil` if invalid arguments provided.
 */
func dijkstra<T>(in graph: Graph<T>, withRoot root: T, findPathTo target: T) -> [T]? {
    guard graph[root] != nil else { return nil }

    var costs = graph[root]!
    var explored = Set<T>()
    var parents = graph[root]!.mapValues { _ in root }
    
    while let node = findMinCostNode(in: costs, except: explored) {
        explored.insert(node)
        let nodeCost = costs[node]!
        
        guard let successors = graph[node] else { continue }

        for (succ, edgeWeight) in successors {
            if nodeCost + edgeWeight < costs[succ] ?? infinity {
                costs[succ] = nodeCost + edgeWeight
                parents[succ] = node
            }
        }
    }
    
    return buildPathTo(target, with: parents)
}

/**
 Finds the cheapest node at the given moment.
 
 - Parameters:
    - costs: Dictionary which contains costs of all nodes at the given moment.
    - explored: Ignored nodes which are already explored.
 
 - Returns: Min cost node at the given moment or `nil` if all nodes are already explored.
 */
private func findMinCostNode<T>(in costs: [T: Double], except explored: Set<T>) -> T? {
    return costs
        // ignoring already explored nodes.
        .filter { node, cost in !explored.contains(node) }
        // finding the min cost node. `value` corresponds to node cost.
        .min { cost1, cost2 in cost1.value < cost2.value}?
        // returning node object or `nil` if the min node was not found.
        .key
}

/**
 Builds a path to the given node starting from root.
 
 - Parameters:
    - target: Given node which represends the end of the path.
    - parents: Dictionary which contains parents of all graph nodes.
 
 - Returns: Array representing path to the `target` node starting from `root` or `nil` if invalid arguments provided.
 */
private func buildPathTo<T>(_ target: T, with parents: [T: T]) -> [T]? {
    guard parents[target] != nil else { return nil }
    
    var path = [T]()
    var node: T? = target
    while node != nil {
        path.append(node!)
        node = parents[node!]
    }
    return path.reversed()
}


func mainDijkstra() {
    let graph = [
        "Start": ["A": 5.0],
        "A": ["B": 7.0, "C": 4.0],
        "B": ["Finish": 4.0],
        "C": ["Finish": 3.0]
    ]

    print(
        dijkstra(in: graph, withRoot: "Start", findPathTo: "Finish") ?? "Path not found!"
    )
}