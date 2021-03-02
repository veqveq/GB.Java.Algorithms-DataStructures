package graph;

public class TestGraph {
    public static void main(String[] args) {
        testFindShortestPath();
    }

    public static void testFindShortestPath() {
        Graph graph = new Graph(10);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E", "B");
        graph.addVertex("F", "E");
        graph.addVertex("G", "C");
        graph.addVertex("H", "D");
        graph.addVertex("I", "H");
        graph.addVertex("X", "F", "G");

        graph.addEdge("A", "B", "C", "D");

        graph.findShortestPath("X", "A");
    }
}
