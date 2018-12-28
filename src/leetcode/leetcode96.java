package leetcode;

public class leetcode96 {
    public static void main(String[] args){
        int n = 5;
        System.out.println(numTrees(n));
    }
    public static int numTrees(int n) {
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                result[i] += result[j]*result[i-j-1];
            }
        }
        return result[n];
    }
}
