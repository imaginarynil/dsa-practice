package org.example.ctci.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class route_between_nodes {
//    boolean solve(ArrayList[] graph, int src, int dst) {
//        Queue<Integer> q = new LinkedList<>();
//        boolean[] visited = new boolean[graph.length];
//        q.add(src);
//        while (!q.isEmpty()) {
//            int currNode = q.remove();
//            if (!visited[currNode]) {
//                visited[src] = true;
//                if (currNode == dst) {
//                    return true;
//                }
//                for (int i = 0; i < graph[currNode].size(); i++) {
//                    q.add((Integer) graph[currNode].get(i));
//                }
//            }
//        }
//        return false;
//    }

    boolean routeBetweenNodes_Solution(ArrayList<ArrayList<Integer>> graph, int src, int dst) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        visited[src] = true;
        q.add(src);
        while (!q.isEmpty()) {
            int node = q.remove();
            for (int x : graph.get(node)) {
                if (!visited[x]) {
                    visited[x] = true;
                    if (x == dst) {
                        return true;
                    }
                    q.add(x);
                }
            }
        }
        return false;
    }

    void main() {
//        ArrayList[] graph = new ArrayList[6];
//        for (int i = 0; i < graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//        graph[0].add(1);
//        graph[1].add(2);
//        graph[1].add(3);
//        graph[2].add(3);
//        graph[3].add(4);
//        graph[5].add(6);
//        System.out.println(solve(graph, 0, 5));

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);
        graph.get(3).add(4);
        graph.get(5).add(6);
        boolean x;
        x = routeBetweenNodes_Solution(graph, 0, 4);
        x = routeBetweenNodes_Solution(graph, 0, 6);
    }
}
