package leetcode.leetcode500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode500 {
    public static String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        String[] params = {"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
        int flag = 0;
        boolean isValid = true;
        for (int i = 0; i < words.length; i++) {
            if (params[0].contains(words[i].substring(0, 1))) {
                flag = 0;
            } else if (params[1].contains(words[i].substring(0, 1))) {
                flag = 1;
            } else {
                flag = 2;
            }
            System.out.println(flag);
            isValid = true;
            for (int j = 1; j < words[i].length(); j++) {
                if (!params[flag].contains(words[i].substring(j, j + 1))) {
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                list.add(words[i]);
            }

        }

        String[] result =  list.toArray(new String[list.size()]);

        return result;
    }


    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(findWords(words)));
    }
}
