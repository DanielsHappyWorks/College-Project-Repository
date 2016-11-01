package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Controller.PersonList;
import Controller.TaskList;
import Model.CompletionStatus;
import Model.DataPackage;
import Model.Person;
import Model.Task;

public class TaskListTest {
	DataPackage dp;
	TaskList tlist;
	Task t1;
	Task t2;
	Task t3;
	PersonList plist;
	Person p1;
	Person p2;
	Person p3;
	@Before
	public void setUp() throws Exception {
		this.tlist = new TaskList();
		
		Calendar cal  = Calendar.getInstance();
		
		t1 = new Task("Test", cal);
		cal.set(2014, 12, 12, 12, 0, 0);
		t2 = new Task("Work", cal);
		cal.set(2013, 11, 20, 9, 30, 0);
		t3 = new Task("Finish", cal);
		
		this.plist = new PersonList();
		p1 = new Person("Daniel","Daniel@gmail.com","0871710782");
		p2 = new Person("Daniel","Foth@gmail.com","0871710782");
		p3 = new Person("Peter","Peter@gmail.com","0898712782");
	}

	@After
	public void tearDown() throws Exception {
		this.tlist = null;
		t1 = null;
		t2 = null;
		t3 = null;
		this.plist =  null;
		p1 =  null;
		p2 =  null;
		p3 =  null;
	}
	
	@Test
	public void testAddUnique() {
		this.tlist.add(t1);
		//checks if you can add something
		assertNotNull(this.tlist);
		assertEquals(this.tlist.getTaskList().size(), 1);
		//checks if you can add the same thing multiple times
		this.tlist.add(t1);
		assertEquals(this.tlist.getTaskList().size(), 1);
		//checks if adds different things
		this.tlist.add(t3);
		assertEquals(this.tlist.getTaskList().size(), 2);
		this.tlist = null;
	}
	@Test
	public void testEdit() {
		tlist.add(t1);
		//checks status edit
		tlist.editStatus(tlist.getTaskList().get(0).getId(), CompletionStatus.Ongoing);
		assertEquals(tlist.getTaskList().get(0).getStatus(), CompletionStatus.Ongoing);
		//checks Leader edit
		tlist.editLeader(tlist.getTaskList().get(0).getId(), p1);
		assertEquals(tlist.getTaskList().get(0).getTaskLeader(), p1);
		//checks Team edit
		ArrayList<Person> pList = new ArrayList<Person>();
		pList.add(p2);
		pList.add(p2);
		tlist.editTeam(tlist.getTaskList().get(0).getId(), pList);
		assertEquals(tlist.getTaskList().get(0).getTaskTeam(), pList);
		//checks Date edit(all are the same)
		Calendar start  = Calendar.getInstance();
		start.set(2019, 12, 12, 12, 0, 0);
		tlist.editStartDate(tlist.getTaskList().get(0).getId(), start);
		assertEquals(tlist.getTaskList().get(0).getStartDate(), start);
	}
	@Test
	public void testPrint() {
		tlist.add(t1);
		tlist.add(t2);
		tlist.add(t3);

		//checks if 3 things were printed
		assertEquals(tlist.print(), 3);
	}
	@Test
	public void testPrintByStatus() {
		CompletionStatus status = CompletionStatus.Completed;
		
		tlist.add(t1);
		tlist.getTaskList().get(0).setStatus(CompletionStatus.Completed);
		tlist.add(t2);
		tlist.getTaskList().get(1).setStatus(CompletionStatus.Completed);
		
		assertEquals(tlist.printByStatus(status),2);
	}
	@Test
	public void testPrintByLeader() {
		tlist.add(t1);
		tlist.getTaskList().get(0).setTaskLeader(p1);
		tlist.add(t2);
		tlist.getTaskList().get(1).setTaskLeader(p1);
		
		//assertEquals(editTaskLeader(),2);
		fail("could not get test working");
	}
	@Test
	public void testAverageCompTime() {
		fail("not enough time to test");
	}
	@Test
	public void testPrintByDateRange() {
		fail("not enough time to code");
	}
	@Test
	public void testSortBy() {
		fail("not enough time to test");
	}
	@Test
	public void testCompareTwoTasks() {
		tlist.add(t1);
		tlist.add(t2);
		tlist.add(t3);
		
		assertEquals(tlist.testForEquality(1000, 1000),true);
		assertEquals(tlist.testForEquality(1000, 1002),false);
	}
	@Test
	public void testCopyTask() {
		Task newTask = t1.clone();
		assertNotNull(newTask);
		if(!newTask.equals(t1))
		{
			fail("They should be equal");
		}
	}
	@Test
	public void testLeaderOverdueBy() {
		fail("not enough time to code");
	}
	
	}
	/*
	*@Test
	*public void testLoad{
	*
	*	 * boolean exists = SerializationUtility.exists("", "Data.dp");
	*if (exists) {
	*		DataPackage LoadedData = (DataPackage) SerializationUtility.load("", "Data.dp");
	*		people = LoadedData.getPeople();
	*		tasks = LoadedData.getTasks();
	*	}
	*	
	*	fail("Dont know how to test");
	*}
	*@Test
	*public void testSave{
	*
	*	 DataPackage dp = new DataPackage(people, tasks);
	*	System.out.println("Saving Data...");
	*	SerializationUtility.save("", "Data.dp", dp);
	*	System.out.println("Save Complete");
	*	System.out.println("GoodBye");
	*
	*	fail("Dont know how to test");
	*}
	*/
