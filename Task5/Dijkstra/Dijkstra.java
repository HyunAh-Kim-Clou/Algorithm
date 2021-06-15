package Dijkstra;

import java.util.Arrays;

//다익스트라
public class Dijkstra {
    public double[] distTo; // SP의 weight 합
    public int[] edgeTo; // SP의 직전 정점
    public PriorityQueue pq;

    public Dijkstra(WeightedGraph g, int s) {
        distTo = new double[g.V];
        edgeTo = new int[g.V];
        pq = new PriorityQueue();

        Arrays.fill(distTo, 999.99); //배열의 모든요소들 초기화
        distTo[s] = 0;
        pq.enqueue(s, 0.0);
        while (pq.size != 0) {
            Node v = pq.dequeue();
//            System.out.println(" <삭제>: ("+v.vertex+", "+v.weight+")");

            Node w = g.adj[v.vertex].head;
            while(w != null) {
                if (distTo[w.vertex] > distTo[v.vertex]+w.weight) {
//                    System.out.println(" - "+w.vertex+" weight: "+distTo[w.vertex]+" -> "+(distTo[v.vertex]+w.weight));
                    distTo[w.vertex] = distTo[v.vertex]+w.weight;
                    edgeTo[w.vertex] = v.vertex;

                    Node tmp = pq.find(w.vertex);
                    if (tmp == null) {
                        System.out.println("     큐 <삽입>: ("+w.vertex+", "+distTo[w.vertex]+")");
                        pq.enqueue(w.vertex, distTo[w.vertex]);
                    } else {
                        System.out.println("     큐 <변경>: ("+tmp.vertex+", "+distTo[w.vertex]+")");
                        pq.fix(tmp, distTo[w.vertex]);
                    }
                }
                w = w.next;
            }
            pq.printPQ();
        }
    }
}
