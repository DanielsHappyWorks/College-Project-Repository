import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerListTest {
	public PlayerList pList;

	@Before
	public void setUp() throws Exception {
		this.pList = new PlayerList("my List");
	}

	@After
	public void tearDown() throws Exception {
		this.pList.clear();
		this.pList = null;
	}

	@Test
	public void testPlayerListString() {
		assertNotNull(this.pList);
	}

	@Test
	public void testAdd() {
		this.pList.add(new Player ("a", 100 ,1,2,3));
		assertEquals(pList.size(), 1);
		
		Player search = pList.findBy("a");
		assertNotNull(search);
		assertEquals(search.getName(), "a");
	}

	@Test
	public void testFindIndexBy() {
		this.pList.add(new Player("a",1,5,5,5));
		this.pList.add(new Player("b",1,5,5,5));
		this.pList.add(new Player("c",1,5,5,5));
		
		int index = this.pList.findIndexBy("b");
		assertEquals(index, 1);
		
		int index1 = this.pList.findIndexBy("zzzz");
		assertEquals(index1, -1);
	}

	@Test
	public void testSize() {
		assertNotNull(this.pList);
		
		assertEquals(this.pList.size(), 0);
		
		this.pList.add(new Player("a",1,5,5,5));
		this.pList.add(new Player("b",1,5,5,5));
		this.pList.add(new Player("c",1,5,5,5));
		
		assertEquals(this.pList.size(),3);
	}

	@Test
	public void testAddDuplicates()
	{
		assertNotNull(this.pList);
		this.pList.add(new Player("a",1,5,5,5));
		this.pList.add(new Player("a",1,5,5,5));
		assertEquals(this.pList.size(),2);
		
		ArrayList<Player> sList = this.pList.findAll("a");
		assertEquals(sList.size(), 2);
		assertEquals(sList.get(0).getName(), "a");
		assertEquals(sList.get(1).getName(), "a");
	}
}
