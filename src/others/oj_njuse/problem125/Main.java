package others.oj_njuse.problem125;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = scanner.nextInt();
        for (int c = 0; c < caseNum; c++) {
            int length = scanner.nextInt();
            scanner.nextLine();
            String line = scanner.nextLine();
            int[] nums = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                if (map.containsKey(n)) {
                    map.put(n, map.get(n) + 1);
                } else {
                    map.put(n, 1);
                }
            }
            List<Integer> keySet = new ArrayList<>(map.keySet());
            keySet = keySet.stream().sorted((o1, o2) -> map.get(o2) - map.get(o1)).collect(Collectors.toList());
//            Collections.sort(keySet, (o1, o2) -> map.get(o2) - map.get(o1));
            for (int i = 0; i < keySet.size(); i++) {
                int k = keySet.get(i);
                int v = map.get(k);
                for (int j = 0; j < v; j++) {
                    System.out.print(k);
                    if (i == keySet.size() - 1 && j == v - 1) {
                        System.out.println();
                    } else {
                        System.out.print(" ");
                    }
                }
            }
        }
    }
}
