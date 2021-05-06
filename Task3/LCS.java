import java.lang.reflect.Array;
import java.util.Arrays;

// Longest Common Subsequence
public class LCS {
    static char[] X = {};
    static char[] Y;
    LCS(String x, String y) {
        this.X = x.toCharArray();
        this.Y = y.toCharArray();
    }

    static int[] A;
    static int[] B;
    LCS(int[] a, int[] b) {
        this.A = a;
        this.B = b;
    }

    static Boolean isSame(int i, int j) {
        if (X.length != 0)
            return X[i-1] == Y[j-1];
        else
            return A[i-1] == B[j-1];
    }

    // 분할 정복 알고리즘
    static int LCS1(int m, int n) {
        if (m==0 || n==0)  return 0;
        else if (X[m-1] == Y[n-1])  return LCS1(m-1, n-1) + 1;
        else  return Math.max(LCS1(m-1, n), LCS1(m, n-1));
    }

    // 동적프로그래밍 알고리즘
    static int LCS2(int m, int n) {
        int[][] c = new int[m+1][n+1];
        for (int i = 0; i <= m; i++)
            c[i][0] = 0;
        for (int j = 0; j <= n; j++)
            c[0][j] = 0;

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (isSame(i, j))  c[i][j] = c[i-1][j-1] + 1;
                else  c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
            }
        return c[m][n];
    }
}
