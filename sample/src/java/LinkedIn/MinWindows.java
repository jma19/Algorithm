package LinkedIn;

/**
 * Created by junm5 on 12/30/16.
 */
public class MinWindows {
    public String minWindow(String s, String t) {
        //the storm will come, you need to prepare for that
        //"ADOBECODEBANC"
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        int[] map = new int[256];
        int end = 0;
        int start = 0;
        int min_length = Integer.MAX_VALUE;
        for (int i = 0; i < t_array.length; i++)
            map[t_array[i]]++;
        int count = t_array.length;
        int min_start = 0;

        while (end < s_array.length) {
            if (map[s_array[end]] > 0) {
                count--;
            }
            map[s_array[end]]--;
            while (count == 0) {
                if ((end - start + 1) < min_length) {
                    min_length = end - start + 1;
                    min_start = start;
                }
                map[s_array[start]]++;
                //no enough character to get the
                if (map[s_array[start]] > 0) {
                    count++;
                }
                start++;
            }
            end++;

        }
        if (min_start + min_length > s_array.length)
            return "";
        return s.substring(min_start, min_start + min_length);
    }
    public static void main(String [] args){
        MinWindows minWindows = new MinWindows();
        String s = minWindows.minWindow("AAAAAAABBC", "ABC");

        System.out.println(s);
    }
}
