import javax.jws.Oneway;
import java.io.*;
import java.util.Comparator;
import java.util.Vector;

public class HW1_QuickSortMovie {
    // 파일 읽기
    static void readFile(String filePath, Vector<Movie> movies) {
        try {
            File file = new File(filePath);
            // 한글로 인코딩된 파일 읽기
            InputStreamReader isReader = new InputStreamReader(new FileInputStream(file), "euc-kr");
            BufferedReader bufReader = new BufferedReader(isReader);

            String line = "";
            while ((line = bufReader.readLine()) != null) {
                String[] linePieces = line.split("\t");

                // Movie 클래스로 저장
                Movie movie = new Movie(linePieces);
                movies.add(movie);
            }
            bufReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 퀵 정렬 메소드
    private static void swap(Vector<Movie> data, int i, int j) {
        Movie temp = data.elementAt(i);
        data.setElementAt(data.elementAt(j), i);
        data.setElementAt(temp, j);
    }
    private static void Obj_swap(Object[] data, int i, int j) {
        Object temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    private static <T> void Generic_swap(T[] data, int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    static int partition(Vector<Movie> data, int low, int high, Comparator comparator) {
        int i = low;
        int j = high+1;
        while (true) {
            while (comparator.compare(data.get(++i), data.get(low)) < 0) {
                if (i == high) break;
            }
            while (comparator.compare(data.get(--j), data.get(low)) > 0) {
                if (j == low)  break;
            }
            if (i >= j)  break;
            swap(data, i, j);
        }
        swap(data, low, j);
        return j;
    }
    static int Obj_partition(Object[] data, int low, int high, Comparator comparator) {
        int i = low;
        int j = high+1;
        while (true) {
            while (comparator.compare(data[++i], data[low]) < 0) {
                if (i == high) break;
            }
            while (comparator.compare(data[--j], data[low]) > 0) {
                if (j == low)  break;
            }
            if (i >= j)  break;
            Obj_swap(data, i, j);
        }
        Obj_swap(data, low, j);
        return j;
    }
    static <T> int Generic_partition(T[] data, int low, int high, Comparator comparator) {
        int i = low;
        int j = high+1;
        while (true) {
            while (comparator.compare(data[++i], data[low]) < 0) {
                if (i == high) break;
            }
            while (comparator.compare(data[--j], data[low]) > 0) {
                if (j == low)  break;
            }
            if (i >= j)  break;
            Generic_swap(data, i, j);
        }
        Generic_swap(data, low, j);
        return j;
    }

    public static void quickSort(Vector<Movie> data, int low, int high, Comparator comparator) {
        if (low >= high)  return;
        int pivot = partition(data, low, high, comparator);
        quickSort(data, low, pivot-1, comparator);
        quickSort(data, pivot+1, high, comparator);
    }
    public static void Obj_quickSort(Object[] data, int low, int high, Comparator comparator) {
        if (low >= high)  return;
        int pivot = Obj_partition(data, low, high, comparator);
        Obj_quickSort(data, low, pivot-1, comparator);
        Obj_quickSort(data, pivot+1, high, comparator);
    }
    public static <T> void Generic_quickSort(T[] data, int low, int high, Comparator comparator) {
        if (low >= high)  return;
        int pivot = Generic_partition(data, low, high, comparator);
        Generic_quickSort(data, low, pivot-1, comparator);
        Generic_quickSort(data, pivot+1, high, comparator);
    }
}
