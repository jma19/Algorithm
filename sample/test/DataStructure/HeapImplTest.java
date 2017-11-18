package DataStructure;

import org.junit.Test;

import java.util.List;

/**
 * Created by junm5 on 6/25/17.
 */
public class HeapImplTest {
    @Test
    public void should_generate_n_hours() throws Exception {
        System.out.println(hours.length);
    }

    private static int[] hours = {2, 4, 8, 16};

    public static void generateHours(List<String> res, int index, int n, int hour) {

        if (n == 0 && hour < 24) {
            res.add(hour + ":");
        }
        for (int i = index; i < hours.length; i++) {
            generateHours(res, i, n - 1, hour + hours[i]);
        }
    }
}