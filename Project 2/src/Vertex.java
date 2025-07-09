import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Vertex {
    String name;      // Name of the vertex (e.g., "V1")
    double x, y;      // Coordinates of the vertex
    boolean visited = false;  // Flag for BFS traversal
    Circle circle;    // JavaFX Circle to represent the vertex
    Text label;       // Text label for the vertex
    Line lineToLabel; // Line connecting the vertex to its label

    public Vertex(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;

        circle = new Circle(x, y, 20, Color.ORANGE);  // Create the circle
        label = new Text(x - 15, y + 35, name);       // Create the label
        label.setStyle("-fx-fill: white;");
        lineToLabel = new Line(x, y + 20, x, y + 30); // Create the connecting line
        lineToLabel.setStroke(Color.GRAY);
    }

    // Checks if the given coordinates are inside the vertex's circle
    public boolean contains(double px, double py) {
        return Math.hypot(px - x, py - y) <= 20;
    }

    // Resets the vertex's state (color and visited flag)
    public void reset() {
        visited = false;
        circle.setFill(Color.ORANGE);
    }
}