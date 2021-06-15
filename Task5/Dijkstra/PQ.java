package Dijkstra;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PQ {
    int v;
    int w;
    double wt;

    ArrayList<Edge> pq;
    public PQ() {
        pq = new ArrayList<Edge>();
    }
    public void sort() {
        pq.sort(new Edge.weightOrder());
    }
    public void enqueue(int v, int w, double dist) {
        Edge n = new Edge(v, w, dist);
        pq.add(n);
        sort();
    }
    public Edge dequeue() {
        return pq.remove(0);
    }
}
