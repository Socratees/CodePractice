package leetcode.leetcode950;

import java.util.Arrays;

public class leetcode950 {
    public static int[] deckRevealedIncreasing(int[] deck) {
        int temp = 0;
        for(int i = 0; i < deck.length; i++){
            for(int j = i; j < deck.length; j++){
                if(deck[j] > deck[i]){
                    temp = deck[i];
                    deck[i] = deck[j];
                    deck[j] = temp;
                }
            }
        }

        int[] start = new int[1];
        start[0] = deck[0];

        for(int i = 1; i < deck.length; i++){

            if(i != deck.length - 1){
                int[] newArr = new int[start.length + 1];
                newArr[0] = start[start.length - 1];
                newArr[1] = deck[i];
                for(int j = 0;j < start.length - 1;j++){
                    newArr[j + 2] = start[j];
                }
                start = newArr.clone();

            }
            else{
                int[] newArr = new int[start.length + 1];
                newArr[0] = deck[i];
                for(int j = 0; j < start.length; j++){
                    newArr[j + 1] = start[j];
                }
                return newArr;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] arr = {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(arr)));
    }

}
