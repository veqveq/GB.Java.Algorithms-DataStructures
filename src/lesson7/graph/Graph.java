package lesson7.graph;

import java.util.*;

public class Graph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String value) {
        vertexList.add(new Vertex(value));
    }

    public void addVertex(String value, String... edges) {
        addVertex(value);
        addEdge(value, edges);
    }

    public void addEdge(String startVertex, String endVertex) {
        int startIndex = indexOf(startVertex);
        int endIndex = indexOf(endVertex);
        if (!contains(startVertex) || !contains(endVertex)) {
            throw new IllegalArgumentException("Start/end value not found in graph");
        } else {
            adjMat[startIndex][endIndex] = true;
            adjMat[endIndex][startIndex] = true;
        }
    }

    public void addEdge(String firstVertex, String secondVertex, String... other) {
        if (!contains(firstVertex) || !contains(secondVertex)) {
            throw new IllegalArgumentException("Argument not found");
        }
        addEdge(firstVertex, secondVertex);
        addEdge(firstVertex, other);

    }

    private void addEdge(String firstVertex, String... other) {
        for (String otherVertex : other) {
            if (!contains(otherVertex)) {
                throw new IllegalArgumentException("Argument not found");
            }
            addEdge(firstVertex, otherVertex);
        }
    }

    public void dfs(String start) {
        if (!contains(start)) {
            throw new IllegalArgumentException("Argument not found");
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex current = vertexList.get(indexOf(start));

        System.out.printf("%s ", current.getLabel());
        visit(stack, current);

        while (!stack.isEmpty()) {
            current = getNearestVertex(stack.peek());
            if (current == null) {
                stack.pop();
            } else {
                System.out.printf("%s ", current.getLabel());
                visit(stack, current);
            }
        }
        resetAllVertexesVisit();
    }

    public void bfs(String start) {
        if (!contains(start)) {
            throw new IllegalArgumentException("Argument not found");
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex current = vertexList.get(indexOf(start));

        System.out.printf("%s ", current.getLabel());
        visit(queue, current);

        while (!queue.isEmpty()) {
            current = getNearestVertex(queue.peek());
            if (current == null) {
                queue.remove();
            } else {
                System.out.printf("%s ", current.getLabel());
                visit(queue, current);
            }
        }
        resetAllVertexesVisit();
    }

    public void findShortestPath(String start, String finish) {

        if (!contains(start) || !contains(finish)) {
            throw new IllegalArgumentException("Arguments not found in graph");
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex targetVertex = null;
        Vertex current = vertexList.get(indexOf(start));
        Vertex previous;

        visit(queue, current);

        while (!queue.isEmpty()) {
            previous = queue.peek();
            current = getNearestVertex(queue.peek());
            if (current == null) {
                queue.remove();
            } else {
                if (current.getLabel().equals(finish)) {
                    targetVertex = current;
                    targetVertex.setPrevious(previous);
                    break;
                } else {
                    visit(queue, current);
                    current.setPrevious(previous);
                }
            }
        }
        printShortPath(targetVertex);
        resetAllVertexesVisit();
    }

    private void printShortPath(Vertex target) {
        StringBuilder sb = new StringBuilder();
        while (target != null) {
            sb.append(target.getLabel()).append(" >- ");
            target = target.getPrevious();
        }
        sb.delete(sb.length() - 4, sb.length());
        System.out.println(sb.reverse());
    }

    private void resetAllVertexesVisit() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private Vertex getNearestVertex(Vertex current) {
        int currentIndex = indexOf(current.getLabel());
        for (int i = 0; i < getSize(); i++) {
            if (adjMat[currentIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visit(Stack<Vertex> stack, Vertex current) {
        current.setVisited(true);
        stack.push(current);
    }

    private void visit(Queue<Vertex> queue, Vertex current) {
        current.setVisited(true);
        queue.add(current);
    }

    private int indexOf(String value) {
        for (int i = 0; i < getSize(); i++) {
            if (vertexList.get(i).getLabel().equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private boolean contains(String label) {
        return indexOf(label) != -1;
    }

    public int getSize() {
        return vertexList.size();
    }

    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> ");
                    System.out.print(vertexList.get(j));
                }
            }
            System.out.println();
        }
    }
}
