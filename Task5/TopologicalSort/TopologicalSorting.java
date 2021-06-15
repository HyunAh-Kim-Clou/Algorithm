package TopologicalSort;

import java.util.Stack;

public class TopologicalSorting {
    public DAG g;
    public Queue res;
    boolean[] visited;
    int[] edgeTo;
    public TopologicalSorting(DAG G) {
        this.g = G;
        visited = new boolean[G.V];
        edgeTo = new int[G.V];

        res = traverse(0);
        for (int i = 0; i < G.V; i++) {
            if (!visited[i]) {
                Queue tmp = traverse(i);

                tmp.last.next = res.first;
                res.size += tmp.size;
                res.first = tmp.first;
            }
        }
    }

    public Queue traverse(int start) {
        Queue q = new Queue();
        Stack<Integer> tmp = new Stack<>();
        Queue revPost = new Queue();

        revPost.enqueue(start);
        visited[start] = true;
        q.enqueue(start);
        while(q.size > 0) {
            int v = q.dequeue();

            if (!visited[v])
                tmp.push(v);
            Node node = g.adj[v].head;
            while(node != null) { // 서브들 순회
                int w = node.vertex;
                if(!visited[w]) { //정점 w를 아직 방문하지 않았으면
                    edgeTo[w] = v;
                    visited[w] = true;
                    q.enqueue(w);

                    tmp.push(w);
                }
                while (!tmp.empty()) {
                    revPost.enqueue(tmp.pop());
                }
                node = node.next;
            }
        }
        return revPost;
    }
}
