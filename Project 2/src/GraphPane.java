import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.*;

public class GraphPane extends Pane {
    private final List<Vertex> vertices = new ArrayList<>();  // List to store vertices
    private final List<Edge> edges = new ArrayList<>();       // List to store edges
    private Vertex selectedVertex = null;                    // Currently selected vertex
    private Vertex startVertex = null;                       // Start vertex for BFS
    private int vertexCount = 1;                             // Counter for vertex names

    enum Mode { NONE, ADD_VERTEX, CONNECT }                  // Modes for user interaction

    private Mode currentMode = Mode.NONE;                    // Current mode

    public GraphPane() {
        setStyle("-fx-background-color: #36393f;");           // Set background color
        setOnMouseClicked(this::handleMouseClick);            // Handle mouse clicks
    }

    public void setMode(Mode mode) {
        currentMode = mode;
        selectedVertex = null;
    }

    // Handles mouse clicks based on the current mode
    private void handleMouseClick(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();

        switch (currentMode) {
            case ADD_VERTEX -> {
                String name = "V" + vertexCount++;
                Vertex v = new Vertex(name, x, y);
                vertices.add(v);
                getChildren().addAll(v.lineToLabel, v.circle, v.label);
            }
            case CONNECT -> {
                Vertex clicked = findVertexAt(x, y);
                if (clicked != null) {
                    if (selectedVertex == null) {
                        selectedVertex = clicked;
                    } else if (selectedVertex != clicked) {
                        Edge edge = new Edge(selectedVertex, clicked);
                        edges.add(edge);
                        getChildren().add(0, edge.line); // draw edges below nodes
                        selectedVertex = null;
                    }
                }
            }
        }
    }

    // Finds a vertex at the given coordinates
    private Vertex findVertexAt(double x, double y) {
        for (Vertex v : vertices) {
            if (v.contains(x, y)) return v;
        }
        return null;
    }

    // Sets the start vertex for BFS
    public void setStartVertex(String name) {
        for (Vertex v : vertices) {
            if (v.name.equalsIgnoreCase(name)) {
                startVertex = v;
                v.circle.setFill(Color.CYAN);
                return;
            }
        }
        System.out.println("Vertex not found: " + name);
    }

    // Runs BFS algorithm and visualizes it
    public void runBFS() {
        if (startVertex == null) {
            System.out.println("Start vertex not set.");
            return;
        }

        for (Vertex v : vertices) v.reset();
        for (Edge e : edges) e.reset();

        Queue<Vertex> queue = new LinkedList<>();
        startVertex.visited = true;
        startVertex.circle.setFill(Color.GREEN);
        queue.add(startVertex);

        new Thread(() -> {
            try {
                while (!queue.isEmpty()) {
                    Vertex current = queue.poll();

                    for (Edge e : edges) {
                        Vertex neighbor = e.getNeighbor(current);
                        if (neighbor != null && !neighbor.visited) {
                            neighbor.visited = true;
                            e.line.setStroke(Color.RED);
                            Thread.sleep(500);
                            neighbor.circle.setFill(Color.GREEN);
                            queue.add(neighbor);
                        }
                    }
                }
            } catch (InterruptedException ignored) {}
        }).start();
    }

    // Clears the graph and resets all states
    public void clear() {
        vertices.clear();
        edges.clear();
        getChildren().clear();
        vertexCount = 1;
        startVertex = null;
        selectedVertex = null;
        currentMode = Mode.NONE;
    }
}