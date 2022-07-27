package Bhargava.Chapter6.GraphTraversal;

public class Vertex {
    private final char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        wasVisited = false;
    }

    public char getLabel() {
        return label;
    }

    public boolean wasVisited() {
        return wasVisited;
    }

    public void setWasVisited(final boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
}
