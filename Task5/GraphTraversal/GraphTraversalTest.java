package GraphTraversal;

import java.io.*;

public class GraphTraversalTest {
    Graph g;
    public GraphTraversalTest(String fname) {
        readFile(fname);
    }

    public static void main(String[] args) {
        GraphTraversalTest gt = new GraphTraversalTest("Graph_11.txt");

        gt.printGraph();
        gt.printDFS(0);
        gt.printBFS(0);
        System.out.println("-----");
    }

    private void readFile(String fname) {
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(fname));
            int n = Integer.parseInt(in.readLine());
            int m = Integer.parseInt(in.readLine());
            g = new Graph(n);
            for(int i=0;i<m;i++) {
                String[] vs = new String[2]; String line = in.readLine();
                vs = line.split(" ");
                g.addEdge(Integer.parseInt(vs[0]), Integer.parseInt(vs[1]));
            }
            in.close();

        } catch(IOException e) {
            System.err.println("File Error");;
            System.exit(1);
        }
    }

    public void printGraph() {
        System.out.println("<GraphTraversal.Graph>");
        for(int v=0;v<g.V;v++) {
            System.out.print(v + " : ");
            Node node = g.adj[v].head;
            while(node != null) {
                System.out.print(node.vertex + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
    public void printDFS(int start) {
        System.out.println("<GraphTraversal.DFS>");
        DFS dfs = new DFS(g, start);
        for(int v=0; v< g.V; v++) {
            System.out.println(v + " : " + dfs.edgeTo[v]);
        }
    }
    public void printBFS(int start) {
        System.out.println("<GraphTraversal.BFS>");
        BFS bfs = new BFS(g, start);
        for(int v=0; v< g.V; v++) {
            System.out.println(v + " : " + bfs.edgeTo[v]);
        }
    }
}
