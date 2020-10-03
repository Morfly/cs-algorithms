package sequential.graph.dfs;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


class RecursiveDepthFirstTraversal {

    public static <T> Collection<T> dfs(Map<T, List<T>> graph, T root) {
        var explored = new LinkedHashSet<T>();

        explore(root, graph, explored);

        return explored;
    }

    private static <T> void explore(T node, Map<T, List<T>> graph, Set<T> explored) {
        explored.add(node);

        var successors = graph.getOrDefault(node, List.of());
        for (var succ : successors)
            if (!explored.contains(succ)) explore(node, graph, explored);
    }


    public static void main(String[] args) {
        var graph = Map.of(
                "you", List.of("alice", "bob", "clair"),
                "alice", List.of("peggy"),
                "clair", List.of("thom", "jonny"),
                "bob", List.of("anuj", "paggy")
        );

        System.out.println(
                dfs(graph, "you")
        );
    }
}