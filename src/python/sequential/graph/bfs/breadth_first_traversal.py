import collections


def bfs(graph, root):
    """
    Performs breadth-first traversal on the :param graph: starting from the :param root: node.
    """
    explored = set()
    traversed = []
    search_queue = collections.deque()

    search_queue.append(root)
    while search_queue:
        node = search_queue.popleft()
        if node not in explored:
            explored.add(node)
            traversed.append(node)
            search_queue += graph.get(node, [])

    return traversed


def main():
    graph = {
        "you": ["alice", "bob", "clair"],
        "alice": ["peggy"],
        "clair": ["thom", "jonny"],
        "bob": ["anuj", "peggy"],
    }

    print(bfs(graph, "you"))

if __name__ == "__main__":
    main()
