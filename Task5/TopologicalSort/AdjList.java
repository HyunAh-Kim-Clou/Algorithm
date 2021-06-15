package TopologicalSort;

// 인접리스트
public class AdjList {
    public Node head; //리스트의 헤드

    //인접리스트의 헤드로 새 정점 삽입
    public void insert(int v) {
        Node new_node = new Node();
        new_node.vertex = v;
        new_node.next = head;
        head = new_node;
    }
}
