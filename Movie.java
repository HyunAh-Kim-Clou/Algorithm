import java.util.Comparator;

public class Movie {
    private String title;    // 영화제목
    private String director; // 감독
    private int releaseYear; // 개봉연도
    private int audienceNo;  // 관객수

    public Movie(String[] line) {
        this.title = line[0];
        this.director = line[1];
        this.releaseYear = Integer.parseInt(line[2]);
        this.audienceNo = Integer.parseInt(line[3]);
    }

//    public interface Comparable<Item> { // ?
//        public int compareTo(Item that);
//    }
//    public static void sort(Comparable[] a) { // ?
//        int n = a.length, i, j;
//        Comparable key;
//
//        for (int i = 1; i < n; i++) {
//            key = a[i];
//            j = i-1;
//            while (j >= 0 && a[j].compareTo(key) > 0) {
//                a[j+1] = a[j];
//                j--;
//            }
//            a[j+1] = key;
//        }
//    }

    // 기준 열 & 순서 별 클래스
    // 영화 제목 가나다순
    public static class TitleOrder implements Comparator<Movie> {
        public int compare(Movie m1, Movie m2) {
            return m1.title.compareTo(m2.title);
        }
    }
    // 감독 가나다순
    public static class DirectorOrder implements Comparator<Movie> {
        public int compare(Movie m1, Movie m2) {
            return m1.director.compareTo(m2.director);
        }
    }
    // 개봉연도 최신순
    public static class RelyearOrder implements Comparator<Movie> {
        public int compare(Movie m1, Movie m2) {
            if (m1.releaseYear > m2.releaseYear)  return -1;
            if (m1.releaseYear < m2.releaseYear)  return 1;
            return 0;
        }
    }
    // 개봉연도 오래된 순
    public static class RevRelyearOrder implements Comparator<Movie> {
        public int compare(Movie m1, Movie m2) {
            Movie.RelyearOrder yearOrder = new Movie.RelyearOrder();
            return -yearOrder.compare(m1, m2);
        }
    }
    // 관객 수 내림차순
    public static class AudnoOrder implements Comparator<Movie> {
        public int compare(Movie m1, Movie m2) {
            if (m1.audienceNo > m2.audienceNo)  return -1;
            if (m1.audienceNo < m2.audienceNo)  return 1;
            return 0;
        }
    }
    // 관객 수 오름차순
    public static class RevAudnoOrder implements Comparator<Movie> {
        public int compare(Movie m1, Movie m2) {
            Movie.AudnoOrder audOrder = new Movie.AudnoOrder();
            return -audOrder.compare(m1, m2);
        }
    }

    public String toString() {
        return title+"\t("+director+")\t"+releaseYear+"\t"+audienceNo;
    }
}
