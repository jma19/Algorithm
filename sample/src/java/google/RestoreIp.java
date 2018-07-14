package google;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by junm5 on 12/14/17.
 */
public class RestoreIp {
    public List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }

    private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && idx == ip.length()) {
            solutions.add(restored);
            return;
        }
        ;

        for (int i = 1; i < 4 && ((idx + i) <= ip.length()); i++) {
            String s = ip.substring(idx, idx + i);
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256)) {
                continue;
            }
            restoreIp(ip, solutions, idx + i, restored + s + (count == 3 ? "" : "."), count + 1);
        }
    }

    public int change(int amount, int[] coins) {
        //can be solved using dynamatic progrmming
        //dp[i] = dp[i - 1] + dp[i - 2] + dp

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int k = 0; k < coins.length && (i - coins[k] >= 0); k++) {
                dp[i] += dp[i - coins[k]];
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        RestoreIp restoreIp = new RestoreIp();
//        List<String> strings = restoreIp.restoreIpAddresses("0000");
//        for (String ele : strings) {
//            System.out.println(ele);
//            new ArrayList<String>(new HashSet<>());
//        }
//        restoreIp.change(5, new int[]{1, 2, 5});

        List<Integer> closestElements = restoreIp.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        System.out.println(closestElements);
//        TreeSet<Integer> treeSet = new TreeSet(Arrays.asList());
//        treeSet.add(1);
//        treeSet.add(4);
//        treeSet.add(6);
//        Integer ceiling = treeSet.ceiling(1);
//        System.out.println(ceiling);
//        Integer floor = treeSet.floor(1);
//        System.out.println(floor);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> collect = IntStream.of(arr).boxed().collect(Collectors.toList());
        TreeSet<Integer> orderedSet = new TreeSet(collect);

        List<Integer> res = new ArrayList();
        for (int i = 0; i < k; i++) {
            Integer ceiling = orderedSet.ceiling(x);
            Integer floor = orderedSet.floor(x);

            if (ceiling != null && floor != null) {
                if (x - ceiling > floor - x) {
                    res.add(ceiling);
                    orderedSet.remove(ceiling);
                } else {
                    res.add(floor);
                    orderedSet.remove(floor);

                }
            } else if (ceiling != null) {
                res.add(ceiling);
                orderedSet.remove(ceiling);
            } else {
                res.add(floor);
                orderedSet.remove(floor);

            }
        }
        Collections.sort(res);
        return res;
    }

}
