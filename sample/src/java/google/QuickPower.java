package google;

import java.util.Iterator;

/**
 * Created by junm5 on 12/18/17.
 */
public class QuickPower {
    public int getQuick(int a, int b) {
        int ans = 1;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            b >>= 1;
        }
        return ans;
    }

    public static void main(String[] args){
        QuickPower quickPower = new QuickPower();
        int quick = quickPower.getQuick(4, 3);
        System.out.println(quick);
    }
}
