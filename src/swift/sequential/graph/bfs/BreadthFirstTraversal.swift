typealias Graph<T: Hashable> = [T: [T]]


func bfs<T>(in graph: Graph<T>, withRoot root: T) -> [T] {
    var explored = Set<T>()
    var traversed = [T]()
    var searchQueue = [root]
    var queuePopIndex = 0
    
    while queuePopIndex < searchQueue.count {
        let node = searchQueue[queuePopIndex]
        queuePopIndex += 1
        
        if !explored.contains(node) {
            explored.insert(node)
            traversed.append(node)
            if let successors = graph[node] {
                searchQueue += successors
            }
        }
    }
    return traversed
}


func mainBfs() {
    let graph = [
        "you": ["alice", "bob", "clair"],
        "alice": ["peggy"],
        "clair": ["thom", "jonny"],
        "bob": ["anuj", "peggy"]
    ]

    print(
        bfs(in: graph, withRoot: "you")
    )
}