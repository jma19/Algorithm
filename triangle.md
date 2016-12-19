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
minpath[i][j] = min(minpath[i-1][j], j-1 < 0 ? MAX_VALUE : minpath[i-1][j-1] ) + triangle[i][j] 
~~~

We need to allocate O(m*n) space for minpath array, m = number of level, n = the nodes number of lowest level.

The code is as follows:

~~~
 public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty()){
            return 0;
        }
        int row = triangle.size();
        int col = triangle.get(row- 1).size();
        int minpath[][] = new int[row][col];
        int tempSize =  triangle.get(0).size();
        //base condition
        for(int i = 0; i < col; i++){
            if(i < tempSize){
                minpath[0][i] = triangle.get(0).get(i);
            }else{
                minpath[0][i] = Integer.MAX_VALUE;
            }
        }
        for(int i = 1; i < row; i++){
            tempSize = triangle.get(i).size();
            for(int j = 0; j <col; j++){
                if(j < tempSize){
                    minpath[i][j] = Math.min(minpath[i-1][j], j - 1 < 0 
                    ? Integer.MAX_VALUE : minpath[i-1][j-1])  + triangle.get(i).get(j);
                }else{
                    minpath[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < col; i++){
            res = Math.min(res, minpath[row - 1][i]);
        }
        return res;
    }

~~~






