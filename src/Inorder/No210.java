package Inorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 拓扑排序就是后序遍历反转之后的结果，且拓扑排序只能针对有向无环图，进行拓扑排序之前要进行环检测
 */
public class No210 {
    /**
     * 课程表II
     * https://leetcode-cn.com/problems/course-schedule-ii/
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        List<Integer>[] graph = build(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
            if (hasCycle) {
                return new int[]{};
            }
        }
        Collections.reverse(order);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = order.get(i);
        }
        return res;
    }

    public List<Integer>[] build(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    boolean[] visited;
    boolean hasCycle = false;
    boolean[] onPath;
    List<Integer> order = new ArrayList<>();

    public void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            hasCycle = true;
        }
        if (visited[s] || hasCycle)
            return;

        visited[s] = true;
        onPath[s] = true;
        for (int i : graph[s]) {
            traverse(graph, i);
        }
        onPath[s] = false;
        order.add(s);
    }
}
