package Before;

public class HW1_MCSS_DivNConq {
    static int max(int a, int b, int c) {
        if (c > b) {
            if (c > a)  return c;
            else  return a;
        }
        else {
            if (b > a)  return b;
            else  return a;
        }
    }

    static int mcss_rec(int[] a, int low, int high) {
        if (low == high)  return a[low];
        int mid = (low+high)/2;
        int left_sum = mcss_rec(a, low, mid);
        int right_sum = mcss_rec(a, mid+1, high);

        int rsum = 0, lsum, sum;
        lsum = sum = a[mid];
        for (int i = mid-1; i > low; i--) {
            sum += a[i];
            if (sum > lsum)  lsum = sum;
        }
        sum = 0;
        for (int j = mid+1; j < high; j++) {
            sum += a[j];
            if (sum > rsum)  rsum = sum;
        }
        int two_sided_sum = lsum + rsum;

        return max(left_sum, right_sum, two_sided_sum);
    }

    public static void main(String[] args) {
        int[] a = { -7, 4, -3, 6, 3, -8, 3, 4 };

        int max = mcss_rec(a, 0, a.length-1);
        System.out.println(" * MCSS Max recursively : "+max);
    }
}
