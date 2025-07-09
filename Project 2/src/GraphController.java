import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GraphController {
    private final BorderPane root;       // Main layout container
    private final GraphPane graphPane;   // Pane for displaying the graph

    public GraphController() {
        root = new BorderPane();
        graphPane = new GraphPane();

        root.setTop(createToolbar());    // Add toolbar at the top
        root.setCenter(graphPane);       // Add graph pane at the center
    }

    public BorderPane getRoot() {
        return root;
    }

    // Creates the toolbar with buttons and input fields
    private VBox createToolbar() {
        Button addVertexBtn = styledButton("➕ Add Vertex");
        addVertexBtn.setOnAction(e -> graphPane.setMode(GraphPane.Mode.ADD_VERTEX));

        Button connectBtn = styledButton("🔗 Connect");
        connectBtn.setOnAction(e -> graphPane.setMode(GraphPane.Mode.CONNECT));

        Button bfsBtn = styledButton("▶ Run BFS");
        bfsBtn.setOnAction(e -> graphPane.runBFS());

        Button clearBtn = styledButton("🧹 Clear");
        clearBtn.setOnAction(e -> graphPane.clear());

        TextField startField = new TextField();
        startField.setPromptText("Start Node (e.g. V1)");
        startField.setPrefWidth(150);
        startField.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-prompt-text-fill: gray; -fx-border-color: #444;");

        Button setStartBtn = styledButton("🎯 Set Start");
        setStartBtn.setOnAction(e -> graphPane.setStartVertex(startField.getText().trim()));

        HBox toolbar = new HBox(12, addVertexBtn, connectBtn, bfsBtn, clearBtn, startField, setStartBtn);
        toolbar.setPadding(new Insets(10));
        toolbar.setAlignment(Pos.CENTER_LEFT);
        toolbar.setStyle("-fx-background-color: #23272a;");

        Label title = new Label("📡 BFS Visualizer (JavaFX)");
        title.setFont(Font.font("Segoe UI", 20));
        title.setStyle("-fx-text-fill: white;");
        title.setPadding(new Insets(5, 0, 0, 10));

        VBox box = new VBox(title, toolbar);
        box.setStyle("-fx-background-color: #2c2f33; -fx-border-color: #444;");
        return box;
    }

    // Helper method to create styled buttons
    private Button styledButton(String text) {
        Button btn = new Button(text);
        btn.setStyle("-fx-background-color: #7289da; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 6;");
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: #5b6eae; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 6;"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: #7289da; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 6;"));
        return btn;
    }
}