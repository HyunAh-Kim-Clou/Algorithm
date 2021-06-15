package Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Dijkstra2 {
    public double[] distTo; // SP의 weight 합
    public int[] edgeTo; // SP의 직전 정점
    public ArrayList<Node> pq;

    public static class weightOrder implements Comparator<Node> {
        public int compare(Node e1, Node e2) {
            if(e1.weight < e2.weight) return -1;
            if(e1.weight > e2.weight) return 1;
            return 0;
        }
    }

    public int findIdx(int v) {
        for (int i = 0; i < pq.size(); i++) {
            if (pq.get(i).vertex == v)
                return i;
        }
        return -1;
    }
    public void sortQ() {
        pq.sort(new weightOrder());
    }

    public Dijkstra2(WeightedGraph g, int s) {
        distTo = new double[g.V];
        edgeTo = new int[g.V];
        pq = new ArrayList<Node>();

        Arrays.fill(distTo, 999.99); //배열의 모든요소들 초기화
        distTo[s] = 0;
        pq.add(new Node(s, 0.0));
        while (pq.size() != 0) {
            sortQ();
            Node v = pq.remove(0);
//            System.out.println(" <삭제>: ("+v.vertex+", "+v.weight+")");

            Node w = g.adj[v.vertex].head;
            while(w != null) {
                if (distTo[w.vertex] > distTo[v.vertex]+w.weight) {
//                    System.out.println(" - "+w.vertex+" weight: "+distTo[w.vertex]+" -> "+(distTo[v.vertex]+w.weight));
                    distTo[w.vertex] = distTo[v.vertex]+w.weight;
                    edgeTo[w.vertex] = v.vertex;

                    int idx = findIdx(w.vertex);
                    if (idx == -1) {
//                        System.out.println("     큐 <삽입>: ("+w.vertex+", "+distTo[w.vertex]+")");
                        pq.add(new Node(w.vertex, distTo[w.vertex]));
                    } else {
//                        System.out.println("     큐 <변경>: ("+w.vertex+", "+distTo[w.vertex]+")");
                        pq.set(idx, new Node(w.vertex, distTo[w.vertex]));
                    }
                }
                w = w.next;
            }
        }
    }
}

//        queue.enqueue(s, 0.0);
//        while (queue.size != 0) {
//            Node focus = queue.dequeue();
//            if (focus.weight < weight[focus.vertex]) {
//                weight[focus.vertex] = focus.weight;
//                edgeTo[focus.vertex] = findParentV(g, focus.vertex, focus.weight);
//            }
//
//            Node node = g.adj[focus.vertex].head;
//            while (node != null) {
//                queue.enqueue(node.vertex, node.weight);
//                node = node.next;
//            }
//        }

//    int findParentV(WeightedGraph g, int childv, double weight) {
//        for(int i=0; i<g.V; i++) {
//            Node node = g.adj[i].head;
//            while(node != null) {
//                if (node.vertex == childv && node.weight == weight)
//                    return i;
//                node = node.next;
//            }
//            System.out.println();
//        }
//        return -1;
//    }
