package TopologicalSort;

public class TopologicalSortingTest {
    public static DAG g;
    public static void main(String[] args) {
        TopologicalSortingTest dagt = new TopologicalSortingTest();

        dagt.printGraph();
        dagt.printTopologicalSorting();
    }

    // _________________________
    // <그래프>
    // 0 -> 4 -> 5
    //        -> 6
    // 1
    // 2
    // 3
    // <후위순회>
    // 5 6 4 0 1 2 3
    // <결과>
    // 3 2 1 0 4 5 6

    public TopologicalSortingTest() {
        g = new DAG(7);
        g.addEdge(0, 4);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 5);
        g.addEdge(4, 6);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

//        g = new DAG(6);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 4);
//        g.addEdge(3, 2);
//        g.addEdge(3, 5);
//        g.addEdge(4, 3);
//        g.addEdge(5, 0);
    }

    public void printGraph() {
        System.out.println("<DAG>");
        for(int v=0;v<g.V;v++) {
            System.out.print(v + " : ");
            Node node = g.adj[v].head;
            while(node != null) {
                System.out.print(node.vertex + " ");
                node = node.next;
            }
            System.out.println();
        }
    }

    public void printTopologicalSorting() {
        System.out.println("<Topological Sorting>");

        // way 1.
//        TopologicalSorting ts = new TopologicalSorting(g);
//        Queue tpsort = ts.res;
//        while (tpsort.size != 0) {
//            System.out.print(tpsort.dequeue() + " ");
//        }

        // way 2.
        TopologicalSorting2 ts = new TopologicalSorting2(g);
        Queue res = ts.dfs;
        while (res.size != 0) {
            System.out.print(res.dequeue() + " ");
        }
    }
}
