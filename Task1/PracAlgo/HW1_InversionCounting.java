package Before;

public class HW1_InversionCounting {
    static int mergeSort1(int[] a, int low, int high) {
        int count = 0;
        if (low == high)  return 0;
        if (high == low+1) {
            if (a[low] > a[high])  count++;
            return count;
        }
        int mid = low + (high-low)/2;  // (high-low)/2 = int임

        count += mergeSort1(a, low, mid);
        count += mergeSort1(a, mid+1, high);
        count += mergeSort2(a, low, mid, high);
        return count;
    }

    static int mergeSort2(int[] a, int low, int mid, int high) {
        int count = 0;
        for (int i = low; i <= mid; i++) {
            for (int j = mid+1; j <= high; j++)
                if (a[i] > a[j])  count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = { 100, 34, 189, 56, 150, 140, 9, 123 };
        int count = mergeSort1(a, 0, a.length-1);

        System.out.println(" * Inversed Pair No : "+ count);
    }
}
