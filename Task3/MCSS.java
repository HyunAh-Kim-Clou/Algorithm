import java.util.Arrays;

// Maximum Contiguous Subsequence Sum
// 주어진 배열에서 연속된 부분집합 중 최댓값 구하기
public class MCSS {
    // 동적 프로그래밍 알고리즘
    static int MCSS1(int[] a) {
        // b[i]= 부분배열의 오른쪽 끝이 i인 최대 부분배열 합
        int[] b = new int[a.length];
        int max = 0;

        for (int i = a.length; i > 0; i--) {
            b[i-1] = 0;
            for (int j = 0; j <= i; j++) {
                int tmp = Arrays.stream(Arrays.copyOfRange(a, j, i)).sum();
                if (b[i-1] < tmp)
                    b[i-1] = tmp;
            }
            if (max < b[i-1])
                max = b[i-1];
        }
        return max;  // b[]의 최댓값
    }

    // ____________________________________________________
    //세 정수의 최대를 반환하는 함수
    private static int max3(int x, int y, int z) {
        return Math.max(Math.max(x, y), z);
    }

    //분할정복 알고리즘 (재귀 도우미)
    private static int dc_rec(int[] a, int low, int high) {
        int left_sum, right_sum, two_sided_sum;
        int mid, sum, lsum, rsum;

        if (low == high) return a[low];
        mid = (low + high) / 2;
        //한쪽에만 걸치는 부분 구간의 최대합 구하기
        left_sum = dc_rec(a, low, mid);
        right_sum = dc_rec(a, mid + 1, high);
        //양쪽에 걸치는 부분 구간의 최대합 구하기
        lsum = sum = a[mid];
        for (int i = mid - 1; i >= low; --i) {
            sum += a[i];
            if (sum > lsum) lsum = sum;
        }
        rsum = sum = a[mid + 1];
        for (int j = mid + 2; j <= high; j++) {
            sum += a[j];
            if (sum > rsum) rsum = sum;
        }
        two_sided_sum = lsum + rsum;
        return max3(left_sum, right_sum, two_sided_sum);
    }

    // 분할정복 Divide-and-Conquer 알고리즘 : O(nlgn)
    static int divideConquer(int[] a) {
        return dc_rec(a, 0, a.length - 1);
    }
}
