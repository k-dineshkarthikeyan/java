import java.util.Arrays;

public class FloydWarshall {

    static final int INF = Integer.MAX_VALUE;
    static int[][] graph = {{0, 4, 11}, {6, 0, 2}, {3, INF, 0}};

    static void floydWarshall(int[][] graph) {
        int V = graph.length, i, j, k;
        int[][] dist = Arrays.copyOf(graph, V);

        for (k = 0; k < V; k++)
            for (i = 0; i < V; i++)
                for (j = 0; j < V; j++)
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        for (i = 0; i < V; ++i) {
            for (j = 0; j < V; ++j) {
                System.out.print(dist[i][j] == INF ? "INF " : dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        floydWarshall(graph);
    }
}