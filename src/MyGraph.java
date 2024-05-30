import java.util.*;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private Map<Vertex, List<Vertex>> list= new HashMap<>();

    public MyGraph() {
        this(true);
    }
    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex vertex) {
        list.put(vertex, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex destination) {
        checkVertex(source);
        checkVertex(destination);
        list.get(source).add(destination);
        list.get(destination).add(source);
    }

    private void checkVertex(Vertex vertex) {
        if (!list.containsKey(vertex))
            throw new IndexOutOfBoundsException("Vertex does not exist");
    }

    public boolean hasEdge(Vertex source, Vertex destination) {
        checkVertex(source);
        checkVertex(destination);
        List<Vertex> neighbors = adjacencyList(source);
        return neighbors != null && neighbors.contains(destination);
    }

    public List<Vertex> adjacencyList(Vertex v) {
        return list.get(v);
    }

    public void printGraph() {
        for(Vertex vertex : list.keySet()) {
            System.out.println("Vertex '" + vertex + "' is connected to " + adjacencyList(vertex));
        }
    }

    public void removeEdge(Vertex source, Vertex destination) {
        checkVertex(source);
        checkVertex(destination);

        list.get(source).remove(destination);
        list.get(destination).remove(source);
    }
}