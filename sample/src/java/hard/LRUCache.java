package hard;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by junm5 on 9/22/17.
 */
public class LRUCache {

    public static void main(String[] args) {

        int[] nums = {34, 2, 3};
        List<String> collect = Arrays.stream(nums).boxed().map(num -> String.valueOf(num)).sorted((str1, str2) -> {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s2.compareTo(s1);
        }).collect(Collectors.toList());
        String join = String.join("", collect);
    }
}
