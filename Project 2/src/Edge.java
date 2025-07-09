import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Edge {
    Vertex from, to;  // Represents the vertices connected by this edge
    Line line;        // JavaFX Line object to visually represent the edge

    public Edge(Vertex from, Vertex to) {
        this.from = from;
        this.to = to;
        line = new Line(from.x, from.y, to.x, to.y);  // Create a line between the vertices
        line.setStroke(Color.LIGHTGRAY);              // Set the default color of the edge
    }

    // Returns the neighboring vertex of the given vertex 'v'
    public Vertex getNeighbor(Vertex v) {
        if (v == from) return to;
        if (v == to) return from;
        return null;
    }

    // Resets the edge color to default (LIGHTGRAY)
    public void reset() {
        line.setStroke(Color.LIGHTGRAY);
    }
}