package de.dhbw.evolution.generic;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author benedict
 */
public class RouletteWheelTest {

	@Test
	public void testRandomness() {
		RouletteWheel<Integer> wheel = new RouletteWheel<>();
		wheel.add(0, 1);
		wheel.add(1, 5);
		wheel.add(2, 50);
		wheel.add(3, 50);
		int[] results = new int[4];
		for(int i = 0; i < 4; i++) {
			results[i] = 0;
		}
		for(int i = 0; i < 106; i++) {
			results[wheel.spin()]++;
		}
		System.out.println("Expecting around [1, 5, 50, 50]: " + Arrays.toString(results));
	}

	@Test
	public void testEqual() {
		RouletteWheel<Integer> wheel = new RouletteWheel<>();
		wheel.add(0, 0);
		wheel.add(1, 0);
		wheel.add(2, 0);
		wheel.add(3, 0);
		int[] results = new int[4];
		for(int i = 0; i < 4; i++) {
			results[i] = 0;
		}
		for(int i = 0; i < 100; i++) {
			results[wheel.spin()]++;
		}
		System.out.println("Expecting around [25, 25, 25, 25]: " + Arrays.toString(results));
	}

	@Test
	public void testZero() {
		RouletteWheel<Integer> wheel = new RouletteWheel<>();
		wheel.add(0, 1);
		wheel.add(1, 0);
		int[] results = new int[2];
		for(int i = 0; i < 2; i++) {
			results[i] = 0;
		}
		for(int i = 0; i < 100; i++) {
			results[wheel.spin()]++;
		}

		System.out.println("Expecting [100, 0]: " + Arrays.toString(results));
		Assert.assertEquals(100, results[0]);
		Assert.assertEquals(0, results[1]);
	}
}
