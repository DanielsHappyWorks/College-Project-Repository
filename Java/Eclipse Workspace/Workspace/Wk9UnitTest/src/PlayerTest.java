
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
/*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		System.out.println("tearDownAfterClass...");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		System.out.println("tearDownAfterClass...");
	}
*/
	Player p1;
	@Before
	/*public void setUp() throws Exception 
	{
		System.out.println("setUp...");
		this.p1 = new Player("abc", 100, 1, 2, 3);
	}

	@After
	public void tearDown() throws Exception 
	{
		this.p1 = null;
	}*/

	@Test
	public void testGetName() 
	{
		
		this.p1 = new Player("abc", 100, 1, 2, 3);
		assertNotNull(p1);
		
		assertEquals(this.p1.getName(), "abc");
		/*
		assertEquals(this.p1.getBalance(), "1000", "0.01");
		assertFalse();
		assertTrue();
		assertNull();
		assertNotNull(this.p1);
		*/
	}

	@Test
	public void testSetName() 
	{
		fail("Do later");
	}


	

}
