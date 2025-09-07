public class BellmanFordAlgorithm {
    // User function Template for Java

        public int[] bellmanFord(int V, int[][] edges, int src) {
            // code here
            int[] dist = new int[V];
            for (int i = 0; i < V; i++) dist[i] = (int) (1e8);
            dist[src] = 0;

            for (int count = 1; count <= V - 1; count++) {
                for (int[] edge : edges) {
                    int u = edge[0];
                    int v = edge[1];
                    int w = edge[2];

                    if (dist[u] != (int) (1e8)) {
                        if (dist[u] + w < dist[v]) {
                            dist[v] = dist[u] + w;
                        }
                    }
                }

            }
            //detect cycle
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[u] != (int) (1e8)) {
                    if (dist[u] + w < dist[v]) {
                        return new int[]{-1};
                    }
                }
            }
            return dist;
        }
}
