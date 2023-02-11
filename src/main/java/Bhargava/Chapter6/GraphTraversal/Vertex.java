package Bhargava.Chapter6.GraphTraversal;

import java.util.Objects;

public class Vertex {
    private final char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        wasVisited = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return label == vertex.label && wasVisited == vertex.wasVisited;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, wasVisited);
    }

    public char getLabel() {
        return label;
    }

    public boolean wasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
}
