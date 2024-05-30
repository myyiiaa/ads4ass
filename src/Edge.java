import java.util.*;

public class Edge<Vertex> {

    private Vertex source;
    private Vertex dest;
    private Double weight;
    public Edge(Vertex source, Vertex dest, Double weight){
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDest() {
        return dest;
    }

    public Double getWeight() {
        return weight;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public void setDest(Vertex dest) {
        this.dest = dest;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Edge<?> edge = (Edge<?>) object;
        return Objects.equals(source, edge.source) && Objects.equals(dest, edge.dest) && Objects.equals(weight, edge.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, dest, weight);
    }
}