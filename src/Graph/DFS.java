package Graph;

import java.util.*;

public class DFS {
    private int V; // Số đỉnh trong đồ thị
    private LinkedList<Integer>[] adjList; // Danh sách kề

    public DFS(int V) {
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

    // Hàm DFS sử dụng đệ quy
    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true; // Đánh dấu đỉnh hiện tại đã thăm
        System.out.print(vertex + " "); // In đỉnh hiện tại

        // Duyệt qua tất cả các đỉnh kề chưa thăm
        for (int neighbor : adjList[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited); // Gọi đệ quy để thăm đỉnh kề
            }
        }
    }

    // Hàm DFS bắt đầu từ đỉnh startVertex
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[V]; // Mảng đánh dấu các đỉnh đã thăm

        DFSUtil(startVertex, visited);
    }

    public static void main(String[] args) {
        int V = 6; // Số đỉnh trong đồ thị
        DFS DFS = new DFS(V);

        // Thêm các cạnh vào đồ thị
        DFS.addEdge(0, 1);
        DFS.addEdge(0, 2);
        DFS.addEdge(1, 3);
        DFS.addEdge(2, 3);
        DFS.addEdge(2, 4);
        DFS.addEdge(3, 4);
        DFS.addEdge(3, 5);

        System.out.println("DFS traversal starting from vertex 0:");
        DFS.DFS(0);
    }
}
