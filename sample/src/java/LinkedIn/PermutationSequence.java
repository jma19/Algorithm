package LinkedIn;

/**
 * Created by junm5 on 12/31/16.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuffer result = new StringBuffer();
        permutationUtil(n, new boolean[n + 1], new int[]{0}, k, new StringBuffer(), result);
        return result.toString();
    }

    private void permutationUtil(int n, boolean[] visited, int[] count, int k, StringBuffer res, StringBuffer result) {
        if (res.length() == n) {
            count[0]++;
            if (count[0] == k) {
                result.append(res.toString());
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && count[0] < k) {
                visited[i] = true;
                res.append(i);
                permutationUtil(n, visited, count, k, res, result);
                res.deleteCharAt(res.length() - 1);
                visited[i] = false;
            }
        }
    }
}
