package google;

class CompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int m = gas.length;

        for (int i = 0; i < m; i++) {
            int index = i;
            int sum = 0;
            boolean canFin = true;
            while (index < m) {
                sum = sum + gas[index] - cost[index];
                if (sum < 0) {
                    canFin = false;
                    if (index >= i) {
                        i = index;
                    }
                    break;
                }
                index = (index + 1) % m;
                if (index == i) {
                    break;
                }
            }
            if (canFin) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CompleteCircuit solution = new CompleteCircuit();
        boolean[][] abcdds = solution.getPartitionMap("abcdd");

    }



    private boolean[][] getPartitionMap(String s){
        int m = s.length();
        //dp[i][j] represent wether string(i, j) can be partipaed as palindrome
        boolean[][] dp= new boolean[m][m];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }

        return dp;
    }}