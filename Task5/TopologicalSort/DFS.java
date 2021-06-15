package TopologicalSort;

//깊이우선탐색
public class DFS {
    public boolean[] visited; //정점의 방문여부
    public int[] edgeTo; //DFS에 포함되는 간선(edgeTo[i]->i)
    public Queue queue;

    //시작정점을 s로 하는 깊이우선탐색
    public DFS(DAG G) {
        visited = new boolean[G.V];
        edgeTo = new int[G.V];
        queue = new Queue();
    }

    //정점 v로부터 시작하는 깊이우선탐색 재귀 함수
    public void dfs(DAG G, int v) {
        visited[v] = true;
        edgeTo[v] = v; // ??
//        System.out.print(v+" "); //방문순서:코드 확인용
        queue.enqueue(v);
        Node node = G.adj[v].head;
        while(node != null) {
            int w = node.vertex;
            if(!visited[w]) { //정점 w를 아직 방문하지 않았으면
                edgeTo[w] = v;
                dfs(G, w);
            }
            node = node.next;
        }
    }
}
