package leetcode2.p68;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int nextPointer = 0;
        int rowNum = 0;
        List<String> line = new ArrayList<>();
        List<List<String>> lineList = new ArrayList<>();
        for (int i = 0; i < words.length; ) {
            int newPointer = nextPointer;
            //光标尝试移动
            if (nextPointer == 0) {
                //第一个单词前面无空格
                newPointer = nextPointer + words[i].length();
            } else {
                //非第一个单词都要多算一个空格
                newPointer = nextPointer + words[i].length() + 1;
            }

            if (newPointer <= maxWidth) {
                nextPointer = newPointer;
                line.add(words[i]);
                i++;
            } else {
                //一行满，开始新的一行
                lineList.add(new ArrayList<>(line));
                line = new ArrayList<>();
                nextPointer = 0;
                rowNum++;
            }
        }
        //最后一行可能未满，所以要在循环外面加入List,避免遗漏
        if (line.size() > 0) {
            lineList.add(new ArrayList<>(line));
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < lineList.size(); i++) {
            res.add(line2String(lineList.get(i), maxWidth, i == lineList.size() - 1));
        }
        return res;
    }

    /**
     * 对一行进行排版对齐
     * @param line
     * @param maxWidth
     * @param isLastLine
     * @return
     */
    public String line2String(List<String> line, int maxWidth, boolean isLastLine) {
        if (!isLastLine) {
            int lenSum = 0;
            for (String word : line) {
                lenSum += word.length();
            }
            //分配空格,n个单词应有n-1个间隔，n=1除外
            int[] spaceNumArr = allocSpace(maxWidth - lenSum, line.size());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.size(); i++) {
                sb.append(line.get(i));
                while (i < spaceNumArr.length && spaceNumArr[i] > 0) {
                    sb.append(" ");
                    spaceNumArr[i]--;
                }
            }
            return sb.toString();
        } else {
            //最后一行，单词间隔只需1个空格，且末尾需要填充空格
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.size(); i++) {
                if (i != 0) {
                    sb.append(" ");
                }
                sb.append(line.get(i));
            }
            return fillWithSpace(sb, maxWidth);
        }
    }

    /**
     * 填充空格
     *
     * @param sb
     * @param maxWidth
     * @return
     */
    public String fillWithSpace(StringBuilder sb, int maxWidth) {
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * 平均分配空格
     *
     * @param spaceNum
     * @param wordNum
     * @return
     */
    public int[] allocSpace(int spaceNum, int wordNum) {
        if (wordNum == 1) {
            return new int[]{spaceNum};
        } else {
            int base = spaceNum / (wordNum - 1);
            int remain = spaceNum % (wordNum - 1);
            int[] res = new int[wordNum - 1];
            Arrays.fill(res, base);
            for (int i = 0; i < remain; i++) {
                res[i] += 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(solution.fullJustify(words, 16));
    }
}
