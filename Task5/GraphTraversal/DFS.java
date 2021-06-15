package GraphTraversal;

//깊이우선탐색
public class DFS {
    public boolean[] visited; //정점의 방문여부
    public int[] edgeTo; //DFS에 포함되는 간선(edgeTo[i]->i)

    //시작정점을 s로 하는 깊이우선탐색
    public DFS(Graph G, int s) {
        visited = new boolean[G.V];
        edgeTo = new int[G.V];
        edgeTo[s] = s;
        dfs(G, s);
    }

    //정점 v로부터 시작하는 깊이우선탐색 재귀 함수
    private void dfs(Graph G, int v) {
        visited[v] = true;
        System.out.print(v+" "); //방문순서:코드 확인용

        Node node = G.adj[v].head;
        while(node != null) {
            int w = node.vertex;
            if(!visited[w]) { //정점 w를 아직 방문하지 않았으면
                edgeTo[w] = v;
                dfs(G, w);
            }
            node = node.next;
        }
        System.out.println();
    }
}
