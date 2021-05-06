import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // LCS 길이 구하기 (String)
        int lenLCS;
//        String X = "AAACCGTGAGTT";
//        String Y = "CACCCCTAAGGT";
//
//        LCS lcs = new LCS(X, Y);
//        lenLCS = lcs.LCS2(X.length(), Y.length());
//        System.out.println(" [way 1] LCS 길이: "+lenLCS);

        // LCS 길이 계산 알고리즘으로 LIS 구하기 (int[])
        int[] a1 = {1,10,5,20,15, 12,30,49,25,35, 66,75,44};
        int[] a2 = Arrays.stream(a1).sorted().toArray(); // 오름차순 정렬

        LCS lcs2 = new LCS(a1, a2);
        lenLCS = lcs2.LCS2(a1.length, a2.length);
        System.out.println(" [way 2] LCS 길이: "+lenLCS);

        // LIS 구하기
        int lenLis = LIS.LIS1(a1);
        System.out.println(" - 'a1'의 LIS 길이: "+lenLis);

        int[] a3 = {1,4,2,5,7, 3,6,8};
        int lenLIS = LIS.LIS1(a3);
        System.out.println(" - 'a3'의 LIS 길이: "+lenLIS);
    }
}
