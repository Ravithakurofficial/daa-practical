import java.util.*;

public class DijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(List<List<Node>> adjacencyList, int source) {
        int vertices = adjacencyList.size();
        int[] distance = new int[vertices];
        Arrays.fill(distance, INF);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));

        distance[source] = 0;
        priorityQueue.add(new Node(source, 0));

        while (!priorityQueue.isEmpty()) {
            int u = priorityQueue.poll().getNode();

            for (Node neighbor : adjacencyList.get(u)) {
                int v = neighbor.getNode();
                int weight = neighbor.getDistance();

                if (distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    priorityQueue.add(new Node(v, distance[v]));
                }
            }
        }

        printShortestPaths(distance);
    }

    private static void printShortestPaths(int[] distance) {
        System.out.println("Shortest Distances from Source:");

        for (int i = 0; i < distance.length; i++) {
            System.out.println("Vertex " + i + ": " + (distance[i] == INF ? "INF" : distance[i]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        List<List<Node>> adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter edges in the format (source destination weight):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();

            adjacencyList.get(source).add(new Node(destination, weight));
        }

        System.out.print("Enter the source vertex: ");
        int source = scanner.nextInt();

        dijkstra(adjacencyList, source);
    }

    private static class Node {
        private final int node;
        private final int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public int getNode() {
            return node;
        }

        public int getDistance() {
            return distance;
        }
    }
}
