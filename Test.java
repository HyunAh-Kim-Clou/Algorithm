import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        Vector<Movie> movies = new Vector<Movie>();
        String filePath = ".//src//movie.txt";

        // movie.txt 파일 읽기
        HW1_QuickSortMovie.readFile(filePath, movies);

//        // a) 영화제목 가나다순
//        HW1_QuickSortMovie.quickSort(movies, 0, movies.size()-1, new Movie.TitleOrder());
//        System.out.println("  a) 영화제목 가나다순");
//        for (Movie m: movies)
//            System.out.println(m);
//        System.out.println();

        // Object형으로 추상화한 메소드들 ReExecute
        // Vector<Movie> ==> Object[]  : Vector<>.toArray() 아님
        HW1_QuickSortMovie.Obj_quickSort(movies.toArray(), 0, movies.size()-1, new Movie.TitleOrder());
        System.out.println("  a) 영화제목 가나다순");
        for (Movie m: movies)
            System.out.println(m);
        System.out.println();

        // Generic으로 추상화한 메소드들 ReExecute
        HW1_QuickSortMovie.Generic_quickSort(movies.toArray(), 0, movies.size()-1, new Movie.TitleOrder());
        System.out.println("  a) 영화제목 가나다순");
        for (Movie m: movies)
            System.out.println(m);
        System.out.println();

//        // b) 감독 가나다순
//        HW1_QuickSortMovie.quickSort(movies, 0, movies.size()-1, new Movie.DirectorOrder());
//        System.out.println("  b) 감독 가나다순");
//        for (Movie m: movies)
//            System.out.println(m);
//        System.out.println();
//
//        // c) 개봉연도 최신순
//        HW1_QuickSortMovie.quickSort(movies, 0, movies.size()-1, new Movie.RelyearOrder());
//        System.out.println("  c) 개봉연도 최신순");
//        for (Movie m: movies)
//            System.out.println(m);
//        System.out.println();
//
//        // d) 개봉연도 오래된 순
//        HW1_QuickSortMovie.quickSort(movies, 0, movies.size()-1, new Movie.RevRelyearOrder());
//        System.out.println("  d) 개봉연도 오래된 순");
//        for (Movie m: movies)
//            System.out.println(m);
//        System.out.println();
//
//        // e) 관객 수 오름차순
//        HW1_QuickSortMovie.quickSort(movies, 0, movies.size()-1, new Movie.RevAudnoOrder());
//        System.out.println("  e) 관객 수 오름차순");
//        for (Movie m: movies)
//            System.out.println(m);
//        System.out.println();
//
//        // f) 관객 수 내림차순
//        HW1_QuickSortMovie.quickSort(movies, 0, movies.size()-1, new Movie.AudnoOrder());
//        System.out.println("  f) 관객 수 내림차순");
//        for (Movie m: movies)
//            System.out.println(m);
//        System.out.println();

    }
}
