package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 4/18/18.
 */
public class Test {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(2);

    }

    private static String getFormatDate(String time) {
        int indexOfSem = time.indexOf(":");

        StringBuilder sb = new StringBuilder();

        sb.append(time.substring(0, indexOfSem));

        if (!time.substring(indexOfSem + 1).startsWith("00")) {
            sb.append(time.substring(indexOfSem, indexOfSem + 3));
        }
        sb.append(" " + time.substring(time.length() - 2).toUpperCase());
        return sb.toString();
    }


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        if (numRows <= 0) {
            return res;
        }
        List<Integer> first = new ArrayList();
        first.add(1);

        res.add(first);

        for (int i = 1; i <= numRows; i++) {
            List<Integer> second = new ArrayList();
            second.add(1);
            for (int j = 1; j < first.size(); j++) {
                int a = first.get(j) + first.get(j - 1);
                second.add(a);

            }
            second.add(1);
            res.add(second);
            first = second;
        }
        return res;
    }
}
