package org.vit.java.tutor.arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ArraysUtilTest {

	
	@Test
	public void shouldCountAllEvenElements() {
		int[] actualIntArray = {2, 1, 2, 3, 4};
		
		assertThat(ArraysUtil.countEvenElements(actualIntArray), is(3));
	}
}
