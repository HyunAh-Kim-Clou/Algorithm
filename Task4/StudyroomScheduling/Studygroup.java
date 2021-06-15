package StudyroomScheduling;

import java.util.Comparator;

public class Studygroup {
    public int i;
    public int start;
    public int end;

    public Studygroup(int i, int start, int end) {
        this.i = i; this.start = start; this.end =end;
    }

    //Edge 가중치를 기준으로 오름차순 비교기
    public static class endOrder implements Comparator<Studygroup> {
        @Override
        public int compare(Studygroup e1, Studygroup e2) {
            if(e1.end < e2.end) return -1;
            if(e1.end > e2.end) return 1;
            return 0;
        }
    }
}
