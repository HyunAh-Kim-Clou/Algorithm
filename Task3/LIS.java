import java.util.Stack;

// Longest Increasing Subsequence
public class LIS {
    static int LIS1(int[] A) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> trace = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            if (i==0) {
                stack.add(A[0]);
                continue;
            }
            if (stack.peek() < A[i])
                stack.add(A[i]);
            else {
                // 더 큰값을 만났을 때 stack의 크기 기록
                trace.add(stack.size());
                while (stack.peek() > A[i])
                    stack.pop();
                stack.add(A[i]);
            }
        }
        trace.add(stack.size());
        for (int j = 0; j < trace.size(); j++) {
            if (trace.get(j) > trace.get(max))
                max = j;
        }
        return trace.get(max);
    }

    // O(nlgn)인 최적화된 알고리즘
//    int LIS2(int[] A) {
//        // 더 큰값을 만났을 때 stack의 크기 기록
//        trace.add(stack.size());
//
//        int start = 0, end = stack.size();
//        int idx = stack.size();
//        while (start < end) {
//            int mid = (start+end)/2;
//            if (stack.get(mid) >= A[i]) {
//                idx = Math.min(idx, mid);
//                end = mid;
//            } else {
//                start = mid+1;
//            }
//        }
//        while (stack.peek() > A[i])
//            stack.pop();
//        stack.add(A[i]);
//    }
}
