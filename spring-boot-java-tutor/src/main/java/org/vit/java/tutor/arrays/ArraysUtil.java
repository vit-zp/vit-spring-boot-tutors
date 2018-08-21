package org.vit.java.tutor.arrays;

import java.util.Arrays;

public class ArraysUtil {

	public static int countEvenElements(int[] intArr) {
		return (int)Arrays.stream(intArr)
				.filter(i -> i % Integer.valueOf(2) == Integer.valueOf(0))
				.count()
				;
		
	}

}
