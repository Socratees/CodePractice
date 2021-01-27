package others.jzoffer.problem38;

import java.util.*;

public class Solution {
    public String[] permutation(String s) {
        if (s.length() == 0) {
            return new String[0];
        }
        if (s.length() == 1) {
            return new String[]{s};
        }
        String head = s.substring(0, 1);
        String[] arr = permutation(s.substring(1));
        Set<String> list = new HashSet<>();
        for (String tail : arr) {
            list.add(head + tail);
            for (int i = 0; i < tail.length(); i++) {
                if (!head.equals(tail.substring(i, i + 1))) {
                    list.add(tail.substring(0, i + 1) + head + tail.substring(i + 1));
                }
            }
        }
        return list.toArray(new String[0]);
    }

    public String[] permutation2(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        Set<String> result = new HashSet<>();
        boolean[] visited = new boolean[s.length()];
        backtrack(result, "", chars, visited);

        return result.toArray(new String[0]);
    }

    public void backtrack(Set<String> result, String track, char[] chars, boolean[] visited) {
        if (track.length() == chars.length) {
            result.add(track);
            return;
        }
        StringBuilder trackBuilder = null;
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                continue;
            }
            trackBuilder = new StringBuilder(track);
            trackBuilder.append(chars[i]);
            track = trackBuilder.toString();
            visited[i] = true;

            backtrack(result, track, chars, visited);

            track = track.substring(0, track.length() - 1);
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] res = solution.permutation2("0011");
        System.out.println(Arrays.toString(res));
    }
}
