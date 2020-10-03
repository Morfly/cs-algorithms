typealias Graph<T: Hashable> = [T: [T]]


func dfs<T>(in graph: Graph<T>, withRoot root: T) -> [T] {
    var explored = Set<T>()
    var traversed = [T]()
    
    func explore(_ node: T) {
        explored.insert(node)
        traversed.append(node)

        guard let successors = graph[node] else { return }

        for succ in successors {
            if !explored.contains(succ) { 
                explore(succ) 
            }
        }
    }
    explore(root)
    
    return traversed
}


func mainDfs() {
    let graph = [
        "you": ["alice", "bob", "clair"],
        "alice": ["peggy"],
        "clair": ["thom", "jonny"],
        "bob": ["anuj", "peggy"]
    ]

    print(
        dfs(in:graph, withRoot: "you")
    )
}
