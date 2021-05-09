public class MinOp {
    static int getOpCount(int n) {
        return Math.min(getOpFirst(n), Math.min(getMinus1First(n), getMinus2First(n)));
    }

    static int getMinus1First(int n) {
        int cnt = 0;
        while (n!=1) {
            cnt++;
            if (n%3 == 0)
                n = n / 3;
            else
                n = n - 1;
        }
        return cnt;
    }

    static int getMinus2First(int n) {
        int cnt = 0;
        while (n != 1) {
            cnt++;
            if (n % 2 == 0)
                n = n / 2;
            else
                n = n - 1;
        }
        return cnt;
    }

    static int getOpFirst(int n) {
        int cnt = 0;
        while (n!=1) {
            cnt++;
            if (n%2 == 0)
                n = n / 2;
            else if (n%3 == 0)
                n = n / 3;
            else
                n = n - 1;
        }
        return cnt;
    }

//    static int getOpCount(int n) {
//        int cnt = 0;
//        while (n!=1) {
//            // 몫이 더 작은게 연산 더 적게 걸리면
//            if ((n/3 + n%3) < (n/2 + n%2)) {
//                while (n%3 != 0) {
//                    cnt++;
//                    n = n - 1;
//                }
//                n = n / 3;
//            } else {
//                if (n%2 != 0) {
//                    cnt++;
//                    n = n - 1;
//                }
//                n = n / 2;
//            }
//            cnt++;
//        }
//        return cnt;
//    }
}
