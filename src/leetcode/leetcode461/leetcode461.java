package leetcode.leetcode461;

public class leetcode461 {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int counter = 0;
        while (z != 0){
            if(z % 2 == 1){
                counter++;
            }
            z = z >> 1;
        }

        return counter;
    }
}
