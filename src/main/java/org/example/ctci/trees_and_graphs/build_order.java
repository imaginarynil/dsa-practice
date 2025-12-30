package org.example.ctci.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class build_order {
    Project[] buildOrder_Solution_1(String[] projectNames, String[][] dependencies) {
        Graph g = buildGraph(projectNames, dependencies);
        return orderProjects(g.getNodes());
    }

    public Graph buildGraph(String[] projectNames, String[][] dependencies) {
        Graph g = new Graph();
        for (String name : projectNames) {
            g.getOrCreateNode(name);
        }
        for (String[] dependency : dependencies) {
            g.addEdge(dependency[0], dependency[1]);
        }
        return g;
    }

    public Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];
        int endOfList = addNodesWithoutDependencies(order, projects, 0);
        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project currentProject = order[toBeProcessed];
            // circular dependency detected. example: a -> a, then order[0] = null
            // a -> b -> b. first pass ok, second pass null
            if (currentProject == null) {
                return null;
            }
            // remove the curr node as a dependency of its children. removing the outgoing edges of the curr node.
            ArrayList<Project> children = currentProject.getChildren();
            for (Project child : children) {
                child.decrementDependencyCount();
            }
            // find nodes that don't have incoming edges
            endOfList = addNodesWithoutDependencies(order, children, endOfList);
            toBeProcessed += 1;
        }
        return order;
    }

    // insert nodes that don't have any dependencies into the build order
    public int addNodesWithoutDependencies(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project p : projects) {
            if (p.getDependencyCount() == 0) {
                order[offset] = p;
                offset += 1;
            }
        }
        return offset;
    }

    void main() {
        String[] projectNames = {"a", "b", "c", "d", "e", "f", "g"};
        String[][] dependencies = {{"f", "c"}, {"f", "b"}, {"c", "a"}, {"f", "a"}, {"b", "a"}, {"a", "e"}, {"b", "e"}, {"d", "g"},};
        Project[] result = buildOrder_Solution_1(projectNames, dependencies);
    }

    class Graph {
        ArrayList<Project> nodes = new ArrayList<>();
        HashMap<String, Project> map = new HashMap<>();

        public Project getOrCreateNode(String projectName) {
            if (!this.map.containsKey(projectName)) {
                Project p = new Project(projectName);
                this.nodes.add(p);
                this.map.put(projectName, p);
            }
            return this.map.get(projectName);
        }

        public void addEdge(String startProjectName, String endProjectName) {
            Project startProject = this.getOrCreateNode(startProjectName);
            Project endProject = this.getOrCreateNode(endProjectName);
            startProject.addChild(endProject);
        }

        public ArrayList<Project> getNodes() {
            return nodes;
        }
    }

    class Project {
        String name;
        int dependencyCount = 0;
        ArrayList<Project> children = new ArrayList<>();
        HashMap<String, Project> childrenMap = new HashMap<>();

        public Project(String name) {
            this.name = name;
        }

        public void addChild(Project project) {
            if (!this.childrenMap.containsKey(project.getName())) {
                this.children.add(project);
                this.childrenMap.put(project.getName(), project);
                project.incrementDependencyCount(); // increase the child's dependency count (child depends on "this" node)
            }
        }

        public void incrementDependencyCount() {
            this.dependencyCount += 1;
        }

        public void decrementDependencyCount() {
            this.dependencyCount -= 1;
        }

        public int getDependencyCount() {
            return dependencyCount;
        }

        public String getName() {
            return name;
        }

        public ArrayList<Project> getChildren() {
            return children;
        }
    }

//    class Graph_Attempt_1 {
//        public HashMap<Character, ArrayList<Character>> hm = new HashMap<>();
//
//        public Graph_Attempt_1(char[] vertices) {
//            for (char v : vertices) {
//                this.hm.put(v, new ArrayList<>());
//            }
//        }
//
//        void addEdge(char first, char second) {
//            this.hm.get(first).add(second);
//        }
//    }
//
//    void buildOrder_Attempt_1() {
//        Graph_Attempt_1 g = new Graph_Attempt_1(new char[]{'a', 'b', 'c', 'd', 'e', 'f'});
//        g.addEdge('a', 'd');
//        g.addEdge('f', 'b');
//        g.addEdge('b', 'd');
//        g.addEdge('f', 'a');
//        g.addEdge('d', 'c');
//
//        char mostConnectedVertex = (char) g.hm.keySet().toArray()[0];
//        int max = -1;
//        for (char key : g.hm.keySet()) {
//            boolean[] visited = new boolean[26];
//            Queue<Character> q = new LinkedList<>();
//            q.add(key);
//            int count = 0;
//            visited[key - 'a'] = true;
//            while (!q.isEmpty()) {
//                char currentVertex = q.remove();
//                for (char c : g.hm.get(currentVertex)) {
//                    if (!visited[c - 'a']) {
//                        q.add(c);
//                        visited[c - 'a'] = true;
//                    }
//                }
//                if (!q.isEmpty()) {
//                    count += 1;
//                }
//            }
//            if (count > max) {
//                max = count;
//                mostConnectedVertex = key;
//            }
//        }
//
//        ArrayList<Character> result = new ArrayList<>();
//        boolean[] visited = new boolean[g.hm.size()];
//        Queue<Character> q = new LinkedList<>();
//        q.add(mostConnectedVertex);
//        visited[mostConnectedVertex - 'a'] = true;
//        while (!q.isEmpty()) {
//            char currentVertex = q.remove();
//            result.add(currentVertex);
//            for (char c : g.hm.get(currentVertex)) {
//                if (!visited[c - 'a']) {
//                    q.add(c);
//                    visited[c - 'a'] = true;
//                }
//            }
//        }
//        for (int i = 0; i < visited.length; i++) {
//            if (!visited[i]) {
//                result.add((char) (i + 'a'));
//            }
//        }
//    }
}
