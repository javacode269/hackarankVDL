package Graph;

import java.util.*;

// Creation of Adjacency List
// The adjacency List consist of an ArrayList within an
// ArrayList. The inner ArrayList holds the HashMap of
// (vertices,weight)
public class WeightGraph {
    int v;
    //Adjacency Vertex
    //Moi dinh se co day cac dinh ke
    ArrayList<ArrayList<HashMap<Integer, Integer> > > adj;
    WeightGraph(int v)
    {
        this.v = v;
        this.adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            this.adj.add(new ArrayList<>());
        }
    }
    // Function to add an Edge
    //W(u,v) = W(v,u)
    void addEdge(int u, int v, int weight)
    {
        this.adj.get(u).add(new HashMap<>());
        this.adj.get(u)
                .get(this.adj.get(u).size() - 1)
                .put(v, weight);

        this.adj.get(v).add(new HashMap<>());
        this.adj.get(v)
                .get(this.adj.get(v).size() - 1)
                .put(u, weight);
    }

    // Function for printing the whole graph
    // Stream API has been used
    // to easily access the HashMap elements
    // This code may not work in versions
    // prior to java 8

    void printGraph()
    {
        for (int i = 0; i < this.v; i++) {
            System.out.println("\nNode " + i
                    + " makes an edge with ");
            for (HashMap<Integer, Integer> j :
                    this.adj.get(i)) {
                j.entrySet().forEach(
                        e
                                -> System.out.println(
                                "\tNode " + e.getKey()
                                        + " with edge weight "
                                        + e.getValue() + " "));
            }
        }
    }


    public void BFS(int startVertex) {
        boolean[] visited = new boolean[v]; // Mảng đánh dấu các đỉnh đã thăm
        Queue<Integer> queue = new LinkedList<>(); // Hàng đợi để lưu trữ các đỉnh đang xét

        visited[startVertex] = true; // Đánh dấu đỉnh bắt đầu đã thăm
        queue.add(startVertex); // Thêm đỉnh bắt đầu vào hàng đợi

        while (!queue.isEmpty()) {
            int currVertex = queue.poll(); // Lấy một đỉnh từ hàng đợi
            System.out.print(currVertex + " "); // In đỉnh hiện tại

            ArrayList neighbors = adj.get(currVertex);
            System.out.println("DEBUG: Danh sach neighbor la " + neighbors );
            System.out.println("DEBUG: SL neighbor la " + neighbors.size() );


            // Duyệt qua tất cả các đỉnh kề chưa thăm
            for (int i = 0; i < neighbors.size(); i++){
//                if (!visited[(int)neighbors.get(i).]) {
//                    visited[(int)neighbors.get(i)] = true; // Đánh dấu đỉnh kề là đã thăm
//                    queue.add((int)neighbors.get(i)); // Thêm đỉnh kề vào hàng đợi
//                }

            }
        }
    }

    // Main method
    public static void main(String[] args)
    {
        int v = 5;
        WeightGraph obj = new WeightGraph(v);
        obj.addEdge(0, 1, 10);
        obj.addEdge(0, 4, 20);
        obj.addEdge(1, 2, 30);
        obj.addEdge(1, 3, 40);
        obj.addEdge(1, 4, 50);
        obj.addEdge(2, 3, 60);
        obj.addEdge(3, 4, 70);
        obj.printGraph();
        obj.BFS(3);
    }
}
// This code is submitted by Abhishek_Manna_HETC