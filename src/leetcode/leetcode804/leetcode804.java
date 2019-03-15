package leetcode.leetcode804;

public class leetcode804 {
    public int uniqueMorseRepresentations(String[] words) {
        int counter = 0;
        String[] result = new String[words.length];
        String[] moss = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                int index = (int) (c - 97);
                result[i] += moss[index];
            }

            boolean flag = true;
            for (int k = i - 1; k >= 0; k--) {
                if(result[k].equals(result[i])){
                    flag = false;
                    break;
                }
            }
            if(flag){
                counter++;
            }
        }

        return counter;
    }
}
