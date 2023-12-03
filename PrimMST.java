import java.util.*;

class Graph {
    private int vertices;
    private List<List<Edge>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList.get(source).add(edge);
        edge = new Edge(destination, source, weight);
        adjacencyList.get(destination).add(edge);
    }

    public void primMST() {
        boolean[] inMST = new boolean[vertices];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        
        // Add the edges of the starting vertex to the priority queue
        inMST[0] = true;
        for (Edge edge : adjacencyList.get(0)) {
            priorityQueue.add(edge);
        }

        int totalWeight = 0;
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();

            if (!inMST[edge.getDestination()]) {
                inMST[edge.getDestination()] = true;
                totalWeight += edge.getWeight();
                System.out.println("Edge: " + edge.getSource() + " - " + edge.getDestination() + " Weight: " + edge.getWeight());

                for (Edge nextEdge : adjacencyList.get(edge.getDestination())) {
                    if (!inMST[nextEdge.getDestination()]) {
                        priorityQueue.add(nextEdge);
                    }
                }
            }
        }

        System.out.println("Total Weight of MST: " + totalWeight);
    }

    private static class Edge {
        private final int source;
        private final int destination;
        private final int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public int getSource() {
            return source;
        }

        public int getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }
    }
}

public class PrimMST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        Graph graph = new Graph(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter edges in the format (source destination weight):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(source, destination, weight);
        }

        System.out.println("Minimum Spanning Tree using Prim's Algorithm:");
        graph.primMST();
    }
}
