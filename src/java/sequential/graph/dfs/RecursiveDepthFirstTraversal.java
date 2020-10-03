package sequential.graph.dfs;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


class RecursiveDepthFirstTraversal<T> {

    private Map<T, List<T>> graph;
    private Set<T> explored;

    public Collection<T> dfs(Map<T, List<T>> graph, T root) {
        this.graph = graph;
        explored = new LinkedHashSet<>();

        explore(root);

        return explored;
    }

    private void explore(T node) {
        explored.add(node);

        var successors = graph.getOrDefault(node, List.of());
        for (var succ : successors)
            if (!explored.contains(succ)) explore(succ);
    }


    public static void main(String[] args) {
        var graph = Map.of(
                "you", List.of("alice", "bob", "clair"),
                "alice", List.of("peggy"),
                "clair", List.of("thom", "jonny"),
                "bob", List.of("anuj", "paggy")
        );

        System.out.println(
            new RecursiveDepthFirstTraversal().dfs(graph, "you")
        );
    }
}