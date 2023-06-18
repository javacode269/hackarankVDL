package Graph;

import java.util.*;

public class KruskalAlgorithm {
    private static class Edge implements Comparable<Edge> {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    private static int find(int[] parent, int vertex) {
        if (parent[vertex] == -1) {
            return vertex;
        }
        return find(parent, parent[vertex]);
    }

    private static void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }

    private static void kruskalMST(int[][] graph, int vertices) {
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        Collections.sort(edges);

        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        List<Edge> mst = new ArrayList<>();

        int edgeCount = 0;
        int index = 0;

        while (edgeCount < vertices - 1) {
            Edge edge = edges.get(index);
            int sourceParent = find(parent, edge.source);
            int destinationParent = find(parent, edge.destination);

            if (sourceParent != destinationParent) {
                mst.add(edge);
                union(parent, sourceParent, destinationParent);
                edgeCount++;
            }

            index++;
        }

        // In ra cây bao trùm nhỏ nhất
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination);
        }
    }

    public static void main(String[] args) {
        int vertices = 5; // Số đỉnh

        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        kruskalMST(graph, vertices);
    }
}

