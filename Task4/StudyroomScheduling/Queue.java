package StudyroomScheduling;

import java.util.ArrayList;

//큐(정점의 배열)
public class Queue {
    public ArrayList<Studygroup> queue; //큐의 맨 앞 노드
    public int size = 0; //큐 사이즈

    //큐에 정점 v를 last로 삽입
    public void enqueue(Studygroup g) {
        if (size == 0) {
            queue = new ArrayList<>();
        }
        Studygroup new_node = g;
        queue.add(g);
        size++;
    }

    //큐에서 (first) 삭제 (FIFO)
    public Studygroup dequeue() {
        if(size == 0)
            return null;
        size--;
        return queue.remove(0);
    }
}

