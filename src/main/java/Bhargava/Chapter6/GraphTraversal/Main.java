package Bhargava.Chapter6.GraphTraversal;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('a'); // 0
        graph.addVertex('b'); // 1
        graph.addVertex('c'); // 2
        graph.addVertex('d'); // 3
        graph.addVertex('e'); // 4
        graph.addVertex('f'); // 5

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("Visits: ");
        graph.bfs();

        System.out.println("\nVisits: ");
        graph.dfs();
    }
}
