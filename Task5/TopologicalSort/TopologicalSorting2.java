package TopologicalSort;

public class TopologicalSorting2 {
    public DAG g;
    public Queue dfs;
    public TopologicalSorting2(DAG G) {
        this.g = G;

        DFS trav = new DFS(G);
        trav.dfs(G, 0);
        dfs = trav.queue;
        for (int i = 0; i < G.V; i++) {
            if (!trav.visited[i]) {
                DFS tmp = new DFS(G);
                tmp.visited = trav.visited;
                tmp.dfs(G, i);

                tmp.queue.last.next = dfs.first;
                dfs.size += tmp.queue.size;
                dfs.first = tmp.queue.first;
            }
        }
    }
}
