package StudyroomScheduling;

public class Test {
    public static Studygroup[] groups;
    public static void main(String[] args) {
        init();
        Scheduling studyroom = new Scheduling(groups);

        // 결과 출력
        System.out.println("<스터디룸을 사용한 스터디그룹> - b방식");
        int cnt = studyroom.scheduling();
        System.out.println(" - 사용가능한 팀 갯수: "+cnt);
    }

    static void init() {
        groups = new Studygroup[8];
        int i = 0;
        groups[i++] = new Studygroup(0, 900, 1000);
        groups[i++] = new Studygroup(1, 1130, 1230);
        groups[i++] = new Studygroup(2, 1000, 1200);
        groups[i++] = new Studygroup(3, 1530, 1700);
        groups[i++] = new Studygroup(4, 1100, 1230);
        groups[i++] = new Studygroup(5, 1500, 1600);
        groups[i++] = new Studygroup(6, 1200, 1400);
        groups[i++] = new Studygroup(7, 1400, 1530);
    }
}
