# BFS-Visualiser
BFS Routing Visualization - README

Introduction
This project visualizes the Breadth-First Search (BFS) algorithm for graph traversal, particularly for understanding routing in computer networks. The application allows users to add vertices (representing routers or devices), connect them with edges (representing communication links), and simulate BFS routing from a chosen starting node.

Features
- Add vertices and edges dynamically.
- Visualize BFS traversal step-by-step.
- Reset graph and rerun simulation.
- Highlights visited nodes and paths.

Requirements
This application is built using JavaFX, so make sure the following requirements are met:
- Java Development Kit (JDK) 8 or higher
- JavaFX SDK (if using JDK version below 11)
- IDE like IntelliJ IDEA or Eclipse (with JavaFX plugin if needed)

How to Run
1. Open the project in your preferred Java IDE.
2. Compile and run the Main class.
3. Use the interface to add vertices, connect them with edges, and start the BFS traversal.
File Structure
- Main.java: Entry point of the application.
- GraphPane.java: Responsible for rendering the graph and handling user interactions.
- Vertex.java / Edge.java: Data structures for graph components.

Usage Example
1. Click 'Add Vertex' to place nodes on the canvas.
2. Click 'Add Edge' to connect two vertices.
3. Select a start vertex and click 'Start BFS' to see the routing path.

License
This project is for educational purposes and is released under the MIT License.
