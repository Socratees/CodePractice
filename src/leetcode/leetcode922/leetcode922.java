package leetcode.leetcode922;

public class leetcode922 {
    public int[] sortArrayByParityII(int[] A) {
        for(int i=0;i<A.length;i++){
            if(i%2 != A[i]%2){
                for(int j=i+1;j<A.length;j+=2){
                    if(j%2 != A[j]%2){
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                        break;
                    }
                }
            }
        }
        return A;
    }
}
