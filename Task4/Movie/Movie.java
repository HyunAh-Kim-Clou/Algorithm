package Movie;

import GreedyAlgo.Studygroup;

import java.util.Comparator;

public class Movie {
    public int i;
    public int start;
    public int end;

    public Movie(int i, int start, int end) {
        this.i = i; this.start = start; this.end =end;
    }

    //Edge 가중치를 기준으로 오름차순 비교기
    public static class endOrder implements Comparator<Movie> {
        @Override
        public int compare(Movie e1, Movie e2) {
            if(e1.end < e2.end) return -1;
            if(e1.end > e2.end) return 1;
            return 0;
        }
    }
}
