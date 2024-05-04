import java.util.*;

public class Lab4_StronglyConnectedDigraph {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        DirectedGraph graph = new DirectedGraph(numVertices);

        System.out.println("Enter the edges (format: source destination). Enter -1 to stop.");
        int source, destination;
        while (true) {
            source = scanner.nextInt();
            if (source == -1)
                break;
            destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }
        scanner.close();

        System.out.println("The strongly connected components of the given directed graph are");
        List<List<Integer>> sccs = graph.findStronglyConnectedComponents();
        for (List<Integer> scc : sccs)
            System.out.println(scc);
    }
}

class DirectedGraph {
    private int V;
    private List<Integer>[] adjacency_list;

    @SuppressWarnings("unchecked")
    DirectedGraph(int vertices) {
        V = vertices;
        adjacency_list = new ArrayList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjacency_list[i] = new ArrayList<>();
    }

    void addEdge(int source, int destination) {
        adjacency_list[source].add(destination);
    }

    List<List<Integer>> findStronglyConnectedComponents() {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] lowLinkValues = new int[V], ids = new int[V];
        Arrays.fill(ids, -1);

        for (int i = 0; i < V; ++i)
            if (ids[i] == -1)
                dfs(i, result, stack, lowLinkValues, ids, 0);

        return result;
    }

    void dfs(int node, List<List<Integer>> result, Stack<Integer> stack, int[] low, int[] ids, int id) {
        stack.push(node);
        low[node] = ids[node] = ++id;

        for (int adjacentNode : adjacency_list[node]) {
            if (ids[adjacentNode] == -1)
                dfs(adjacentNode, result, stack, low, ids, id);
            if (low[adjacentNode] < low[node])
                low[node] = low[adjacentNode];
        }

        if (low[node] == ids[node]) {
            List<Integer> component = new ArrayList<>();
            int currentNode;
            do {
                currentNode = stack.pop();
                component.add(currentNode);
                low[currentNode] = Integer.MAX_VALUE;
            } while (currentNode != node);
            result.add(component);
        }
    }
}