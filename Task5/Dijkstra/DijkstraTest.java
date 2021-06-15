package Dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DijkstraTest {
    WeightedGraph g;
    // 파일읽기
    public DijkstraTest(String fname) {
        readFile(fname);
    }

    public static void main(String[] args) {
        DijkstraTest wgd = new DijkstraTest("Graph_11.txt");

        wgd.printGraph();
        wgd.printDijkstraSPP(0);
        System.out.println("-----");
    }

    // 파일읽기 함수
    private void readFile(String fname) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fname));
            //파일로부터 가중치 그래프를 인접리스트로 저장하기
            int n = Integer.parseInt(in.readLine());
            int m = Integer.parseInt(in.readLine());
            g = new WeightedGraph(n);
            for(int i=0;i<m;i++) {
                String[] vs = new String[2];
                String line = in.readLine();
                vs = line.split(" ");
                g.addEdge(Integer.parseInt(vs[0]), Integer.parseInt(vs[1]), Double.parseDouble(vs[2]));
            }
            in.close();
        } catch(IOException e) {
            System.err.println("File Error");;
            System.exit(1);
        }
    }
    //
    public void printGraph() {
        //인접리스트 출력
        System.out.println("<Graph>");
        for(int v=0;v<g.V;v++) {
            System.out.print(v + " : ");
            Node node = g.adj[v].head;
            while(node != null) {
                System.out.print("(" + node.vertex + ", " + node.weight + ")");
                node = node.next;
            }
            System.out.println();
        }
    }
    public void printDijkstraSPP(int start) {
        //다익스트라 알고리즘으로 SPP 구하기
        System.out.println("<Dijkstra SPP>");
        Dijkstra2 dijkstra = new Dijkstra2(g, start);
        //시작정점을 s로 하는 SPP, 그 길이 출력하기
        for(int v=0; v< g.V; v++) {
            System.out.println(v +": "+dijkstra.edgeTo[v]+ " | (길이) " + dijkstra.distTo[v]);
        }
    }
}
