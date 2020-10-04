package sequential.graph.dijkstra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


class Dijkstra<T> {

    private static final double INFINITY = Double.POSITIVE_INFINITY;


    public static <T> List<T> dijkstra(Map<T, Map<T, Double>> graph, T root, T target) {
        var rootSuccessors = graph.getOrDefault(root, Map.of());

        var costs = new HashMap<>(rootSuccessors);
        var explored = new HashSet<T>();
        var parents = new HashMap<T, T>();
        for (var node : rootSuccessors.keySet())
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
        var minCost = INFINITY;
        T minCostNode = null;
        for (var node : costs.keySet()) {
            var cost = costs.get(node);
            if (!explored.contains(node) && cost < minCost) {
                minCost = cost;
                minCostNode = node;
            }
        }
        return minCostNode;
    }

    private static <T> List<T> buildPathToNode(T target, Map<T, T> parents) {
        if (!parents.containsKey(target))
            throw new IllegalArgumentException("Invalid arguments provided.");

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