package Before;

public class HW1_MergeSort {
    static void mergeSort(int[] a, int low, int high) {
        System.out.println("  mergeSort("+low+", "+high+")");
        if (low == high)  return;
        int mid = low + (high-low)/2;
        System.out.println("  mid="+mid);

        mergeSort(a, low, mid);
        mergeSort(a, mid+1, high);
        merge(a, low, mid, high);
    }

    private static void merge(int[] a, int low, int mid, int high) {
        System.out.println("  merge("+low+", "+mid+", "+high+")");
    }

    public static void main(String[] args) {
        int[] a = { 100,34,189,56,150, 140,9,123 };
//        int[] a = {2,9,5,4,8,1};

        mergeSort(a, 0, a.length-1);
    }
}
