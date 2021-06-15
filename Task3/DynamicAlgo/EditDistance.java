package DynamicAlgo;

public class EditDistance {
    public int d;
    public EditDistance(String str, String editedStr) {
        LCS lcs = new LCS(str.toCharArray(), editedStr.toCharArray());
        d = str.length()+editedStr.length() - 2*lcs.getLCS();
    }
}
