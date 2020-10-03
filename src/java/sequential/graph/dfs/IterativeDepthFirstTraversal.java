package sequential.graph.dfs;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;


public class IterativeDepthFirstTraversal {

    public static <T> Collection<T> dfs(Map<T, List<T>> graph, T root) {
        var explored = new LinkedHashSet<T>();
        var searchStack = new ArrayDeque<T>();

        searchStack.add(root);
        while (!searchStack.isEmpty()) {
            var node = searchStack.removeLast();
            if (!explored.contains(node)) {
                explored.add(node);
                searchStack.addAll(graph.getOrDefault(node, List.of()));
            }
        }
        return explored;
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