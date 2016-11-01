/*
 * Version 0.41
 * -edit now has working methods
 * 
 * Version 0.4
 * -delete, add and print added for task
 * -new menu for editing tasks added
 * 
 * Version 0.3
 * -Saving files works
 * 
 * Version 0.2
 * -edit Added
 * -save added but not working
 * 
 * Version 0.12
 * -delete works now
 * 
 * 
 * Version 0.1
 * -add/person person working
 * -delete person nearly working (crashes on deleting last person in list)
 * 
 * 
 * Version 0.0
 * -Creating the basic menu layout
 * -Declared some of the methods for the menus
 * 
 */

package View;

import java.util.ArrayList;
import java.util.Calendar;

import Controller.CompletionTimeMeasurer;
import Controller.PersonList;
import Controller.TaskList;
import Model.CompletionStatus;
import Model.DataPackage;
import Model.MenuOptions;
import Model.Person;
import Model.Task;
import Utility.DateUtility;
import Utility.ScannerUtility;
import Utility.SerializationUtility;

public class MainApp {

	public static void main(String[] args) {
		MainApp theApp = new MainApp();
		theApp.start();
	}

	public static PersonList people= new PersonList();
	public static TaskList tasks= new TaskList();
	public static Task copy;
	
	private MenuOptions mainMenu, taskMenu, personMenu, selectMenu, selectBySpecificDetailsMenu, selectOverDueTasksMenu;

	private void start() {
		System.out.println("This application allows the storage of tasks...");

		loadSavedData();

		initialiseMenus();

		showMainMenu();
	}

	/*****************************************
	 * Menu Related Methods
	 *****************************************/

	private void showMainMenu() {
		int choice = 0;

		do {
			choice = this.mainMenu.showMenuGetChoice("Enter your choice: ");

			if (choice == 1) {
				showTaskMenu();
			} else if (choice == 2) {
				showPersonMenu();
			} else if (choice == 3) {
				exit();
			}
		} while (choice != this.mainMenu.getIndexOfExitOption());

	}

	private void showTaskMenu() {

		int choice = 0;

		do {
			choice = this.taskMenu.showMenuGetChoice("Enter your choice: ");

			if (choice == 1) {
				editTaskMenu();
			} else if (choice == 2) {
				deleteTask();
			} else if (choice == 3) {
				addTask();
			} else if (choice == 4) {
				showSelectMenu();
			} else if (choice == 5) {
				compareTasksForEquality();
			} else if (choice == 6) {
				copyATaskStore();
			} else if (choice == 7) {
				returnAverageTimeRequiredtoCompleteTask();
			} else if (choice == 8) {
				showMainMenu();
			} else if (choice == 9) {
				exit();
			}

		} while (choice != this.mainMenu.getIndexOfExitOption());

	}

	private void showPersonMenu()

	{
		int choice = 0;

		do {
			choice = this.personMenu.showMenuGetChoice("Enter your choice: ");

			if (choice == 1) {
				editPerson();
			} else if (choice == 2) {
				deletePerson();
			} else if (choice == 3) {
				addPerson();
			} else if (choice == 4) {
				printPeople();
			} else if (choice == 5) {
				showMainMenu();
			} else if (choice == 6) {
				exit();
			}
		} while (choice != this.mainMenu.getIndexOfExitOption());

	}

	private void showSelectMenu() {

		int choice = 0;

		do {
			choice = this.selectMenu.showMenuGetChoice("Enter your choice: ");

			if (choice == 1) {
				printAllTasks();
			} else if (choice == 2) {
				showSelectBySpecificDetailsMenu();
			} else if (choice == 3) {
				selectOverDueTasksMenu();
			} else if (choice == 4) {
				showTaskMenu();
			} else if (choice == 5) {
				exit();
			}

		} while (choice != this.mainMenu.getIndexOfExitOption());
	}

	private void showSelectBySpecificDetailsMenu() {
		int choice = 0;

		do {
			choice = this.selectBySpecificDetailsMenu.showMenuGetChoice("Enter your choice: ");

			if (choice == 1) {
				byUserDefinedStatus();
			} else if (choice == 2) {
				byUserDefinedTeamLeader();
			} else if (choice == 3) {
				withinDateRange();
			} else if (choice == 4) {
				sortedByStatus();
			} else if (choice == 5) {
				byUserDefinedTeamLeaderAndNumberOfDays();
			} else if (choice == 6) {
				showSelectMenu();
			} else if (choice == 7) {
				exit();
			}

		} while (choice != this.mainMenu.getIndexOfExitOption());

	}

	private void selectOverDueTasksMenu() {
		int choice = 0;

		do {
			choice = this.selectOverDueTasksMenu.showMenuGetChoice("Enter your choice: ");

			if (choice == 1) {
				selectByOverdueTasks();
			} else if (choice == 2) {
				notifyAboutOverdueTasks();
			} else if (choice == 3) {
				selectOverdueTasks();
			} else if (choice == 4) {
				showSelectMenu();
			} else if (choice == 5) {
				exit();
			}

		} while (choice != this.mainMenu.getIndexOfExitOption());

	}
	private void editTaskMenu() {
		int choice = 0;

		do {
			choice = this.selectOverDueTasksMenu.showMenuGetChoice("Enter your choice: ");
			if (choice == 1) {
				editTaskName();
			} else if (choice == 2) {
				editTaskLeader();
			} else if (choice == 3) {
				editTaskTeam();
			} else if (choice == 4) {
				editTaskStartDate();
			} else if (choice == 5) {
				editTaskEndDate();
			}else if (choice == 6) {
				editTaskCompletionDate();
			} else if (choice == 7) {
				editTaskStatus();
			}else if (choice == 8) {
				showTaskMenu();
			} else if (choice == 9) {
				exit();
			}

		} while (choice != this.mainMenu.getIndexOfExitOption());

	}

	/*****************************************
	 * Initialisation Methods
	 *****************************************/
	private void loadSavedData() {
		boolean exists = SerializationUtility.exists("", "Data.dp");
		if (exists) {
			DataPackage LoadedData = (DataPackage) SerializationUtility.load("", "Data.dp");
			people = LoadedData.getPeople();
			tasks = LoadedData.getTasks();
		}
	}

	private void initialiseMenus() {
		// main menu
		this.mainMenu = new MenuOptions("Main Menu", 3);
		this.mainMenu.add("Task Menu");
		this.mainMenu.add("Person Menu");
		this.mainMenu.add("Exit");

		// Task menu
		this.taskMenu = new MenuOptions("Task Menu", 9);
		this.taskMenu.add("Edit Task");
		this.taskMenu.add("Delete Task");
		this.taskMenu.add("Add Task");
		this.taskMenu.add("Select Task");
		this.taskMenu.add("Compare Tasks For Equality");
		this.taskMenu.add("Copy a task store");
		this.taskMenu.add("Return Average Time Required to Complete Task");
		this.taskMenu.add("Back to Previous Menu");
		this.taskMenu.add("Exit");

		// Person menu
		this.personMenu = new MenuOptions("Person Menu", 6);
		this.personMenu.add("Edit Person");
		this.personMenu.add("Delete Person");
		this.personMenu.add("Add Person");
		this.personMenu.add("Print People");
		this.personMenu.add("Back to Previous Menu");
		this.personMenu.add("Exit");

		// Select menu
		this.selectMenu = new MenuOptions("Select Menu", 5);
		this.selectMenu.add("Print all tasks");
		this.selectMenu.add("Select task by specific details");
		this.selectMenu.add("Select Overdue tasks");
		this.selectMenu.add("Back to Previous Menu");
		this.selectMenu.add("Exit");

		// Select by Specific Details to menu
		this.selectBySpecificDetailsMenu = new MenuOptions("Select by Specific Details", 7);
		this.selectBySpecificDetailsMenu.add("By User-Defined Status");
		this.selectBySpecificDetailsMenu.add("By User-Defined Team Leader");
		this.selectBySpecificDetailsMenu.add("Within Date Range");
		this.selectBySpecificDetailsMenu.add("Sorted by Status");
		this.selectBySpecificDetailsMenu
				.add("By a User-Defined Team Leader Which Were Overdue By More Than a User-Defined Number of Days");
		this.selectBySpecificDetailsMenu.add("Back to Previous Menu");
		this.selectBySpecificDetailsMenu.add("Exit");

		// Select over due tasks menu
		this.selectOverDueTasksMenu = new MenuOptions("Select over due tasks menu", 5);
		this.selectOverDueTasksMenu.add("Select by Overdue Tasks");
		this.selectOverDueTasksMenu.add("Notify About Overdue Tasks");
		this.selectOverDueTasksMenu.add("Select Overdue Tasks");
		this.selectOverDueTasksMenu.add("Back to Previous Menu");
		this.selectOverDueTasksMenu.add("Exit");

		// edit task menu
		this.selectOverDueTasksMenu = new MenuOptions("Edit task menu", 9);
		this.selectOverDueTasksMenu.add("Change/Set Task Name");
		this.selectOverDueTasksMenu.add("Change/Set Task Leader");
		this.selectOverDueTasksMenu.add("Change/Set Task Team");
		this.selectOverDueTasksMenu.add("Change/Set Start Date");
		this.selectOverDueTasksMenu.add("Change/Set End Date");
		this.selectOverDueTasksMenu.add("Change/Set Competion Date");
		this.selectOverDueTasksMenu.add("Change/Set Status");
		this.selectOverDueTasksMenu.add("Back to Previous Menu");
		this.selectOverDueTasksMenu.add("Exit");
	}

	/*****************************************
	 * Main Related Methods
	 *****************************************/

	private void selectOverdueTasks() {
		// TODO Auto-generated method stub
		//prints all of the overdue tasks
		System.out.println("Not Implemented");
	}
	private void byUserDefinedTeamLeaderAndNumberOfDays() {
		// TODO Auto-generated method stub
		//select overdue tasks
		//filter tasks by leader id
		//find date difference using a measurer
		//print data
		System.out.println("Not Implemented");
	}

	private void withinDateRange() {
		// TODO Auto-generated method stub
		//take two dates
		//select everything between dates
		//print data
		System.out.println("Not Implemented");
	}
	
	private void notifyAboutOverdueTasks() {
		// TODO Auto-generated method stub
		//select overdue tasks 
		//create email
		//use email utility to send email
		System.out.println("Not Implemented");
	}

	private void selectByOverdueTasks() {
		// TODO Auto-generated method stub
		System.out.println("Not Implemented");
	}
	
	private void sortedByStatus() {
		tasks.sortByStatus();
	}
	
	private void returnAverageTimeRequiredtoCompleteTask() {
		double average = tasks.getAverageTime(new CompletionTimeMeasurer());
		System.out.println("The average is: "+average);
	}
	
	private void copyATaskStore() {
		int id;
		id = ScannerUtility.getInt("Enter Identification Number of the task you want to copy to store or -1 to print whats in store: ");
		if(id==-1){
			System.out.println(copy);
		}
		copy = tasks.getById(id);
	}

	private void compareTasksForEquality() {
		int id1,id2;
		boolean equal;
		id1 = ScannerUtility.getInt("Enter Identification Number of the task 1 you want to test for equality: ");
		id2 = ScannerUtility.getInt("Enter Identification Number of the task 2 you want to test for equality: ");
		
		equal =tasks.testForEquality(id1,id2);
		
		if(equal){
			System.out.println("The Tasks are equal");
		}
		else{
			System.out.println("The Tasks are not equal");
		}
	}

	private void addTask() {
		String name;
		int day, month, year, hourOfDay;
		Calendar startDate;

		name = ScannerUtility.getString("Enter a task name: ");
		System.out.println("Enter The start date details:");
		hourOfDay = ScannerUtility.getInt("Enter the hour of day (24 hr clock): ", 1, 24);
		day = ScannerUtility.getInt("Enter the day: ", 1, 31);
		month = ScannerUtility.getInt("Enter the month: ", 1, 12);
		year = ScannerUtility.getInt("Enter the year: ", 1996, 2050);

		startDate = DateUtility.getCalendarFrom(day, month, year, hourOfDay, 0, 0);
		Task t1 = new Task(name, startDate);
		tasks.add(t1);
		showTaskMenu();
	}

	private void deleteTask() {
		int id;
		boolean checkIfDeleted = false;
		id = ScannerUtility.getInt("Enter Identification Number of the task you want to delete: ");
		
		checkIfDeleted = tasks.delete(id);
		
		if (checkIfDeleted == false) {
			System.out.println("Wrong id entered!");
		} else {
			System.out.println("A task has been deleted");
		}
		showTaskMenu();
	}

	private void printPeople() {
		System.out.println();
		people.print();
		showPersonMenu();
	}

	private void addPerson() {
		String name, email, telephone;

		name = ScannerUtility.getString("Enter a name: ");
		email = ScannerUtility.getString("Enter persons email address: ");
		telephone = ScannerUtility.getString("Enter phone number: ");

		Person p1 = new Person(name, email, telephone);
		people.add(p1);
		showPersonMenu();
	}

	private void deletePerson() {
		int id;
		boolean checkIfDeleted = false;
		id = ScannerUtility.getInt("Enter Identification Number of the person you want to delete: ");

		checkIfDeleted = people.delete(id);
		
		if (checkIfDeleted == false) {
			System.out.println("Wrong id entered!");
		} else {
			System.out.println("A task has been deleted");
		}
		showTaskMenu();
	}

	private void editPerson() {
		int id;
		id = ScannerUtility.getInt("Enter Identification Number of person you want to edit: ");
		for (int i = 0; i < people.getList().size(); i++) {
			Person p1 = people.getList().get(i);
			p1 = people.edit(id,p1);
		}
	}

	private void printAllTasks() {
		System.out.println();
		tasks.print();
		showTaskMenu();
	}

	private int byUserDefinedTeamLeader() {
		int id,count=0;
		Person p1;
		
		id = ScannerUtility.getInt("Enter Identification Number of a Person To find the Tasks where they are the Leader: ");
		p1 = people.findById(id);
		ArrayList<Task> tList = tasks.findByLeaderId(p1);
		for (int i=0;i>tList.size();i++) {
			System.out.println(i);
			count++;
		}
		return count;
	}
	private void byUserDefinedStatus() {
		int choice;
		CompletionStatus status;
		
		System.out.println("Select a status:");
		System.out.println("[1]Completed");
		System.out.println("[2]Ongoing");
		System.out.println("[3]Paused");
		System.out.println("[4]Cancelled");
		choice = ScannerUtility.getInt("Enter the status: ",1,4);
		
		if(choice==1){
			status =CompletionStatus.Completed;
		}
		else if(choice==2){
			status =CompletionStatus.Ongoing;
		}
		else if(choice==3){
			status =CompletionStatus.Paused;
		}
		else if(choice==4){
			status =CompletionStatus.Cancelled;
		}
		else{
			status = null;
		}
		
		tasks.printByStatus(status);
	}

	private void editTaskStatus() {
		CompletionStatus status;
		int id,choice;
		
		id = ScannerUtility.getInt("Enter Identification Number of the task you want to Edit: ");
		
		System.out.println("Select a status:");
		System.out.println("[1]Completed");
		System.out.println("[2]Ongoing");
		System.out.println("[3]Paused");
		System.out.println("[4]Cancelled");
		choice = ScannerUtility.getInt("The status you want to set: ",1,4);
		
		if(choice==1){
			status =CompletionStatus.Completed;
		}
		else if(choice==2){
			status =CompletionStatus.Ongoing;
		}
		else if(choice==3){
			status =CompletionStatus.Paused;
		}
		else if(choice==4){
			status =CompletionStatus.Cancelled;
		}
		else{
			status = null;
		}
		
		tasks.editStatus(id,status);
	}

	private void editTaskCompletionDate() {
		int id,day, month, year, hourOfDay;
		Calendar completionDate = Calendar.getInstance();
		
		id = ScannerUtility.getInt("Enter Identification Number of the task you want to Edit: ");
		System.out.println("Enter The completion date details:");
		hourOfDay = ScannerUtility.getInt("Enter the hour of day (24 hr clock): ", 1, 24);
		day = ScannerUtility.getInt("Enter the day: ", 1, 31);
		month = ScannerUtility.getInt("Enter the month: ", 1, 12);
		year = ScannerUtility.getInt("Enter the year: ", 1996, 2050);
		
		completionDate = DateUtility.getCalendarFrom(day, month, year, hourOfDay, 0, 0);
		
		tasks.editCompletionDate(id,completionDate);
	}

	private void editTaskEndDate() {
		int id,day, month, year, hourOfDay;
		Calendar endDate = Calendar.getInstance();
		
		id = ScannerUtility.getInt("Enter Identification Number of the task you want to Edit: ");
		System.out.println("Enter The end date details:");
		hourOfDay = ScannerUtility.getInt("Enter the hour of day (24 hr clock): ", 1, 24);
		day = ScannerUtility.getInt("Enter the day: ", 1, 31);
		month = ScannerUtility.getInt("Enter the month: ", 1, 12);
		year = ScannerUtility.getInt("Enter the year: ", 1996, 2050);
		
		endDate = DateUtility.getCalendarFrom(day, month, year, hourOfDay, 0, 0);
		
		tasks.editEndDate(id,endDate);
	}

	private void editTaskStartDate() {
		int id,day, month, year, hourOfDay;
		Calendar startDate = Calendar.getInstance();
		
		id = ScannerUtility.getInt("Enter Identification Number of the task you want to Edit: ");
		System.out.println("Enter The start date details:");
		hourOfDay = ScannerUtility.getInt("Enter the hour of day (24 hr clock): ", 1, 24);
		day = ScannerUtility.getInt("Enter the day: ", 1, 31);
		month = ScannerUtility.getInt("Enter the month: ", 1, 12);
		year = ScannerUtility.getInt("Enter the year: ", 1996, 2050);
		
		startDate = DateUtility.getCalendarFrom(day, (month-1), year, hourOfDay, 0, 0);
		
		tasks.editStartDate(id,startDate);
	}

	private void editTaskTeam() {
		int idTask, idPerson,teamSize,j,i;
		ArrayList<Person> teamList = new ArrayList<Person>();
		Person p1;
		
		idTask = ScannerUtility.getInt("Enter Identification Number of the task you want to edit: ");
		teamSize = ScannerUtility.getInt("Enter amount of people you want to put into the task team:");
		
		for (i = 0; i < teamSize; i++) {
			idPerson = ScannerUtility.getInt("Enter Identification Number of the person you want to put on the team:");
			for (j = 0; j < people.getList().size(); j++) {
				p1 = people.getList().get(idPerson);
				if (p1.getId() == idPerson) {
					teamList.add(p1);
				}
			}
		}
		
		tasks.editTeam(idTask, teamList);
	}

	private void editTaskLeader() {
		int idTask, idLeader;
		Person taskLeader;
		
		idTask = ScannerUtility.getInt("Enter Identification Number of the task you want to edit: ");
		idLeader = ScannerUtility.getInt("Enter Identification Number of the person you want to make the task leader:");
		
		taskLeader = people.findById(idLeader);
		if(taskLeader != null){
			tasks.editLeader(idTask, taskLeader);
		}
		else{
			System.out.println("Wrong Id for task leader entered");
		}
	}

	private void editTaskName() {
		String name;
		int id;

		id = ScannerUtility.getInt("Enter Identification Number of the task you want to Edit: ");
		name = ScannerUtility.getString("Enter your new name for the task: ");
		
		tasks.editName(id,name);
	}
	private void exit() {
		DataPackage dp = new DataPackage(people, tasks);
		System.out.println("Saving Data...");
		SerializationUtility.save("", "Data.dp", dp);
		System.out.println("Save Complete");
		System.out.println("GoodBye");
		System.exit(0);
	}
}