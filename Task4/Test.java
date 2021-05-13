import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // [1] 연속 배낭 알고리즘
        int[] w = {5, 10, 20};
        int[] p = {50, 60, 140};
        ContKnapsackProb CK = new ContKnapsackProb(30);

        // way 1.
//        int[] priority = CK.getUnitP(w, p);
//        w = CK.descSorted(w, priority);
//        p = CK.descSorted(p, priority);
//        double[] r1 = CK.continuous_knapsack(w, 3);
//        CK.printInts(r1);

        // way 2.
        double[] r2 = new double[3];
        CK.continuous_knapsack(30, w, p, r2, 3);
        CK.printInts(r2);


        // [4] 자원 스케줄링 문제
        ArrayList<List<Integer>> tasks = new ArrayList<>();
        tasks.add(new ArrayList<>(Arrays.asList(0, 900, 1000)));
        tasks.add(new ArrayList<>(Arrays.asList(1, 1130, 1230)));
        tasks.add(new ArrayList<>(Arrays.asList(2, 1000, 1200)));
        tasks.add(new ArrayList<>(Arrays.asList(3, 1530, 1700)));
        tasks.add(new ArrayList<>(Arrays.asList(4, 1100, 1230)));
        tasks.add(new ArrayList<>(Arrays.asList(5, 1500, 1600)));
        tasks.add(new ArrayList<>(Arrays.asList(6, 1200, 1400)));
        tasks.add(new ArrayList<>(Arrays.asList(7, 1400, 1530)));

        DeadlineScheduling ds = new DeadlineScheduling(tasks);
        int cnt = ds.scheduling();
        System.out.println(" - cnt: "+cnt);
    }
}
