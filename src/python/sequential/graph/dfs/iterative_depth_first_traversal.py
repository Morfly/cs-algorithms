import collections


def dfs(graph, root):
    """
    Performs iterative depth-first traversal on the :param graph: starting from the :param root: node.
    """
    explored = set()
    traversed = []
    search_stack = collections.deque()

    search_stack.append(root)
    while search_stack:
        node = search_stack.pop()
        if node not in explored:
            explored.add(node)
            traversed.append(node)
            search_stack += graph.get(node, [])

    return traversed


def main():
    graph = {
        "you": ["alice", "bob", "clair"],
        "alice": ["peggy"],
        "clair": ["thom", "jonny"],
        "bob": ["anuj", "peggy"],
    }

    print(dfs(graph, "you"))

if __name__ == "__main__":
    main()
