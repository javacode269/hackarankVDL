package Graph;
import java.util.Arrays;
public class FloydWarshallAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    private static void floydWarshall(int[][] graph) {
        int vertices = graph.length;
        int[][] distance = new int[vertices][vertices];

        // Khởi tạo ma trận khoảng cách ban đầu
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                distance[i][j] = graph[i][j];
            }
        }

        // Tìm đường đi ngắn nhất giữa tất cả các cặp đỉnh
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (distance[i][k] != INF && distance[k][j] != INF && distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        // In ra ma trận khoảng cách ngắn nhất
        System.out.println("Shortest distances between all pairs of vertices:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (distance[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(distance[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertices = 4; // Số đỉnh

        // Đồ thị có trọng số
        int[][] graph = {
                {0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };

        floydWarshall(graph);
    }
}


