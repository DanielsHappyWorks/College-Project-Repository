import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MathUtilityTest {

	@Test
	public void testAdd() {
		int result = MathUtility.add(0, 0);
		assertEquals(result, 0);
		
		int result2 = MathUtility.add(-1, -1);
		assertEquals(result2, -2);
		
		int result3 = MathUtility.add(10, -10);
		assertEquals(result3, 0);
		
		int result4 = MathUtility.add(10, 10);
		assertEquals(result4, 20);
	}

	@Test
	public void testDivide() {
		double result = MathUtility.divide(1, 0);
		assertEquals(result, 0, 0);
		
		double result2 = MathUtility.divide(0, 1);
		assertEquals(result2, 0, 0);
		
		double result3 = MathUtility.divide(0, 0);
		assertEquals(result3, 0, 0);
		
		double result4 = MathUtility.divide(100, 10);
		assertEquals(result4, 10, 0);
		
		double result5 = MathUtility.divide(5, 9);
		assertEquals(result5, 0.5555, 0.1);
	}

	@Test
	public void testPow() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsIntInt() {
		fail("Not yet implemented");
	}

}
