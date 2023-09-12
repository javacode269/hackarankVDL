package Graph;

// Java program to implement Directed Graph
// with the help of Generics

import java.util.*;


class DirectedGraph<T> {

    // We use Hashmap to store the edges in the graph
    private Map<T, List<T> > map = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex(T s)
    {
        map.put(s, new LinkedList<T>());
    }

    // This function adds the edge
    // between source to destination
    public void addEdge(T source,
                        T destination,
                        boolean bidirectional)
    {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }

    // This function gives the count of vertices
    public void getVertexCount()
    {
        System.out.println("The graph has "
                + map.keySet().size()
                + " vertex");
    }

    // This function gives the count of edges
    public void getEdgesCount(boolean bidirection)
    {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("The graph has "
                + count
                + " edges.");
    }

    // This function gives whether
    // a vertex is present or not.
    public void hasVertex(T s)
    {
        if (map.containsKey(s)) {
            System.out.println("The graph contains "
                    + s + " as a vertex.");
        }
        else {
            System.out.println("The graph does not contain "
                    + s + " as a vertex.");
        }
    }

    // This function gives whether an edge is present or not.
    public void hasEdge(T s, T d)
    {
        if (map.get(s).contains(d)) {
            System.out.println("The graph has an edge between "
                    + s + " and " + d + ".");
        }
        else {
            System.out.println("The graph has no edge between "
                    + s + " and " + d + ".");
        }
    }

    // Prints the adjancency list of each vertex.
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }


    //tiennv65 BFS
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[map.size()]; // Mảng đánh dấu các đỉnh đã thăm
        Queue<Integer> queue = new LinkedList<>(); // Hàng đợi để lưu trữ các đỉnh đang xét

        visited[startVertex] = true; // Đánh dấu đỉnh bắt đầu đã thăm
        queue.add(startVertex); // Thêm đỉnh bắt đầu vào hàng đợi

        while (!queue.isEmpty()) {
            int currVertex = queue.poll(); // Lấy một đỉnh từ hàng đợi
            System.out.print(currVertex + " "); // In đỉnh hiện tại

            List neighbors = map.get(currVertex);
            // Duyệt qua tất cả các đỉnh kề chưa thăm
            for (int i = 0; i < neighbors.size(); i++) {
                if (!visited[(int)neighbors.get(i)]) {
                    visited[(int)neighbors.get(i)] = true; // Đánh dấu đỉnh kề là đã thăm
                    queue.add((int)neighbors.get(i)); // Thêm đỉnh kề vào hàng đợi
                }
            }
        }
    }

    public static void main(String args[])
    {

        // Object of graph is created.
        DirectedGraph<Integer> g = new DirectedGraph<Integer>();

        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);

        // Printing the graph
        System.out.println("Graph:\n"
                + g.toString());

        // Gives the no of vertices in the graph.
        g.getVertexCount();

        // Gives the no of edges in the graph.
        g.getEdgesCount(true);

        // Tells whether the edge is present or not.
        g.hasEdge(3, 4);

        // Tells whether vertex is present or not
        g.hasVertex(5);

        g.BFS(0);

    }
}

