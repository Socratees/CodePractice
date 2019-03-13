package leetcode.leetcode771;

public class leetcode771 {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(int i=0;i<S.length();i++){
            String str = S.substring(i,i+1);
            for(int j=0;j<J.length();j++){
                if(J.substring(j,j+1).equals(str)){
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
