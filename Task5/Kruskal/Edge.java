package Kruskal;

import java.util.Comparator;

//MST Edge
public class Edge {
    int v;
    int w;
    double wt;

    public Edge(int v, int w, double wt) {
        this.v = v;
        this.w = w;
        this.wt = wt;
    }

    //Edge 가중치를 기준으로 오름차순 비교기
    public static class weightOrder implements Comparator<Edge> {
        public int compare(Edge e1, Edge e2) {
            if(e1.wt < e2.wt) return -1;
            if(e1.wt > e2.wt) return 1;
            return 0;
        }
    }
}
