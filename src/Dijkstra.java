
import java.util.*;


public class Dijkstra<Vertex> extends Search<Vertex> {
    private final Set<Vertex> unsettledNodes;
    private final Map<Vertex, Double> distances;
    private final WeightedGraph<Vertex> graph;

    public Dijkstra(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;

        // Initialize the source node distance to zero and perform Dijkstra's algorithm
        distances.put(source, 0D);
        unsettledNodes.add(source);

        dijkstra();
    }

    private void dijkstra() {
        while (!unsettledNodes.isEmpty()) {
            Vertex currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            for (Vertex neighbor : graph.adjacencyList(currentNode)) {
                double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, neighbor);

                if (newDistance < getShortestDistance(neighbor)) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode);
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private double getDistance(Vertex node, Vertex target) {
        for (Edge<Vertex> edge : graph.getEdges(node)) {
            if (edge.getDest().equals(target)) {
                return edge.getWeight();
            }
        }

        throw new RuntimeException("Edge not found between " + node + " and " + target);
    }

    private Vertex getVertexWithMinimumWeight(Set<Vertex> vertices) {
        Vertex minimum = null;
        double minDistance = Double.MAX_VALUE;

        for (Vertex vertex : vertices) {
            double vertexDistance = getShortestDistance(vertex);
            if (vertexDistance < minDistance) {
                minDistance = vertexDistance;
                minimum = vertex;
            }
        }

        return minimum;
    }

    private double getShortestDistance(Vertex destination) {
        return distances.getOrDefault(destination, Double.MAX_VALUE);
    }
}