package Graph;
import java.util.*;

public class DijkstraAlgorithm {

    private static final int INF = Integer.MAX_VALUE; // Giá trị vô cùng

    public static void dijkstra(int[][] graph, int source) {
        int n = graph.length; // Số đỉnh trong đồ thị

        // Tạo một mảng để lưu trữ khoảng cách ngắn nhất từ đỉnh xuất phát đến các đỉnh khác
        int[] distance = new int[n];
        Arrays.fill(distance, INF); // Khởi tạo tất cả khoảng cách là vô cùng
        distance[source] = 0; // Khoảng cách từ đỉnh xuất phát đến chính nó là 0

        // Tạo một mảng để lưu trữ đỉnh cha trên đường đi từ đỉnh xuất phát đến các đỉnh khác
        int[] parent = new int[n];
        Arrays.fill(parent, -1); // Khởi tạo tất cả đỉnh cha là -1

        // Tạo một hàng đợi ưu tiên để lưu trữ các đỉnh và khoảng cách tương ứng
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int vertex = node[0];
            int dist = node[1];

            if (dist > distance[vertex]) {
                continue;
            }

            // Duyệt qua các đỉnh kề của đỉnh hiện tại
            for (int i = 0; i < n; i++) {
                int weight = graph[vertex][i];
                if (weight != 0 && distance[vertex] != INF && distance[vertex] + weight < distance[i]) {
                    distance[i] = distance[vertex] + weight;
                    parent[i] = vertex;
                    pq.offer(new int[]{i, distance[i]});
                }
            }
        }

        // In ra độ dài quãng đường đi ngắn nhất và đường đi tương ứng
        System.out.println("Shortest distances from source vertex:");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + ": " + distance[i]);
            System.out.print("Path: ");
            printPath(parent, i);
            System.out.println();
        }
    }

    // Hàm đệ quy để in ra đường đi từ đỉnh xuất phát đến một đỉnh
    private static void printPath(int[] parent, int vertex) {
        if (vertex == -1) {
            return;
        }
        printPath(parent, parent[vertex]);
        System.out.print(vertex + " ");
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int source = 0; // Đỉnh xuất phát

        dijkstra(graph, source); // Đầu ra là độ dài ngắn nhất từ A->C và quãng đường tương ứng (A->B->C)
    }
}

