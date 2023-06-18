package Graph;

import java.util.*;

public class BFS {
    private int V; // Số đỉnh trong đồ thị
    private LinkedList<Integer>[] adjList; // Danh sách kề

    public BFS(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Thêm cạnh vào đồ thị
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    // Hàm BFS
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[V]; // Mảng đánh dấu các đỉnh đã thăm
        Queue<Integer> queue = new LinkedList<>(); // Hàng đợi để lưu trữ các đỉnh đang xét

        visited[startVertex] = true; // Đánh dấu đỉnh bắt đầu đã thăm
        queue.add(startVertex); // Thêm đỉnh bắt đầu vào hàng đợi

        while (!queue.isEmpty()) {
            int currVertex = queue.poll(); // Lấy một đỉnh từ hàng đợi
            System.out.print(currVertex + " "); // In đỉnh hiện tại

            // Duyệt qua tất cả các đỉnh kề chưa thăm
            for (int neighbor : adjList[currVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Đánh dấu đỉnh kề là đã thăm
                    queue.add(neighbor); // Thêm đỉnh kề vào hàng đợi
                }
            }
        }
    }



    public static void main(String[] args) {
        int V = 6; // Số đỉnh trong đồ thị
        BFS BFS = new BFS(V);

        // Thêm các cạnh vào đồ thị
        BFS.addEdge(0, 1);
        BFS.addEdge(0, 2);
        BFS.addEdge(1, 3);
        BFS.addEdge(2, 3);
        BFS.addEdge(2, 4);
        BFS.addEdge(3, 4);
        BFS.addEdge(3, 5);

        System.out.println("BFS traversal starting from vertex 0:");
        BFS.BFS(0);
    }
}


