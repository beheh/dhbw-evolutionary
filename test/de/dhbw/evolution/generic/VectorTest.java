
package de.dhbw.evolution.generic;

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
public class VectorTest {

	public VectorTest() {
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

	/**
	 * Test of set method, of class Vector.
	 */
	@Test
	public void testSet() {
		System.out.println("set");
		int i = 0;
		double x = 0.0;
		Vector instance = null;
		instance.set(i, x);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setX method, of class Vector.
	 */
	@Test
	public void testSetX() {
		System.out.println("setX");
		double x = 0.0;
		Vector instance = null;
		instance.setX(x);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setY method, of class Vector.
	 */
	@Test
	public void testSetY() {
		System.out.println("setY");
		double y = 0.0;
		Vector instance = null;
		instance.setY(y);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setZ method, of class Vector.
	 */
	@Test
	public void testSetZ() {
		System.out.println("setZ");
		double z = 0.0;
		Vector instance = null;
		instance.setZ(z);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of get method, of class Vector.
	 */
	@Test
	public void testGet() {
		System.out.println("get");
		int i = 0;
		Vector instance = null;
		double expResult = 0.0;
		double result = instance.get(i);
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getX method, of class Vector.
	 */
	@Test
	public void testGetX() {
		System.out.println("getX");
		Vector instance = null;
		double expResult = 0.0;
		double result = instance.getX();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getY method, of class Vector.
	 */
	@Test
	public void testGetY() {
		System.out.println("getY");
		Vector instance = null;
		double expResult = 0.0;
		double result = instance.getY();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getZ method, of class Vector.
	 */
	@Test
	public void testGetZ() {
		System.out.println("getZ");
		Vector instance = null;
		double expResult = 0.0;
		double result = instance.getZ();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of subtract method, of class Vector.
	 */
	@Test
	public void testSubtract() {
		System.out.println("subtract");
		Vector vector = null;
		Vector instance = null;
		Vector expResult = null;
		Vector result = instance.subtract(vector);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAbs method, of class Vector.
	 */
	@Test
	public void testGetAbs() {
		System.out.println("getAbs");
		Vector instance = null;
		double expResult = 0.0;
		double result = instance.getAbs();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getDistance method, of class Vector.
	 */
	@Test
	public void testGetDistance() {
		System.out.println("getDistance");
		Vector vector = null;
		Vector instance = null;
		double expResult = 0.0;
		double result = instance.getDistance(vector);
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of print method, of class Vector.
	 */
	@Test
	public void testPrint() {
		System.out.println("print");
		int digits = 0;
		Vector instance = null;
		String expResult = "";
		String result = instance.print(digits);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of toString method, of class Vector.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Vector instance = null;
		String expResult = "";
		String result = instance.toString();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of clone method, of class Vector.
	 */
	@Test
	public void testClone() throws Exception {
		System.out.println("clone");
		Vector instance = null;
		Vector expResult = null;
		Vector result = instance.clone();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
