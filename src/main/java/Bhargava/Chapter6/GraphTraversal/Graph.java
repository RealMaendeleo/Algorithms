package Bhargava.Chapter6.GraphTraversal;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private final int MAX_VERTS = 10;
    private Vertex[] vertexArray;
    private int[][] adjMatrix;
    private int nVerts;
    private Queue<Integer> queue;
    private Stack<Integer> stack;

    public Graph() {
        vertexArray = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            Arrays.fill(adjMatrix[i], 0);
        }
        queue = new PriorityQueue<>();
        stack = new Stack<>();
    }

    public void addVertex(char label) {
        vertexArray[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexArray[v].getLabel());
    }

    public int getAdjUnvisitedVertex(int root) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMatrix[root][i] == 1 && !vertexArray[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    // обход в ширину
    public void bfs() {
        vertexArray[0].setWasVisited(true);
        displayVertex(0);
        queue.add(0);
        int adjacent;

        while (!queue.isEmpty()) {
            int root = queue.remove();

            while ((adjacent = getAdjUnvisitedVertex(root)) != -1) {
                vertexArray[adjacent].wasVisited = true;
                displayVertex(adjacent);
                queue.add(adjacent);
            }
        }
        // сброс флагов
        for (int i = 0; i < nVerts; i++) {
            vertexArray[i].setWasVisited(false);
        }
    }

    // обход в глубину
    public void dfs() {
        vertexArray[0].setWasVisited(true);
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            int adjacent = getAdjUnvisitedVertex(stack.peek());

            if (adjacent == -1) { // если непройденных смежных вершин нету
                stack.pop();
            } else {
                vertexArray[adjacent].setWasVisited(true);
                displayVertex(adjacent);
                stack.push(adjacent);
            }
        }
        // сброс флагов
        for (int i = 0; i < nVerts; i++) {
            vertexArray[i].setWasVisited(false);
        }
    }
}
