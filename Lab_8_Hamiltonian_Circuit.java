public class Lab_8_Hamiltonian_Circuit {
    public static void main(String[] args) {
        int[][] graph = {
                { 0, 0, 1, 1, 0 },
                { 1, 0, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 1, 1, 0, 1 },
                { 0, 1, 1, 1, 0 }
        };
        hamiltonianCircuit(graph);
    }

    public static boolean findHamiltonianCircuit(int[][] graph, int[] path, boolean[] visited, int pos, int count) {
        int V = graph.length;
        if (count == V && graph[path[pos - 1]][path[0]] == 1)
            return true;
        for (int v = 0; v < V; v++) {
            if (graph[path[pos - 1]][v] == 1 && !visited[v]) {
                visited[v] = true;
                path[pos] = v;
                if (findHamiltonianCircuit(graph, path, visited, pos + 1, count + 1))
                    return true;
                visited[v] = false;
            }
        }
        return false;
    }

    public static boolean hamiltonianCircuit(int[][] graph) {
        int V = graph.length;
        int[] path = new int[V];
        boolean[] visited = new boolean[V];
        visited[0] = true;
        path[0] = 0;
        if (!findHamiltonianCircuit(graph, path, visited, 1, 1)) {
            System.out.println("No Hamiltonian Circuit exists.");
            return false;
        }
        System.out.println("Hamiltonian Circuit: ");
        for (int i = 0; i < V; i++)
            System.out.print(path[i] + " ");
        System.out.print(path[0] + " ");
        System.out.println();
        return true;
    }
}
