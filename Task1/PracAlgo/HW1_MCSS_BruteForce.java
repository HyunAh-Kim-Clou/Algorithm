package Before;

public class HW1_MCSS_BruteForce {
    static int mcss_bfs(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                int sum = 0;
                for (int k = i; k < j+1; k++)
                    sum += a[k];

                if (sum > max)  max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = { -7, 4, -3, 6, 3, -8, 3, 4 };

        int max = mcss_bfs(a);
        System.out.println(" * MCSS Max : "+max);
    }
}
