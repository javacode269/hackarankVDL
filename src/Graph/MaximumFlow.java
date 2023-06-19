package Graph;

import java.util.*;

class MaximumFlow {
    private static final int V = 6;

    // Tìm đường đi tăng từ nguồn đến đích sử dụng DFS
    private boolean dfs(int[][] residualGraph, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        visited[source] = true;
        parent[source] = -1;

        while (!stack.isEmpty()) {
            int u = stack.pop();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && residualGraph[u][v] > 0) {
                    stack.push(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[sink];
    }

    // Tìm luồng cực đại trong mạng lưới
    public int maxFlow(int[][] graph, int source, int sink, int[][] flow) {
        int[][] residualGraph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                residualGraph[i][j] = graph[i][j];
            }
        }

        int[] parent = new int[V];
        int maxFlow = 0;

        while (dfs(residualGraph, source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;

            // Tìm lưu lượng tăng trên đường đi tìm được
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            // Cập nhật lưu lượng trên các cạnh và cạnh nghịch đảo
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
                flow[u][v] += pathFlow;
            }

            // Cộng lưu lượng tăng vào luồng cực đại
            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    // Hàm main
    public static void main(String[] args) {
        int[][] graph = {
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };

        int source = 0;
        int sink = 5;

        MaximumFlow maximumFlow = new MaximumFlow();
        int[][] flow = new int[V][V];
        int maxFlow = maximumFlow.maxFlow(graph, source, sink, flow);

        System.out.println("Luồng cực đại: " + maxFlow);
        System.out.println("Lưu lượng trên các cạnh:");

        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (graph[u][v] > 0) {
                    System.out.println("Cạnh " + u + " -> " + v + ": " + flow[u][v]);
                }
            }
        }
    }
}
