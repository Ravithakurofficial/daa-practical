import java.util.Arrays;

class BellmanFord {
    static class Edge {
        int source, destination, weight;

        Edge() {
            source = destination = weight = 0;
        }
    }

    int V, E; // V -> Number of vertices, E -> Number of edges
    Edge edge[];

    BellmanFord(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    void BellmanFordAlgorithm(BellmanFord graph, int source) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

        // Initialize distances from the source to all other vertices as INFINITE
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].source;
                int v = graph.edge[j].destination;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Check for negative-weight cycles
        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].source;
            int v = graph.edge[j].destination;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // Print the distances
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 8; // Number of edges

        BellmanFord graph = new BellmanFord(V, E);

        // Example graph
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = -1;

        graph.edge[1].source = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 4;

        graph.edge[2].source = 1;
        graph.edge[2].destination = 2;
        graph.edge[2].weight = 3;

        graph.edge[3].source = 1;
        graph.edge[3].destination = 3;
        graph.edge[3].weight = 2;

        graph.edge[4].source = 1;
        graph.edge[4].destination = 4;
        graph.edge[4].weight = 2;

        graph.edge[5].source = 3;
        graph.edge[5].destination = 2;
        graph.edge[5].weight = 5;

        graph.edge[6].source = 3;
        graph.edge[6].destination = 1;
        graph.edge[6].weight = 1;

        graph.edge[7].source = 4;
        graph.edge[7].destination = 3;
        graph.edge[7].weight = -3;

        int source = 0;
        graph.BellmanFordAlgorithm(graph, source);
    }
}
