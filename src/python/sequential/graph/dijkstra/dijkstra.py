infinity = float("inf")


def dijkstra(graph, root, target):
    if root not in graph:
        return None

    costs = graph[root]
    explored = set()
    parents = {node: root for node in graph[root]}

    node = _find_min_cost_node(costs, explored)
    while node:
        explored.add(node)
        node_cost = costs[node]

        successors = graph.get(node, {})
        for (succ, edge_weight) in successors.items():
            if node_cost + edge_weight < (costs.get(succ) or infinity):
                costs[succ] = node_cost + edge_weight
                parents[succ] = node

        node = _find_min_cost_node(costs, explored)

    return _build_path_to_node(target, parents)

def _find_min_cost_node(costs, explored):
    # ignoring already explored nodes.
    costs = {node: cost for (node, cost) in costs.items() if node not in explored}
    # returning the min cost node or `None` if not found. `costs.get` corresponds to node cost.
    return min(costs, key=costs.get, default=None)

def _build_path_to_node(target, parents):
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