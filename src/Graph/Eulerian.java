package Graph;

import java.util.*;

// tìm chu trình Eulerian trong đồ thị vô hướng bằng thuật toán Fleury's
class Eulerian {
    private final int V; // Số đỉnh trong đồ thị
    private final LinkedList<Integer>[] adjList; // Danh sách kề

    public Eulerian(int V) {
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

    // Hàm kiểm tra xem đồ thị có liên thông không
    private boolean isConnected() {
        boolean[] visited = new boolean[V];

        // Tìm một đỉnh không rỗng trong đồ thị
        int nonEmptyVertex = -1;
        for (int i = 0; i < V; i++) {
            if (!adjList[i].isEmpty()) {
                nonEmptyVertex = i;
                break;
            }
        }

        // Nếu không tìm thấy đỉnh không rỗng, đồ thị không liên thông
        if (nonEmptyVertex == -1) {
            return true;
        }

        // Kiểm tra liên thông bằng DFS
        dfs(nonEmptyVertex, visited);

        // Kiểm tra xem tất cả các đỉnh có được thăm hay không
        for (int i = 0; i < V; i++) {
            if (!adjList[i].isEmpty() && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    // Hàm DFS để kiểm tra tính liên thông
    private void dfs(int startVertex, boolean[] visited) {
        visited[startVertex] = true;

        for (int neighbor : adjList[startVertex]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }

    // Hàm kiểm tra xem đỉnh có cạnh kề không
    private boolean hasAdjacentVertices(int v) {
        for (int i = 0; i < V; i++) {
            if (!adjList[i].isEmpty()) {
                return true;
            }
        }
        return false;
    }

    // Hàm kiểm tra xem đỉnh có là đỉnh cầu không
    private boolean isBridge(int u, int v) {
        // Xóa cạnh (u, v)
        adjList[u].remove(Integer.valueOf(v));
        adjList[v].remove(Integer.valueOf(u));

        // Kiểm tra xem đồ thị còn liên thông hay không sau khi xóa cạnh
        boolean connected = isConnected();

        // Khôi phục cạnh (u, v)
        adjList[u].add(v);
        adjList[v].add(u);

        return !connected;
    }

    // Hàm tìm chu trình Eulerian
    public List<Integer> findEulerianCycle() {
        List<Integer> cycle = new ArrayList<>();

        // Kiểm tra xem đồ thị có liên thông và có tồn tại cạnh nào không
        if (!isConnected() || !hasAdjacentVertices(0)) {
            return cycle;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Bắt đầu từ đỉnh 0

        while (!stack.isEmpty()) {
            int currentVertex = stack.peek();

            // Nếu đỉnh hiện tại không có cạnh kề, thêm nó vào chu trình và pop ra khỏi stack
            if (adjList[currentVertex].isEmpty()) {
                cycle.add(currentVertex);
                stack.pop();
            }
            // Nếu đỉnh hiện tại còn cạnh kề
            else {
                // Tìm một đỉnh kề chưa được xóa và không là đỉnh cầu
                int nextVertex = -1;
                for (int neighbor : adjList[currentVertex]) {
                    if (!isBridge(currentVertex, neighbor)) {
                        nextVertex = neighbor;
                        break;
                    }
                }

                // Nếu không tìm thấy đỉnh kề thích hợp, lấy đỉnh kề đầu tiên
                if (nextVertex == -1) {
                    nextVertex = adjList[currentVertex].get(0);
                }

                // Xóa cạnh giữa đỉnh hiện tại và đỉnh kề
                adjList[currentVertex].remove(Integer.valueOf(nextVertex));
                adjList[nextVertex].remove(Integer.valueOf(currentVertex));

                // Đẩy đỉnh kề vào stack để xét tiếp
                stack.push(nextVertex);
            }
        }

        return cycle;
    }

    public static void main(String[] args) {
        int V = 5; // Số đỉnh trong đồ thị
        Eulerian eulerian = new Eulerian(V);

        // Thêm các cạnh vào đồ thị
        eulerian.addEdge(0, 1);
        eulerian.addEdge(0, 2);
        eulerian.addEdge(1, 2);
        eulerian.addEdge(2, 3);
        eulerian.addEdge(3, 4);
        eulerian.addEdge(4, 0);

        List<Integer> eulerianCycle = eulerian.findEulerianCycle();

        if (eulerianCycle.isEmpty()) {
            System.out.println("Đồ thị không có chu trình Eulerian.");
        } else {
            System.out.println("Chu trình Eulerian trong đồ thị:");
            for (int vertex : eulerianCycle) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
}
