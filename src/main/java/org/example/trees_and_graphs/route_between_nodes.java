package org.example.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class route_between_nodes {
    static boolean solve(ArrayList[] graph, int src, int dst){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        q.add(src);
        while(!q.isEmpty()) {
            int currNode = q.remove();
            if(visited[currNode]) {
                continue;
            }
            visited[src] = true;
            if(currNode == dst) {
                return true;
            }
            for(int i = 0; i < graph[currNode].size(); i++) {
                q.add((Integer) graph[currNode].get(i));
            }
        }
        return false;
    }

    static void main(){
        ArrayList[] graph = new ArrayList[6];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1);
        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(3);
        graph[3].add(4);
        graph[5].add(6);
        System.out.println(solve(graph, 0, 5));
    }
}
