import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        GraphController controller = new GraphController();  // Create the controller
        Scene scene = new Scene(controller.getRoot(), 1000, 700);  // Create the scene with the controller's root pane
        primaryStage.setTitle("BFS Visualizer - JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();  // Display the stage
    }

    public static void main(String[] args) {
        launch(args);  // Launch the JavaFX application
    }
}