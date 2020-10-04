infinity = float("inf")


def dijkstra(graph, root, target):
    if root not in graph:
        return None

    costs = graph[root]
    explored = set()
    parents = {node: root for node in graph[root]}

    node = find_min_cost_node(costs, explored)
    while node:
        explored.add(node)
        node_cost = costs[node]

        successors = graph.get(node, {})
        for (succ, edge_cost) in successors.items():
            if node_cost + edge_cost < (costs.get(succ) or infinity):
                costs[succ] = node_cost + edge_cost
                parents[succ] = node

        node = find_min_cost_node(costs, explored)

    return build_path_to_node(target, parents)

def find_min_cost_node(costs, explored):
    costs = {node: cost for (node, cost) in costs.items() if node not in explored}
    return min(costs, key=costs.get, default=None)

def build_path_to_node(target, parents):
    if target not in parents:
        return None

    path = []
    node = target
    while node:
        path.append(node)
        node = parents.get(node)
    return path[::-1]


def main():
    graph = {
        "Start": {"A": 5},
        "A": {"B": 7, "C": 4},
        "B": {"Finish": 4},
        "C": {"Finish": 3},
    }

    print(
        dijkstra(graph, "Start", "Finish")
    )

if __name__ == "__main__":
    main()