package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Controller.PersonList;
import Model.Person;

public class PersonListTest {
	PersonList list;
	Person p1;
	Person p2;
	Person p3;
	@Before
	public void setUp() throws Exception {
		this.list = new PersonList();
		p1 = new Person("Daniel","Daniel@gmail.com","0871710782");
		p2 = new Person("Daniel","Foth@gmail.com","0871710782");
		p3 = new Person("Peter","Peter@gmail.com","0898712782");
	}

	@After
	public void tearDown() throws Exception {
		this.list = null;
		p1 = null;
		p2 = null;
		p3 = null;
	}

	@Test
	public void testAddUnique() {
		this.list.add(p1);
		//checks if you can add something
		assertNotNull(this.list);
		assertEquals(this.list.getList().size(), 1);
		//checks if you can add the same thing multiple times
		this.list.add(p1);
		assertEquals(this.list.getList().size(), 1);
		//checks if adds different things
		this.list.add(p3);
		assertEquals(this.list.getList().size(), 2);
		this.list = null;
	}
	@Test
	public void testEdit() {
		list.add(p1);
		list.edit(p1.getId(), p1);
		
		if(list.getList().get(0).getName()!=p1.getName() || list.getList().get(0).getEmail()!=p1.getEmail() || list.getList().get(0).getTelephone()!=p1.getTelephone()){
			fail("The values need to be the same");
		}
		this.list = null;
	}
	@Test
	public void testPrint() {
		list.add(p1);
		list.add(p2);
		list.add(p3);

		//checks if 3 things were printed
		assertEquals(list.print(), 3);
		
		this.list = null;
	}
	public void testFindBy() {
		list.add(p1);
		//checks if wrong id gives a null
		assertEquals(list.findById(1),null);
		//checks if right id returns right person
		assertEquals(list.findById(p1.getId()),p1);
	}
	public void testRemove() {
		list.add(p1);
		list.add(p2);
		list.add(p3);
		//checks if they were added
		assertEquals(this.list.getList().size(), 3);
		//checks if the object was removed
		list.delete(1000);
		assertEquals(this.list.getList().size(), 2);
		this.list = null;
	}
}
