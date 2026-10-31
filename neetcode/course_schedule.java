package org.example.neetcode;

import java.util.ArrayList;

public class course_schedule {
    boolean dfs(ArrayList<ArrayList<Integer>> g, boolean[] visited, boolean[] rec, int u) {
        if(rec[u]) {
            return true;
        }
        if(visited[u]) {
            return false;
        }
        visited[u] = true;
        rec[u] = true;
        for(int v: g.get(u)) {
            if(dfs(g, visited, rec, v)) {
                return true;
            }
        }
        rec[u] = false;
        return false;
    }

    // t: O()
    // s: O()
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            g.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i] && dfs(g, visited, rec, i)) {
                return false;
            }
        }
        return true;
    }

    void main() {
        boolean res = canFinish(2, new int[][]{{0,1},{1,0}});
    }
}
