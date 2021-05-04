import java.util.Arrays;

public class DynamicHashTable {
    int size;
    double loadFactor;
    HashTable hashTable;
    int HASHCODE;

    DynamicHashTable(int m, double alpha, int hashcode) {
        this.size = m;
        this.loadFactor = alpha;
        this.HASHCODE = hashcode;
        this.hashTable = new HashTable(m, hashcode);
    }

    void search(String key, Table colFunc) {
        String value = colFunc.getValueBy(key);
        if (value.equals("")) {
            System.out.println("  -> HashTable에 [Key]: '"+key+"' 에 해당하는 값이 없습니다. ");
        } else {
            System.out.println("  -> [Key]: '"+key+"'  [Value]: "+value+" 입니다. ");
        }
    }

    HashTable migrate(String[] keys, String[] values, Table colFunc) {
        for (int i = 0; i < keys.length; i++) {
            colFunc.insert(keys[i], values[i]);
        }

//        System.out.print(" <m> "+hashTable.size+" : ");
//        hashTable.show();
        return hashTable;
    }

    HashTable insertToDynaHashTable(String[] keys, String[] values, Table colFunc) {
        for (int i = 0; i < keys.length; i++) {
            if (hashTable.getLoadFactor() > loadFactor) {
                size = size * 2;
                hashTable = new HashTable(size, HASHCODE);

                String[] subkeys = Arrays.copyOfRange(keys, 0, i);
                String[] subvals = Arrays.copyOfRange(values, 0, i);
                migrate(subkeys, subvals, colFunc);
            }

            colFunc.insert(keys[i], values[i]);
        }
        return hashTable;
    }
    void show() {
        hashTable.show();
    }
}
