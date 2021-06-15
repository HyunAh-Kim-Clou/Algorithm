package Kruskal;

import java.util.Arrays;

//Union-Find 자료구조
public class UnionFind {
    private int[] parent; // 부모 vertax
    private int[] depth; // 마지막 자식까지의 깊이
    private int n;

    public UnionFind(int n) {
        this.n = n;
        parent = new int[n];
        depth = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
            depth[i] = 0;
        }
    }

    //역트리의 루트 찾기(서로소집합 대표원소 찾기 연산)
    public int find(int i) {
        while(i != parent[i]) { // 부모가 있으면
            i = parent[i];
        }
        return i;
    }

    //역트리 합치기(서로소집합에 대한 합집합 연산)
    public void union(int p, int q) {
//        System.out.println("union("+p+", "+q+")");
        // 깊이가 짧은 집합을 자식노드로 붙임
        if (depth[p] == depth[q]) {
            parent[q] = p; depth[p]++;
        }
        else if (depth[p] < depth[q])
            parent[p] = q;
        else
            parent[q] = p;
        n--;
    }
}
