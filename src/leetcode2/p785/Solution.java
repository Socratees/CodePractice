package leetcode2.p785;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] coloredNode = new int[graph.length];
        coloredNode[0] = 1;
        for (int i = 0; i < graph[0].length; i++) {
            coloredNode[graph[0][i]] = -1;
        }
        for (int i = 1; i < coloredNode.length; i++) {
            if (coloredNode[i] == -1) {
                int[] connectNodes = graph[i];
                for (int j = 0; j < connectNodes.length; j++) {
                    if (connectNodes[j] != 0) {
                        if (coloredNode[connectNodes[j]] == -1) {
                            return false;
                        } else {
                            coloredNode[connectNodes[j]] = 1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < coloredNode.length; i++) {
            if (coloredNode[i] == 0) {
                return false;
            }
            int[] nodes = graph[i];
            for (int j = 0; j < nodes.length; j++) {
                if (coloredNode[i] == coloredNode[graph[i][j]]) {
                    return false;
                }
            }
        }

        return true;
    }
}
