package org.vit.java.tutor.arrays;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArraysUtilTest {

	
	@Test
	public void shouldCountAllEvenElements() {
		int[] actualIntArray = {2, 1, 2, 3, 4};
		
		assertThat(ArraysUtil.countEvenElements(actualIntArray), is(3));
	}

	@Test
	public void shouldReturnDiffBetweenMaxAndMin() {
		int[] actualIntArray = {2, 1, 2, 3, 4};

		assertThat(ArraysUtil.diffMaxMin(actualIntArray), is(3));
	}


	@Test
	public void shouldReturnCenteredAverage() {
		int[] actualIntArray = {2, 1, 2, 3, 4};

		assertThat(ArraysUtil.centeredAverage(actualIntArray), is(3));
	}
}
