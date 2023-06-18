package Graph;

import java.util.*;

class HamiltonianCycle {
    private int V; // Số đỉnh trong đồ thị
    private int[] path; // Lưu trữ chu trình Hamilton
    private boolean[] visited; // Đánh dấu các đỉnh đã được thăm
    private int[][] graph; // Ma trận liền kề đồ thị

    public HamiltonianCycle(int V) {
        this.V = V;
        path = new int[V];
        visited = new boolean[V];
        graph = new int[V][V];
    }

    // Thêm cạnh vào đồ thị
    public void addEdge(int src, int dest) {
        graph[src][dest] = 1;
        graph[dest][src] = 1;
    }

    // Hàm kiểm tra xem có thể đi từ đỉnh v đến đỉnh next không
    private boolean isSafe(int v, int next) {
        if (graph[v][next] == 0 || visited[next]) {
            return false;
        }
        return true;
    }

    // Hàm đệ quy để tìm chu trình Hamilton
    private boolean hamiltonianCycleUtil(int v, int pos) {
        // Nếu đã đi qua tất cả các đỉnh
        if (pos == V) {
            // Kiểm tra xem có cạnh từ đỉnh cuối đến đỉnh đầu hay không
            if (graph[v][0] == 1) {
                return true; // Tìm thấy chu trình Hamilton
            }
            return false;
        }

        // Thử đi qua các đỉnh tiếp theo
        for (int next = 1; next < V; next++) {
            if (isSafe(v, next)) {
                path[pos] = next;
                visited[next] = true;

                // Đệ quy để đi tiếp
                if (hamiltonianCycleUtil(next, pos + 1)) {
                    return true;
                }

                // Backtrack nếu không tìm được chu trình Hamilton
                path[pos] = -1;
                visited[next] = false;
            }
        }

        return false; // Không tìm thấy chu trình Hamilton
    }

    // Hàm tìm chu trình Hamilton trong đồ thị
    public void findHamiltonianCycle() {
        Arrays.fill(path, -1);
        Arrays.fill(visited, false);

        // Bắt đầu từ đỉnh 0
        path[0] = 0;
        visited[0] = true;

        if (hamiltonianCycleUtil(0, 1)) {
            System.out.println("Chu trình Hamilton trong đồ thị:");
            for (int vertex : path) {
                System.out.print(vertex + " ");
            }
            System.out.println(path[0]); // In đỉnh đầu tiên để tạo chu trình
        } else {
            System.out.println("Không tìm thấy chu trình Hamilton trong đồ thị.");
        }
    }

    public static void main(String[] args) {
        int V = 5; // Số đỉnh trong đồ thị
        HamiltonianCycle hamiltonianCycle = new HamiltonianCycle(V);

        // Thêm các cạnh vào đồ thị
        hamiltonianCycle.addEdge(0, 1);
        hamiltonianCycle.addEdge(0, 3);
        hamiltonianCycle.addEdge(1, 2);
        hamiltonianCycle.addEdge(1, 3);
        hamiltonianCycle.addEdge(1, 4);
        hamiltonianCycle.addEdge(2, 4);
        hamiltonianCycle.addEdge(3, 4);

        hamiltonianCycle.findHamiltonianCycle();
    }
}
