public class HashTable {
    static HashCode code;
    static int HASHCODE;
    static int size;

    static String[] keys;
    static String[] values;

    HashTable(int m, int hashcode) {
        this.code = new HashCode();
        this.HASHCODE = hashcode;

        this.size = m;
        this.keys = new String[m];
        this.values = new String[m];
    }

    String[] insert(String[] strs, Table colFunc) {
        for (String str: strs) {
            colFunc.insert(str, str);
        }
        return values;
    }

    // 충돌해결방식 에 따라
    static class LinearAddressing implements Table {
        @Override
        public String[] insert(String key, String value) {
            int hash = getHashCode(key);
            int idx = hash % size;

            while (keys[idx] != null) { // null 아니라면
                idx = (idx + 1) % size;
            }

            keys[idx] = key;
            values[idx] = value;
            return keys;
        }

        @Override
        public String getValueBy(String key) {
            int hash = getHashCode(key);
            int idx = hash % size;

            while (keys[idx] != null) { // null 아니라면
                idx = (idx + 1) % size;
            }
            return "";  // 못찾음
        }
    }

    static class Doubling implements Table {
        @Override
        public String[] insert(String key, String value) {
            int hash = getHashCode(key);
            int idx = hash % size;
            int d = 7 - (hash % 7);  // 7 - [0-6] = [7-1]

            int i = 1;
            while (keys[idx] != null) { // null 아니라면
                if (keys[idx].equals(key)) { // 같은 키값이 있다면
                    values[idx] = value;
                    return keys;
                }

                idx = (idx + i * d) % size; // n + [1-n]*[7-1]
                i++;
            }

            keys[idx] = key;
            values[idx] = value;
            return keys;
        }

        @Override
        public String getValueBy(String key) {
            int hash = getHashCode(key);
            int idx = hash % size;
            int d;

            int i = 1;
            while (keys[idx] != null) { // null 아니라면
                if (keys[idx].equals(key))
                    return values[idx];

                d = 7 - (hash % 7);  // 7 - [0-6] = [7-1]
                idx = (idx + i * d) % size; // n + [1-n]*[7-1]
                i++;
            }
            return "";  // 못찾음
        }
    }

    static int getHashCode(String key) {
        int hash = code.getHashcode(key, HASHCODE);
        if (hash < 0) {
            String tmp = ((String[]) key.split(" "))[0];
            hash = code.getHashcode(tmp, HASHCODE);
        }
        return hash;
    }

    static int getOccupys() {
        int cnt = 0; // null인 요소의 갯수
        for (String h: keys) {
            if (h == null)  cnt++;
        }
        return size - cnt;
    }

    // in: 64764 에 value
    // stored: 64764 % 15 (충돌이면 다음idx) 에 value
//    String[] insertByLinear(int key, String value) {
//        int idx = key % size;
//        // full이면 return HashTable
//        if (getOccupys() == hashs.length)  return hashs;
//
//        while (hashs[idx] != null) { // null 아니라면
//            idx = (idx + 1) % size;
//        }
//        hashs[idx] = value;
//        return hashs;
//    }

//    String getValueBy(String key) {
//        int hash = (new HashCode()).getHashcode(key, 31);
//        int idx = hash % size;
//        int d;
//
//        int i = 1;
//        while (hashs[idx] != null) { // null 아니라면
//            // key도 같이 저장해야함
//            // if 내가 찾던 애면, return hashs[idx];
//
//            d = 7 - (hash % 7);  // 7 - [0-6] = [7-1]
//            idx = (idx + i * d) % size; // n + [1-n]*[7-1]
//            i++;
//        }
//        return "";  // 못찾음
//    }

//    String[] insertByDoubling(int key, String value) {
//        int idx = key % size;
//        int d;
//        // full이면 return HashTable
//        if (getOccupys() == hashs.length)  return hashs;
//
//        int i = 1;
//        while (hashs[idx] != null) { // null 아니라면
//            d = 7 - (key % 7);  // 7 - [0-6] = [7-1]
//            idx = (idx + i * d) % size; // n + [1-n]*[7-1]
//            i++;
//        }
//        hashs[idx] = value;
//        return hashs;
//    }

    void show() {
        int i = 0;
        for (String h: keys) {
//            System.out.print(" ["+i+"]");
            if (h != null) {
                System.out.print(h);
            }
//            if (i % 19 == 0 && i != 0)
//                System.out.println();
            i++;
        }
        System.out.println();
    }

    double getLoadFactor() {
        return (double) getOccupys() / size;
    }
}
