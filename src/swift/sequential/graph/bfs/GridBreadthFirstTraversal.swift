typealias Graph<T> = [[T]]


let directions = [(0, -1), (-1, 0), (0, 1), (1, 0)]


func bfs<T>(in graph: Graph<T?>, withRoot root: (row: Int, col: Int)) -> [T]? {
    guard isValid(graph, startingAt: root) else { return nil }
    
    let rows = graph.count
    let cols = graph[0].count
    let rowBounds = 0..<rows
    let colBounds = 0..<cols
    
    var explored = Array(repeating: Array(repeating: false, count: cols), count: rows)
    var traversed = [T]()
    var searchQueue = [root]
    var queuePopIndex = 0
    
    while queuePopIndex < searchQueue.count {
        let (row, col) = searchQueue[queuePopIndex]
        queuePopIndex += 1
        
        if !explored[row][col], let value = graph[row][col] {
            explored[row][col] = true
            traversed.append(value)
            
            for (stepRow, stepCol) in directions {
                let nextRow = row + stepRow
                let nextCol = col + stepCol
                
                if rowBounds ~= nextRow && colBounds ~= nextCol  {
                    searchQueue.append((nextRow, nextCol))
                }
            }
        }
    }
    
    return traversed
}

func isValid<T>(_ graph: Graph<T?>, startingAt root: (row: Int, col: Int)) -> Bool {
    if graph.isEmpty || graph[0].isEmpty { return false }
    
    let rows = graph.count
    let cols = graph[0].count
    
    if !(0..<rows).contains(root.row) || !(0..<cols).contains(root.col) { return false }
    
    for row in graph {
        if row.count != cols { return false }
    }
    return true
}


func mainBfs() {
    let graph = [
        [1, 5, 6],
        [9, 2, 4],
        [9, 7, nil],
    ]
    
    
    print(
        bfs(in: graph, withRoot: (0, 0)) ?? "Invalid graph"
    )
}