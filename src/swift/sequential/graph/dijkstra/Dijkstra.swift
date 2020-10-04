typealias Graph<T: Hashable> = [T: [T: Double]]


let infinity = Double.infinity


func dijkstra<T>(in graph: Graph<T>, withRoot root: T, findPathTo target: T) -> [T]? {
    var costs = graph[root] ?? [:]
    var explored = Set<T>()
    var parents = graph[root]?.mapValues { cost in root } ?? [:]
    
    while let node = findMinCostNode(from: costs, except: explored) {
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

private func findMinCostNode<T>(from costs: [T: Double], except explored: Set<T>) -> T? {
    return costs
        .filter { node, cost in !explored.contains(node) }
        .min { a, b in a.value < b.value}?
        .key
}

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
    let graph: Graph<String> = [
        "Start": ["A": 5],
        "A": ["B": 7, "C": 4],
        "B": ["Finish": 4],
        "C": ["Finish": 3]
    ]

    print(
        dijkstra(in: graph, withRoot: "Start", findPathTo: "Finish") ?? "Path not found!"
    )
}