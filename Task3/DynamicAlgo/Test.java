package DynamicAlgo;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        // LCS 문제: 공통인 요소(c)가 얼마나 많나

        // lcs test 1.
        int[] a1 = {1,10,5,20,15, 12,30,49,25,35, 66,75,44};
        int[] a2 = Arrays.stream(a1).sorted().toArray(); // int[] 오름차순 정렬

        LCS lcs = new LCS(a1, a2);
        int lcsno = lcs.getLCS();
        System.out.println(" - LCS: "+lcsno);

        // lcs test 2.
        char[] b1 = "AAACCGTGAGTT".toCharArray();
        char[] b2 = "CACCCCTAAGGT".toCharArray();

        LCS lcs2 = new LCS(b1, b2);
        int lcs2no = lcs.getLCS();
        System.out.println(" - LCS: "+lcs2no);

        // edit distance.
        EditDistance ed = new EditDistance("ELEPHANT", "RELEVANT");
        int editedDist = ed.d;
        System.out.println(" - edit distance: "+editedDist);
    }
}
