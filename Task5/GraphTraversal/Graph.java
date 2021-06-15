package GraphTraversal;

// 그래프
public class Graph {
    public int V; //정점의 개수
    public int E; //간선의 개수
    public AdjList[] adj; //정점별 인접리스트의 배열

    //주어진 정점 개수로 그래프 생성하기
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new AdjList[V]; for(int v=0;v<V;v++)
            adj[v] = new AdjList();
    }

    //비방향 그래프 : 정점 v와 정점 w를 잇는 양방향 간선 추가
    public void addEdge(int v, int w) {
        adj[v].insert(w); //v->w
        adj[w].insert(v); //w->v
        E++;
    }
}
