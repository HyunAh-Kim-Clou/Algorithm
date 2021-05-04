package Before;

public class HW1_QuickSort {
//    private static void quickSort_byWeb(int[] data, int left, int right) {
//        // ?? 안댐
//        int i, j, key, temp;
//        if (left < right) {
//            i = left;
//            j = right+1;
//            key = data[left];
//
//            do {
//                do {
//                    i++;
//                } while (data[i] < key);
//                do {
//                    j--;
//                } while (data[j] > key);
//
//                if (i < j) {
//                    temp = data[i];
//                    data[i] = data[j];
//                    data[j] = temp;
//                }
//            } while (i < j);
//
//            temp = data[left];
//            data[left] = data[j];
//            data[j] = temp;
//
//            quickSort(data, left, j-1);
//            quickSort(data, j+1, right);
//        }
//    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int partition(int[] a, int low, int high) {
        System.out.println("partition("+low+", "+high+")");
        int i = low;
        int j = high+1;
        while (true) {
            while (a[++i] < a[low]) {
                if (i == high) break;
            }
            while (a[--j] > a[low]) {
                if (j == low)  break;
            }
            if (i >= j)  break;
            swap(a, i, j);
        }
        swap(a, low, j);
        printArray(a);
        return j;
    }

    private static void quickSort(int[] a, int low, int high) {
//        System.out.println("qs("+low+", "+high+")");
        if (low >= high)  return;
        int pivot = partition(a, low, high);
        quickSort(a, low, pivot-1);
        quickSort(a, pivot+1, high);
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+", ");
        }
        System.out.println();
        System.out.println();
    }

//    private static void change(int[] a, int idx) {
//        // 배열 a = 배열의 주소 (주소에 의한 참조)
//        // return할 필요X
//        a[idx] = 72;
//    }

    public static void main(String[] args) {
//        int[] a = {15, 22, 13, 27, 12, 10, 20, 25};
        int[] a = { 100,34,189,56,150, 140,9,123 };
        printArray(a);

        quickSort(a, 0, a.length-1);
        printArray(a);
    }
}
