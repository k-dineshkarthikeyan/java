public class Lab_8_Color_Graph {
    public static void main(String[] args) {
        int[][] graph = {
                { 0, 0, 1, 1, 0 },
                { 1, 0, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 1, 1, 0, 1 },
                { 0, 1, 1, 1, 0 }
        };
        Lab_8_Color_Graph graphColoring = new Lab_8_Color_Graph(graph);
        graphColoring.graphColoring();
    }

    private int V;
    private int[] colors;
    private int[][] graph;

    public Lab_8_Color_Graph(int[][] graph) {
        V = graph.length;
        colors = new int[V];
        this.graph = graph;
    }

    public boolean isSafe(int v, int c) {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && c == colors[i])
                return false;
        return true;
    }

    public boolean graphColoringUtil(int v) {
        if (v == V)
            return true;
        for (int c = 1; c <= V; c++)
            if (isSafe(v, c)) {
                colors[v] = c;
                if (graphColoringUtil(v + 1))
                    return true;
                colors[v] = 0;
            }
        return false;
    }

    public void graphColoring() {
        if (!graphColoringUtil(0))
            System.out.println("No solution");
        else {
            System.out.println("Possible colors are");
            for (int i = 0; i < V; i++)
                System.out.println("Vertex " + i + ": Color " + colors[i]);
        }
    }
}