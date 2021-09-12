package Movie;

import GreedyAlgo.Studygroup;

public class Test {
    public static Movie[] groups;
    public static void main(String[] args) {
        SchedulingInit();
        Scheduling movies = new Scheduling(groups);

        int cnt = movies.scheduling();
        System.out.println("최대 영화 개수 = "+cnt);
    }

    public static void SchedulingInit() {
        groups = new Movie[8];
        int i = 0;
        groups[i++] = new Movie(0, 540, 595);
        groups[i++] = new Movie(1, 690, 750);
        groups[i++] = new Movie(2, 600, 720);
        groups[i++] = new Movie(3, 940, 1020);
        groups[i++] = new Movie(4, 660, 740);
        groups[i++] = new Movie(5, 900, 960);
        groups[i++] = new Movie(6, 720, 840);
        groups[i++] = new Movie(7, 840, 930);
    }
}
