package Before;

import java.util.Arrays;

public class HW1_Max {
    static int max_rep(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)  max = a[i];
        }
        return max;
    }

    static int max_rec(int[] a) {
        if (a.length == 1)  return a[0];

        int mid = a.length / 2;
        int left_max = max_rec(Arrays.copyOfRange(a, 0, mid));
        int right_max = max_rec(Arrays.copyOfRange(a, mid, a.length));

        if (right_max> left_max)  return right_max;
        else  return left_max;
    }

    public static void main(String[] args) {
        int[] a = {7,2,4};

        int max = max_rec(a);
        System.out.println(" * Max : "+max);
    }
}
