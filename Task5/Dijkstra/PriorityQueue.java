package Dijkstra;

import java.util.Arrays;
import java.util.Comparator;

//우선순위 큐(정점의 연결리스트)
public class PriorityQueue {
    public Node first; //큐의 맨 앞 노드
    public Node last; //큐의 마지막 노드
    public int size; //큐 사이즈

    public static class weightOrder implements Comparator<Node> {
        public int compare(Node e1, Node e2) {
            if(e1.weight < e2.weight) return -1;
            if(e1.weight > e2.weight) return 1;
            return 0;
        }
    }

    // 우선순위: 가중치 정렬
    public void sort() {
        Node[] arr = new Node[size];
        Node tmp = first;
        for (int i = 0; i < size; i++) {
            arr[i] = tmp;
            if (tmp.next != null)
                tmp = tmp.next;
        }

        Arrays.sort(arr, new weightOrder());
        PriorityQueue subpq = new PriorityQueue();
        for (int i = 0; i < size; i++) {
            subpq.enqueue(arr[i].vertex, arr[i].weight);
        }
        first = subpq.first;
    }

    public Node find(int v) {
        Node tmp = first;
        while (tmp != null) {
            if (tmp.vertex == v)
                return tmp;
            tmp = tmp.next;
        }
        return null;
    }

    public void fix(Node node, double dist) {
        node.weight = dist;
    }

    //큐에 정점 v, 길이 dist를 last로 삽입
    public void enqueue(int v, double dist) {
        Node new_node = new Node();
        new_node.vertex = v;
        new_node.weight = dist;
        new_node.next = null;
        if(size == 0) {
            first = last = new_node;
        }
        else {
            last.next = new_node;
            last = new_node;
        }
        size++;
    }

    //큐에서 (first) 삭제 (FIFO)
    public Node dequeue() {
        sort();
        Node tmp = new Node();
        tmp.vertex = first.vertex;
        tmp.weight = first.weight;

        first = first.next;
        size--;
        if(size == 0) last = null;
        return tmp;
    }

    public void printPQ() {
        System.out.print(" <큐>: ");
        Node tmp = first;
        while (tmp != null) {
            System.out.print("("+tmp.vertex+", "+tmp.weight+") ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
