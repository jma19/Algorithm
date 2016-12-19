package com.uci.mj;

import java.util.Stack;

/**
 * Created by junm5 on 10/2/16.
 */
public class PreorderNonRecursive {

    public void preOrder (ListNode root){
        Stack<ListNode> stack = new Stack<ListNode>();

    }
    public String simplifyPath(String path) {
        if(path == null || path.equals("")){
            return path ;
        }
        int lastIndex = path.lastIndexOf("/");
        int index = lastIndex -1;
        while (index >=0  &&  path.charAt(index) != '/'){
                index --;
        }
        return path.substring(index, lastIndex);
    }

    public static void main(String[] args){
        PreorderNonRecursive preorderNonRecursive = new PreorderNonRecursive();
        String s = preorderNonRecursive.simplifyPath("/home/");
        System.out.println(s);

    }
    public void postOrder(ListNode root){



    }
}
