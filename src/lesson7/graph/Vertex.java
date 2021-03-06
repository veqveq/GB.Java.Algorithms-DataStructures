package graph;

public class Vertex {
    private final String label;
    private boolean isVisited;
    private Vertex previous;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return label;
    }
}
