
import java.util.*;

public class BFS<Vertex> extends Search <Vertex> {
    public BFS(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current);
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();

            for (Vertex neighbor : graph.adjacencyList(v)) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, v);
                    queue.add(neighbor);
                }
            }
        }
    }
}