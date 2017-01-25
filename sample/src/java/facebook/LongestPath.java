package facebook;

import java.util.Stack;

/**
 * Created by junm5 on 1/2/17.
 */
public class LongestPath {
    public int lengthLongestPath(String input) {
        //"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"

        Stack<Integer> stack = new Stack();
        String[] paths = input.split("\\n");
        stack.push(0);//avoid empty exception
        int maxLen = 0;
        for (String path : paths) {
            //number of \t
            int lev = path.lastIndexOf("\t") + 1;
            while (stack.size() > lev + 1) {
                stack.pop();
            }
            int len = stack.peek() + path.length() - lev + 1;//add /
            stack.push(len);
            if (path.contains(".")) {
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }
    public static void main(String [] args){
        LongestPath longestPath = new LongestPath();
        longestPath.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
    }
}

