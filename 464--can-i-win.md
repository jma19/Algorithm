#### 464 . Can I Win
In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.

Example.

~~~
Input:
maxChoosableInteger = 10
desiredTotal = 11

Output:
false

Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.
~~~

#### Analysis & Solution
We can slove this problem resursively. We use a boolean array to record the status of using status for each element in array, true represents unused, and false represenetd used. The first player wins in the following two conditions:

1. The element the first player chooses is greater than the desired target. 
2. The second player recursively calls function and lose the game(return false).

~~~
 boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        boolean[] used = new boolean[maxChoosableInteger + 1];
        return canWin(maxChoosableInteger, desiredTotal, used);
    }

    boolean canWin(int maxChoosableInteger, int total, boolean[] used) {
        for (int i = 0; i < maxChoosableInteger; ++i) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            if (total <= i + 1 || !canWin(maxChoosableInteger, total - (i + 1), used)) {
                used[i] = false;
                return true;
            }
            used[i] = false;
        }
        return false;
    }
~~~

The above solution will cause LTE. We can optimize using a hashmap to store the tempary solution.


~~~
 boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        boolean[] used = new boolean[maxChoosableInteger];
        return canWin(maxChoosableInteger, desiredTotal, used, new HashMap<Integer, Boolean>());
    }

    boolean canWin(int maxChoosableInteger, int total, boolean[] used, Map<Integer, Boolean> res) {
        int cur = transform(used);
        if (res.containsKey(cur)) {
            return res.get(cur);
        }
        for (int i = 0; i < maxChoosableInteger; ++i) {
            if (!used[i]) {
                used[i] = true;
                if (total <= i + 1 || !canWin(maxChoosableInteger, total - (i + 1), used, res)) {
                    res.put(cur, true);
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
        }
        res.put(cur, false);
        return false;
    }

    private int transform(boolean[] res) {
        int cur = 0;
        for (int i = 0; i < res.length; i++) {
            cur = cur << 1;
            if (res[i]) {
                cur |= 1;
            }
        }
        return cur;
    }
~~~





