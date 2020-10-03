def dfs(graph, root):
    """
    Performs recursive depth-first traversal on the :param graph: starting from the :param root: node.
    """
    explored = set()
    traversed = []

    def explore(node):
        explored.add(node)
        traversed.append(node)

        successors = graph.get(node, [])
        for succ in successors:
            if succ not in explored:
                explore(succ)

    explore(root)

    return traversed


def main():
    graph = {
        "you": ["alice", "bob", "clair"],
        "alice": ["peggy"],
        "clair": ["thom", "jonny"],
        "bob": ["anuj", "peggy"],
    }

    print(
        dfs(graph, "you")
    )

if __name__ == "__main__":
    main()