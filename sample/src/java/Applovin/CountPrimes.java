package Applovin;

/**
 * Created by junm5 on 1/15/17.
 */
public class CountPrimes {

    //count prim number which is less than or equal n
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrimes = new boolean[n];
        for (int i = 2; i <= n; i++) {
            if (notPrimes[i] == false) {
                for (int j = 2; i * j <= n; j++) {
                    notPrimes[j] = true;
                }
            }

        }
        return count;
    }
}
