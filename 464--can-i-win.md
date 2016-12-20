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
We can slove this problem resursively. We use a boolean array to record the status of using status for each 


~~~
bool canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        vector<bool> used(maxChoosableInteger + 1, false);
        return canWin(maxChoosableInteger, desiredTotal, used);
    }
    bool canWin(int length, int total, vector<bool>& used) {
        for (int i = 0; i < length; ++i) {
            if (used[i]) continue;
            used[i] = true;
            if (total <= i + 1 || !canWin(length, total - (i + 1), used)) {
                used[i] = false;
                return true;
            }
            used[i] = false;
        }
        return false;
    }
~~~

After solving several "Game Playing" questions in leetcode, I find them to be pretty similar. Most of them can be solved using the top-down DP approach, which "brute-forcely" simulates every possible state of the game.

The key part for the top-down dp strategy is that we need to avoid repeatedly solving sub-problems. Instead, we should use some strategy to "remember" the outcome of sub-problems. Then when we see them again, we instantly know their result. By doing this, we can always reduce time complexity from exponential to polynomial.

For this question, the key part is: what is the state of the game? Intuitively, to uniquely determine the result of any state, we need to know:

1. The unchosen numbers
2. The remaining desiredTotal to reach

A second thought reveals that 1) and 2) are actually related because we can always get the 2) by deducting the sum of chosen numbers from original desiredTotal.

Then the problem becomes how to describe the state using 1).

In my solution, I use a boolean array to denote which numbers have been chosen, and then a question comes to mind, if we want to use a Hashmap to remember the outcome of sub-problems, can we just use Map<boolean[], Boolean> ? Obviously we cannot, because the if we use boolean[] as a key, the reference to boolean[] won't reveal the actual content in boolean[].

Since in the problem statement, it says maxChoosableInteger will not be larger than 20, which means the length of our boolean[] array will be less than 20. Then we can use an Integer to represent this boolean[] array. How?

Say the boolean[] is {false, false, true, true, false}, then we can transfer it to an Integer with binary representation as 00110. Since Integer is a perfect choice to be the key of HashMap, then we now can "memorize" the sub-problems using Map<Integer, Boolean>.


The rest part of the solution is just simulating the game process using the top-down dp.


这道题给了我们一堆数字，然后两个人，每人每次选一个数字，看数字总数谁先到给定值，有点像之前那道Nim Game，但是比那题难度大。我刚开始想肯定说用递归啊，结果写完发现TLE了，后来发现我们必须要优化效率，使用哈希表来记录已经计算过的结果。我们首先来看如果给定的数字范围大于等于目标值的话，直接返回true。如果给定的数字总和小于目标值的话，说明谁也没法赢，返回false。然后我们进入递归函数，首先我们查找当前情况是否在哈希表中存在，有的话直接返回即可。我们使用一个整型数按位来记录数组中的某个数字是否使用过，我们遍历所有数字，将该数字对应的mask算出来，如果其和used相与为0的话，说明该数字没有使用过，我们看如果此时的目标值小于等于当前数字，说明已经赢了，或者我们调用递归函数，如果返回false，说明也是第一个人赢了。为啥呢，因为当前我们已经选过数字了，此时就该对第二个人调用递归函数，只有他的结果是false，我们才能赢，所以此时我们标记true，返回true。如果遍历完所有数字，我们标记false，返回false，参见代码如下：





