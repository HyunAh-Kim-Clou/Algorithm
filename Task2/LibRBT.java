import java.util.TreeMap;

public class LibRBT {
    TreeMap<Integer, String> tree;

    LibRBT() {
        tree = new TreeMap<Integer, String>();
    }

    TreeMap insert(String[] values) {
        HashCode hashObj = new HashCode();
        int[] hashs = hashObj.getHashcode(values, 31);

        int i = 0;
        while (i < values.length) {
            tree.put(hashs[i], values[i]);
            i++;
        }
        return tree;
    }

    void show() {
        for (Integer i: tree.keySet()) {
            System.out.println(" [Key]: "+i+"  [Value]: "+ tree.get(i));
        }
    }
}
