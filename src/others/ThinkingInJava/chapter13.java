package others.ThinkingInJava;

import java.util.*;

public class chapter13 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");
        System.out.println(hashSet);

        SortedSet<String> sortedSet = new TreeSet<String>();
        sortedSet.add("one");
        sortedSet.add("two");
        sortedSet.add("three");

        SortedSet<String> sort = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        sort.addAll(sortedSet);
        sort.add("a");
        System.out.println(sort);
        System.out.println();

    }
}
