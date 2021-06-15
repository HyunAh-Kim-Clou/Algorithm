package DynamicAlgo;

// Longest Common Subsequence
//  가장 긴  공통 부분순서
public class LCS {
    public int[] x;
    public int[] y;
    public LCS(int[] x, int[] y) {
        this.x = x;
        this.y = y;
    }
    public LCS(char[] a, char[] b) {
        this.x = new int[a.length];
        for (int i=0; i<a.length; i++) {
            this.x[i] = a[i] - '0';
        }
        this.y = new int[b.length];
        for (int j=0; j<b.length; j++) {
            this.y[j] = b[j] - '0';
        }
    }

    // 동적프로그래밍 알고리즘
    public int getLCS() {
        int n = x.length;
        int m = y.length;
        int[][] c = new int[m+1][n+1];

        // c의 [0]행열 초기화
        for (int i = 0; i <= m; i++)
            c[i][0] = 0;
        for (int j = 0; j <= n; j++)
            c[0][j] = 0;

        // LCS 계산
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (x[i-1] == y[j-1])  c[i][j] = c[i-1][j-1] + 1;
                else  c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
            }
        return c[m][n];
    }
}
