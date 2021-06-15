package GraphTraversal;

//너비우선탐색
public class BFS {
    public boolean[] visited; //정점의 방문여부
    public int[] edgeTo; //DFS에 포함되는 간선(edgeTo[i]->i)

    //시작정점을 s로 하는 너비우선탐색
    public BFS(Graph G, int s) {
        visited = new boolean[G.V];
        edgeTo = new int[G.V];
        Queue q = new Queue();

        visited[s] = true;
        q.enqueue(s);
        while(q.size > 0) {
            int v = q.dequeue();
            System.out.print(v+" "); //방문순서:코드 확인용

            Node node = G.adj[v].head;
            while(node != null) {
                int w = node.vertex;
                if(!visited[w]) { //정점 w를 아직 방문하지 않았으면
                    edgeTo[w] = v;
                    visited[w] = true;
                    q.enqueue(w);
                }
                node = node.next;
            }
            System.out.println();
        }
    }
}
