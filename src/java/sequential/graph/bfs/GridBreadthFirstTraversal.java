package sequential.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;


public class GridBreadthFirstTraversal {

    private final static int[] ROW_DIRECTIONS = {0, -1, 0, 1};
    private final static int[] COL_DIRECTIONS = {-1, 0, 1, 0};

    private static class Vertex {
        final int row, col;

        public Vertex(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public static <T> Collection<T> bfs(T[][] graph, int rootRow, int rootCol) {
        if (!isGraphValid(graph, rootRow, rootCol)) throw new IllegalArgumentException("Invalid graph.");

        int rows = graph.length;
        int cols = graph[0].length;

        var explored = new boolean[rows][cols];
        var traversed = new ArrayList<T>();
        var searchQueue = new ArrayDeque<Vertex>();

        searchQueue.add(new Vertex(rootRow, rootCol));
        while (!searchQueue.isEmpty()) {
            var vertex = searchQueue.removeFirst();
            int row = vertex.row;
            int col = vertex.col;

            if (!explored[row][col] && graph[row][col] != null) {
                explored[row][col] = true;
                traversed.add(graph[row][col]);

                for (int i = 0; i < 4; i++) {
                    int nextRow = row + ROW_DIRECTIONS[i];
                    int nextCol = col + COL_DIRECTIONS[i];

                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                        searchQueue.add(new Vertex(nextRow, nextCol));
                    }
                }
            }
        }
        return traversed;
    }

    private static <T> boolean isGraphValid(T[][] graph, int rootRow, int rootCol) {
        // check if graph is not empty.
        if (graph.length == 0 || graph[0].length == 0) return false;

        int rows = graph.length;
        int cols = graph[0].length;

        // check if root vertex is valid.
        if (rootRow < 0 || rootRow >= rows || rootCol < 0 || rootCol >= cols) return false;

        // check if graph dimensions are valid.
        for (var row : graph)
            if (row.length != cols) return false;

        return true;
    }


    public static void main(String[] args) {
        Integer[][] graph = {
                {3, 2, 1},
                {1, 4, 4},
                {9, 3, null}
        };

        System.out.println(
                bfs(graph, 0, 0)
        );
    }
}
