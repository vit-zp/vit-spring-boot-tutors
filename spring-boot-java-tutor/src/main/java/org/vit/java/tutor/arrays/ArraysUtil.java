package org.vit.java.tutor.arrays;

import java.util.Arrays;

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

}
