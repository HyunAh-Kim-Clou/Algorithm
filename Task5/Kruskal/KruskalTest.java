package Kruskal;

import java.io.*;

public class KruskalTest {
    WeightedGraph g;
    public KruskalTest(String fname) {
        readFile(fname);
    }

    public static void main(String[] args) {
        KruskalTest wgk = new KruskalTest("Graph_11.txt");

//        wgk.printGraph();
        wgk.printKruskalMST();
        System.out.println("-----");
    }

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

    public void printGraph() {
        //인접리스트 출력
        System.out.println("<Graph>");
        for(int v=0;v<g.V;v++) {
            System.out.print(v + " : ");
            Node node = g.adj[v].head;
            while(node != null) {
                System.out.print("(" + node.vertex + ", " + node.weight + ") ");
                node = node.next;
            }
            System.out.println();
        }
    }
    public void printKruskalMST() {
        //크루스칼 알고리즘으로 MST 구하기
        System.out.println("<Kruskal MST>");
        Kruskal kruskal = new Kruskal(g);
        //MST 간선 출력하기
        System.out.println("Minimal Cost = " + kruskal.cost);
        for(int i=0;i<kruskal.mst.length;i++) {
            System.out.println("(" + kruskal.mst[i].v + ", " + kruskal.mst[i].w +
                    ", "+kruskal.mst[i].wt+")");
        }
    }
}
