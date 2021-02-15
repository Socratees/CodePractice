package others.jzoffer.problem58;

public class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        String[] arr = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() > 0) {
                stringBuilder.append(arr[i]);
                stringBuilder.append(" ");
            }

        }
        String res = stringBuilder.toString();
        while (res.endsWith(" ")){
            res = res.substring(0,res.length()-1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}
