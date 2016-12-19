package com.uci.mj;

import java.util.ArrayList;

/**
 * Created by junm5 on 11/26/16.
 */
public class Test {

    public static  void main(String [] args){
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        ArrayList<Integer> arrayList = new ArrayList(integers);
        integers.add(2);
        System.out.println(arrayList);

    }
}
