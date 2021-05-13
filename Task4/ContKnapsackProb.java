import java.util.*;

import static java.util.Arrays.stream;

public class ContKnapsackProb {
    int C;
    double[] r;

    ContKnapsackProb(int C) {
        this.C = C;
    }

    // (용량, 무게[], 가치[], 담을 비율[], 아이템 수)
    void continuous_knapsack(int C, int[] w, int[] p, double[] r, int n) {
        int[] priority = getUnitP(w, p);
        w = descSorted(w, priority);

        int i = 0, w_now = 0;
        while (i < n && w_now < C) {
            if (w_now + w[i] <= C) {
                r[i] = 1;
                w_now += w[i];
            } else {
                r[i] = (double) (C - w_now) / w[i];
                w_now = C;
            }
            i++;
        }
    }

    double[] continuous_knapsack(int[] w, int n) {
        r = new double[n];
        int i = 0, w_now = 0;
        while (i < n && w_now < C) {
            if (w_now + w[i] <= C) {
                r[i] = 1;
                w_now += w[i];
            } else {
                r[i] = (double) (C - w_now) / w[i];
                w_now = C;
            }
            i++;
        }
        return r;
    }

    int[] descSorted(int[] t, int[] priority) {
        int n = t.length;
        Stack<Integer> stack = new Stack<Integer>();
        for (int li : t) {
            stack.push(li);
        }

        int max = stream(priority).max().getAsInt();
        int[] tmp = new int[max];
        for (int i = 0; i < n; i++) {
            tmp[priority[i]-1] = t[i];
        }

        int[] res = new int[n];
        int idxt = tmp.length;
        int i = 0;
        while (idxt >= 0 && i < n) {
            if (tmp[--idxt] != 0) {
                res[i++] = tmp[idxt];
            }
        }
        return res;
    }

    int[] getUnitP(int[] w, int[] p) {
        int i = 0;
        int[] unit = new int[p.length];
        while (i < unit.length) {
            unit[i] = p[i] / w[i];
            i++;
        }
        return unit;
    }

    void printInts(double[] r) {
        System.out.print(" - r[]: ");
        for (double i : r) {
            System.out.print("["+i+"] ");
        }
        System.out.println();
    }
}
