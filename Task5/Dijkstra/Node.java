package Dijkstra;

//가중치 그래프 인접리스트의 노드
public class Node {
    int vertex; //인접 정점 번호
    double weight; //가중치
    Node next;

    public Node() {

    }
    public Node(int v, double w) {
        this.vertex = v;
        this.weight = w;
        this.next = null;
    }
}
