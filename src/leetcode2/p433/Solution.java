package leetcode2.p433;

public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int[][] map = new int[bank.length][bank.length];
        for (int i = 0; i < bank.length; i++) {
            for (int j = i + 1; j < bank.length; j++) {
                if(distance(bank[i], bank[j]) == 1){
                    map[j][i] = map[i][j] = 1;
                }
            }
        }
        
    }

    public int distance(String s1, String s2) {
        int dist = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }
}
