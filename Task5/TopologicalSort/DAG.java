package TopologicalSort;

// Directed Acyclic Graph (비순환 방향 그래프)
public class DAG {
    public int V; //정점의 개수
    public int E; //간선의 개수
    public AdjList[] adj; //정점별 인접리스트의 배열

    //주어진 정점 개수로 그래프 생성하기
    public DAG(int V) {
        this.V = V;
        this.E = 0;
        adj = new AdjList[V];
        for(int v=0;v<V;v++)
            adj[v] = new AdjList();
    }

    //방향 그래프 : 정점 v 방향 간선 추가
    public void addEdge(int v, int w) {
        adj[v].insert(w); //v->w
        E++;
    }
}
