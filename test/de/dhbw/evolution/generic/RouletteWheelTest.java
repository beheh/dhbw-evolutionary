
package de.dhbw.evolution.generic;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author benedict
 */
public class RouletteWheelTest {

	public RouletteWheelTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

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
		System.out.println("Expecting around [1, 5, 50, 50]: "+Arrays.toString(results));
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
		System.out.println("Expecting around [25, 25, 25, 25]: "+Arrays.toString(results));
	}
}
