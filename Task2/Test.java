import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Test {

    static BST convertToBST(String[] data, HashCode codeObj) {
        BST binTree = new BST(-1, "");
        for (String str: data) {
            int hashcode = codeObj.getHashcode(str, 31);

            if (binTree.key == -1) {
                binTree = binTree.insert(null, hashcode, str);
            } else {
                binTree = binTree.insert(binTree, hashcode, str);
            }
        }
        return binTree;
    }

//    static RBTree convertToRBTree(String[] data, int hashcode) {
//        RBTree rbTree = new RBTree(-1, "");  // 첫 노드
//        for (String str: data) {
//            int hash = (new HashCode()).getHashcode(str, hashcode);
//
//            if (rbTree.key == -1) {  // 첫 노드
//                rbTree = rbTree.insert(null, hash, str);
//            } else {
//                rbTree = rbTree.insert(rbTree, hash, str);
//            }
//        }
//        return rbTree;
//    }

//    static HashTable insertToHashTable(String[] keys, String[] values, int tableSize, Table colFunc) {
//        HashTable hTable = new HashTable(tableSize);
//        for (int i = 0; i < keys.length; i++) {
//            colFunc.insert(keys[i], values[i]);
//        }
//        return hTable;
//    }

    static void searchAtTable(DynamicHashTable table, Table colFunc) {
        System.out.print(" * 항공사 코드 입력: ");
        Scanner code1 = new Scanner(System.in);
        table.search(code1.next(), colFunc);
    }

    public static void main(String[] args) {
        HashCode hcode = new HashCode();

        String[] airline = {
                "QR", "SQ", "CX", "EK", "KE",
                "LH", "OZ", "DL", "AHC", "QF"
        };
        int[] airhash = hcode.getHashcode(airline, 31);

//        System.out.println(" ** 1-a ) 해시코드 구하기 ");
//        for (int h: airhash) {
//            System.out.print(h+" ");
//        }
//        System.out.println();


        System.out.println("\n ** 1-b) 해시테이블[m=15]에 선형조사로 삽입하기 ");
        HashTable airHTable = new HashTable(15, 31);

        airHTable.insert(airline, new HashTable.LinearAddressing());
        airHTable.show();

        System.out.println("\n ** 1-c) 2배씩 동적으로 커지는 해시테이블[m=15]에 선형조사로 삽입하기 ");
        System.out.println("      (테이블 적재율은 50% 이하 유지) ");
        DynamicHashTable airDyHTable = new DynamicHashTable(15, 0.5, 31);

        airDyHTable.insertToDynaHashTable(airline, airline, new HashTable.Doubling());
        airDyHTable.show();


        System.out.println("\n ** 2-a) 이진검색트리에 삽입하기 ");
        BST airTree = convertToBST(airline, hcode);
        airTree.show(airTree);

        System.out.println("\n ** 2-b) 레드블랙트리에 삽입하기 ");
//        RBTree airRBTree = convertToRBTree(airline, hcode);
//        airRBTree.show(airRBTree);
        LibRBT airRBT = new LibRBT();
        airRBT.insert(airline);
        airRBT.show();

//
//               - InputObj : Vector<key, value>
//               - HashCode
//         <<interface>>Table  --  <<class>> HashTable, DynaHashTable

        System.out.println("\n ** 3) 파일의 데이터를 가져와 동적 해시테이블[m=4]에 더블해싱으로 삽입하기 ");
        Carriers c = new Carriers();
        c.readFile("CARRIERS.txt");

        Table colFunc = new HashTable.Doubling();
        DynamicHashTable table = new DynamicHashTable(4, 0.5, 31);
        table.insertToDynaHashTable(c.getKeys(), c.getValues(), colFunc);
//        table.show();
//
//        // 5개의 항공사 검색
        searchAtTable(table, colFunc);
        searchAtTable(table, colFunc);
        searchAtTable(table, colFunc);
        searchAtTable(table, colFunc);
        searchAtTable(table, colFunc);

    }
}
