package StudyroomScheduling;

import java.util.Arrays;

public class Scheduling {
    public Studygroup[] groups;
    public Scheduling(Studygroup[] studygroups) {
        this.groups = studygroups;
    }

    int scheduling() {
        int cnt = 0;
        Arrays.sort(groups, new Studygroup.endOrder());

        int now = 0;
        for (Studygroup g: groups) {
            if (g.start >= now) {
                now = g.end;
                cnt += 1;
                System.out.println(" - ["+g.i+"] begin:"+g.start+" end:"+g.end);
            }
        }
        return cnt;
    }
}
