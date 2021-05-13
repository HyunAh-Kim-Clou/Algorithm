import java.util.ArrayList;
import java.util.List;

public class DeadlineScheduling {
    List<signUp> tasklist;

    static class signUp {
        int i;
        int begin;
        int end;

        signUp(int i, int begin, int end) {
            this.i = i; this.begin = begin; this.end = end;
        }
    }

    DeadlineScheduling(ArrayList<List<Integer>> tasks) {
        tasklist = new ArrayList<>();
        for (List<Integer> i : tasks) {
            tasklist.add(new signUp(i.get(0), i.get(1), i.get(2)));
        }
    }

    signUp getMinEndTask() {
        signUp minendtask = tasklist.get(0);
        for (signUp i : tasklist) {
            if (i.end < minendtask.end) {
                minendtask = i;
            }
        }
        return minendtask;
    }

    signUp getMinEndTask(int now) {
        signUp minendtask = tasklist.get(0);
        for (signUp i : tasklist) {
            if (i.begin >= now && i.end < minendtask.end) {
                minendtask = i;
            }
        }
        return minendtask;
    }

    // way 1.
    int scheduling() {
        int cnt = 0, now = 0;
        signUp nowTask;

         do {
            nowTask = getMinEndTask(now);
             if (nowTask.begin >= now) {
                 now = nowTask.end;
                 cnt++;
                 System.out.println(" - i:"+nowTask.i+" begin:"+nowTask.begin+" end:"+nowTask.end);
             }
            tasklist.remove(nowTask);
        } while (tasklist.size() > 0);
        return cnt;
    }

    // way 2.
    int scheduling2() {
        int n = tasklist.size();
        signUp[] nowMinTask = new signUp[n];

        // nowMinTask : end 값을 기준으로 오름차순 정렬한 signUp 배열
        for (int i = 0; i < n; i++) {
            signUp tmp = getMinEndTask(); // O(n^2)
            nowMinTask[i] = tmp;
            tasklist.remove(tmp);
        }

        int cnt = 0, now = 0;
        for (signUp task : nowMinTask) {
            if (task.begin >= now) {
                now = task.end;
                cnt += 1;
                System.out.println(" - ["+task.i+"]");
            }
        }
        return cnt;
    }
}
