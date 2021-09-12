package Movie;

import java.util.Arrays;

public class Scheduling {
    public Movie[] groups;
    public Scheduling(Movie[] studygroups) {
        this.groups = studygroups;
    }

    int scheduling() {
        int cnt = 0;
        Arrays.sort(groups, new Movie.endOrder());

        int now = 0;
        for (Movie g: groups) {
            if (g.start >= now) {
                now = g.end + 10;
                cnt += 1;
                System.out.println(g.i+" : ("+g.start+", "+g.end+")");
            }
        }
        return cnt;
    }
}
