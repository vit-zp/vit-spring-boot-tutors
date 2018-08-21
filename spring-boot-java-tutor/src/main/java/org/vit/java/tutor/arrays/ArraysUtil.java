package org.vit.java.tutor.arrays;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class ArraysUtil {

    /*
    Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.

     */
    public static int countEvenElements(int[] intArr) {
        return (int)Arrays.stream(intArr)
                .filter(i -> i % Integer.valueOf(2) == Integer.valueOf(0))
                .count()
                ;

    }

    /*

Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array.
     */
    public static int diffMaxMin(int[] intArr) {
        IntSummaryStatistics intSummaryStatistics = Arrays.stream(intArr).summaryStatistics();
        return intSummaryStatistics.getMax() - intSummaryStatistics.getMin();
    }

    /*
    Return the "centered" average of an array of ints, which we'll say is the mean average of the values, except ignoring
    the largest and smallest values in the array. If there are multiple copies of the smallest value, ignore just one copy,
    and likewise for the largest value. Use int division to produce the final average. You may assume that the array
    is length 3 or more.
     */
    public static int centeredAverage(int[] intArr) {
        IntSummaryStatistics intSummaryStatistics = Arrays.stream(intArr).summaryStatistics();
        return (int) (intSummaryStatistics.getSum() - (intSummaryStatistics.getMax() + intSummaryStatistics.getMin())) / ((int) intSummaryStatistics.getCount() - 2);
    }


    /*
    code below doesn't work due to NOT EFFECTIVELY FINAL skipNEXT vak
     */
    public static int sum13(int[] nums) {
//        boolean skipNext = false;
//        return Arrays.stream(nums).reduce((a, i)-> {
//            if (i==13) {
//                skipNext = true;
//            } else if (skipNext) {
//                skipNext = false;
//            } else {
//                a = a + i;
//            }
//            return a;
//        }).get();
        return 0;
    }
}
