package Kruskal;

import java.util.Arrays;

//크루스칼 알고리즘 구현
public class Kruskal {
    public Edge[] mst; //MST에 포함된 Edge 배열
    public double cost; //MST의 최소비용(간선의 가중치 최소합)

    public Kruskal(WeightedGraph g) {
        mst = new Edge[g.V-1]; // MST의 Edge들
        cost = 0; // MST의 weight 합
        Edge[] pq = new Edge[g.E]; // 오름차순 정렬된 WeightedGraph의 Edge들

        int pqSize = 0;

        //Edge의 PQ 생성(정렬된 배열)
        // 1. WeightedGraph[인접리스트] => (pq=)Edge(v, w, weight)[배열]
        for(int v=0;v<g.V;v++) {
            Node node = g.adj[v].head;
            while(node != null) {
                if(v < node.vertex) { //i<j
                    pq[pqSize++] = new Edge(v, node.vertex, node.weight);
                }
                node = node.next;
            }
        }
        // 2. 가중치를 기준으로 오름차순 정렬
        Arrays.sort(pq, new Edge.weightOrder());

        //[탐욕적 알고리즘] Union-Find를 이용한 싸이클 탐지 버전의 크루스칼
        UnionFind uf = new UnionFind(g.V); // 서로소 집합으로 초기화
        int k = 0; //pq의 idx
        int n_mst_edges = 0; //MST의 idx (MST에 포함된 Edge의 수)
        while(n_mst_edges < g.V-1) { // [해답 체크]
            int p, q;
            Edge e = pq[k]; // [탐욕적 선택]pq에서 하나씩 가져와
            p = uf.find(e.v);
            q = uf.find(e.w);
            if(p != q) { // [적정성 체크]서로다른 집합에 속해있으면
                uf.union(p, q);
                mst[n_mst_edges++] = e; // mst에 추가
                cost += e.wt;
            }
            k++;
        }
    }
}
