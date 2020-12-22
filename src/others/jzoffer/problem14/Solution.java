package others.jzoffer.problem14;

import java.util.Arrays;

public class Solution {
    public int maxProduct(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        //f(n)=max{f(i)*f(n-i)},其中0<i<n
        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (products[j] * products[i - j] > max) {
                    max = products[j] * products[i - j];
                }
            }
            products[i] = max;
        }

        System.out.println(Arrays.toString(products));
        return products[length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(6));
    }
}
