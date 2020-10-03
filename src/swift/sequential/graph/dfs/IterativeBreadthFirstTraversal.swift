typealias Graph<T: Hashable> = [T: [T]]


func dfs<T>(in graph: Graph<T>, withRoot root: T) -> [T] {
    var explored = Set<T>()
    var traversed = [T]()
    var searchStack = [root]
    
    while !searchStack.isEmpty {
        let node = searchStack.removeLast()
        
        if !explored.contains(node) {
            explored.insert(node)
            traversed.append(node)
            if let successors = graph[node] {
                searchStack += successors
            }
        }
    }
    return traversed
}


func dfsMain() {
    let graph = [
        "you": ["alice", "bob", "clair"],
        "alice": ["peggy"],
        "clair": ["thom", "jonny"],
        "bob": ["anuj", "peggy"]
    ]

    print(
        dfs(in: graph, withRoot: "you")
    )
}