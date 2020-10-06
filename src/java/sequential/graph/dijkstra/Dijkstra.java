package sequential.graph.dijkstra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.Entry.comparingByValue;


class Dijkstra {

    // Infinity as a default vertex cost value.
    private static final double INFINITY = Double.POSITIVE_INFINITY;


    public static <T> List<T> dijkstra(Map<T, Map<T, Double>> graph, T root, T target) {
        if (!graph.containsKey(root)) throw new IllegalArgumentException("Invalid root vertex.");

        var costs = new HashMap<>(graph.get(root));
        var explored = new HashSet<T>();
        var parents = new HashMap<T, T>();
        for (var node : graph.get(root).keySet())
            parents.put(node, root);

        var node = findMinCostNode(costs, explored);
        while (node != null) {
            explored.add(node);
            var nodeCost = costs.get(node);

            var successors = graph.getOrDefault(node, Map.of());

            for (var succ : successors.keySet()) {
                var edgeWeight = successors.get(succ);
                if (nodeCost + edgeWeight < costs.getOrDefault(succ, INFINITY)) {
                    costs.put(succ, nodeCost + edgeWeight);
                    parents.put(succ, node);
                }
            }
            node = findMinCostNode(costs, explored);
        }

        return buildPathToNode(target, parents);
    }

    private static <T> T findMinCostNode(Map<T, Double> costs, Set<T> explored) {
        return costs.entrySet().stream()
                // ignoring already explored nodes.
                .filter(node -> !explored.contains(node.getKey()))
                // finding the min cost node. `value` corresponds to node cost.
                .min(comparingByValue())
                // returning node object or `null` if the min node was not found.
                .map(node -> node.getKey()).orElse(null);
    }

    private static <T> List<T> buildPathToNode(T target, Map<T, T> parents) {
        if (!parents.containsKey(target)) throw new IllegalArgumentException("Invalid target vertex.");

        var path = new LinkedList<T>();
        T node = target;
        while (node != null) {
            path.add(0, node);
            node = parents.get(node);
        }
        return path;
    }


    public static void main(String[] args) {
        var graph = Map.of(
                "Start", Map.of("A", 5.0),
                "A", Map.of("B", 7.0, "C", 4.0),
                "B", Map.of("Finish", 4.0),
                "C", Map.of("Finish", 3.0)
        );

        System.out.println(
                dijkstra(graph, "Start", "Finish")
        );
    }
}