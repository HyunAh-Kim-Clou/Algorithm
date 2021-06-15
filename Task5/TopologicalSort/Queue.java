package TopologicalSort;

//큐(정점의 연결리스트)
public class Queue extends Object {
    public Node first; //큐의 맨 앞 노드
    public Node last; //큐의 마지막 노드
    public int size; //큐 사이즈

    //큐에 정점 v를 last로 삽입
    public void enqueue(int v) {
        Node new_node = new Node();
        new_node.vertex = v;
        new_node.next = null;
        if(size == 0)
            first = last = new_node;
        else {
            last.next = new_node;
            last = new_node;
        }
        size++;
    }

    //큐에서 (first) 삭제 (FIFO)
    public int dequeue() {
        int v = first.vertex;
        first = first.next;
        size--;
        if(size == 0) last = null;
        return v;
    }
}
