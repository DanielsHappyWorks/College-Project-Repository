/*
 * Version 0.1
 * -Fixed by implementing Serializable
 * 
 * Version 0.0
 * -constructors and getters and setters added
 * 
 */
package Model;

import java.io.Serializable;

import Controller.PersonList;
import Controller.TaskList;

public class DataPackage implements Serializable{
	private static final long serialVersionUID = 3279344426353352361L;
	private PersonList people;
	private TaskList tasks;
	
	public DataPackage(PersonList people, TaskList tasks) {
		this.people = people;
		this.tasks = tasks;
	}

	public PersonList getPeople() {
		return people;
	}

	public void setPeople(PersonList people) {
		this.people = people;
	}

	public TaskList getTasks() {
		return tasks;
	}

	public void setTasks(TaskList tasks) {
		this.tasks = tasks;
	}
}
