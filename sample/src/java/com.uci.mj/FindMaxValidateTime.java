package com.uci.mj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by junm5 on 12/2/16.
 */
public class FindMaxValidateTime {
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    public String solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
        List<Integer> inputs = Arrays.asList(A, B, C, D);
        int[] maxTime = new int[1];
        backtracking(maxTime, inputs, new int[]{0});
        Arrays.sort(maxTime);

        int hourInt = maxTime[0] / 100;
        int minutesInt = maxTime[0] % 100;

        if(maxTime[0] == 0){
            return "NOT POSSIBLE";
        }
        String hour = (hourInt == 0) ? "00" :
                (hourInt < 10) ? "0" + hourInt : String.valueOf(hourInt);
        String minutes = (minutesInt == 0) ? "00" :
                minutesInt < 10 ? "0" + maxTime[0] % 100 : String.valueOf(minutesInt);

        return new StringBuffer()
                .append(hour)
                .append(":").append(minutes).toString() ;
    }

    //using backtracking to solve this problem
    void backtracking(int[] maxTime, List<Integer> arr, int[] temp) {
        if (arr.size() == 0) {
            if ((temp[0] / 100) > 23 || temp[0] / 100 < 0 || (temp[0] % 100) < 0 || (temp[0] % 100) >= 60) {
                return;
            }
            if (temp[0] >= maxTime[0]) {
                maxTime[0] = temp[0];
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            temp[0] = temp[0] * 10 + arr.get(i);
            List<Integer> newArr = new ArrayList<Integer>(arr);
            newArr.remove(i);
            backtracking(maxTime, newArr, temp);
            temp[0] = temp[0] / 10;
        }
    }

    public static void main(String[] args) {
        FindMaxValidateTime findMaxValidateTime = new FindMaxValidateTime();
        String solution = findMaxValidateTime.solution(9, 7, 9, 7);
        System.out.println(solution);
    }
}
