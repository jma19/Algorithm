#### 120: Triangle
**Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.**

For example, given the following triangle

```
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
```

The minimum path sum from top to bottom is`11`\(i.e.,2+3+5+1= 11\).

**Note:**  
Bonus point if you are able to do this using onlyO\(n\) extra space, wherenis the total number of rows in the triangle.

####Analysis
We can use 'top-down' DP to slove this problem. Starting from the node on the very top, we recursively find that in level i, as for node j, the minimun path can be concluded as:

~~~
minpath[i][j] = min(j > list(i).size() ? MAX_VALUE : minpath[i-1][j], j-1 < 0 ? MAX_VALUE : minpath[i-1][j-1] ) + triangle[i][j] 
~~~

We need to allocate same space with input to store the tempary answer, which takes O(N^2) space.  



```
[
     [2],   
    [3,4],
   [6,5,7], -----i - 1
  [4,1,8,3] ----- dp(i,j) = min(dp[i-1, j-1], dp[i-1, j]) + list(i).get(j);
]
```





