package others.jzoffer.duplicate_number;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateNumber {
    List<Integer> duplicate1(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicate = new ArrayList<>();
        for (int n : numbers) {
            if (!set.add(n)) {
                duplicate.add(n);
            }
        }
        System.out.println(duplicate);
        return duplicate;
    }

    boolean duplicate2(int[] numbers) {
        List<Integer> duplicate = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    return true;
                }

                int tmp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DuplicateNumber duplicateNumber = new DuplicateNumber();
        duplicateNumber.duplicate1(new int[]{1, 2, 3, 5, 3, 6, 2});
        System.out.println(duplicateNumber.duplicate2(new int[]{0,2,1,4,3}));
    }
}
