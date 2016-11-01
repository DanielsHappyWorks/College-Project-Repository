package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import Model.CompletionStatus;
import Model.Person;
import Model.Task;

public class TaskList implements Serializable {
	private static final long serialVersionUID = -7101783784190955414L;
	private ArrayList<Task> list;
	Task t1;

	public TaskList() {
		this.list = new ArrayList<Task>();
	}

	public ArrayList<Task> getTaskList() {
		return list;
	}

	public void setList(ArrayList<Task> list) {
		this.list = list;
	}

	public void add(Task t) {
		int checkIfExists=0;
		for (int i = 0; i < this.list.size(); i++) {
			if(t.equals(list.get(i))){
				checkIfExists++;
			}
		}
		if(checkIfExists==0)
		{
			this.list.add(t);
		}
		else{
			System.out.println("Failed to add because the Task was the same");
		}
	}

	public int print() {
		int count=0;
		for (Task t : list) {
			System.out.println(t);
			count++;
		}
		return count;
	}

	public ArrayList<Task> clear() {
		return this.list = null;
	}

	public boolean delete(int id) {
		for (int i = 0; i < this.list.size(); i++) {
			this.t1 = this.list.get(i);
			if (this.t1.getId() == id) {
				this.list.remove(i);
				return true;
			}
		}
		return false;
	}

	public void editName(int id, String name) {
		for (int i = 0; i < list.size(); i++) {
			this.t1 = list.get(i);
			if (this.t1.getId() == id) {
				this.t1.setName(name);
			}
		}
	}

	public void editLeader(int id, Person taskLeader) {
		for (int i = 0; i < list.size(); i++) {
			this.t1 = list.get(i);
			if (this.t1.getId() == id) {
				this.t1.setTaskLeader(taskLeader);
			}
		}
	}

	public void editStatus(int id, CompletionStatus status) {
		for (int i = 0; i < list.size(); i++) {
			this.t1 = list.get(i);
			if (this.t1.getId() == id) {
				t1.setStatus(status);
			}
		}
	}

	public void editCompletionDate(int id, Calendar completionDate) {
		for (int i = 0; i < list.size(); i++) {
			this.t1 = list.get(i);
			if (this.t1.getId() == id) {
				t1.setCompletionDate(completionDate);
			}
		}
	}

	public void editEndDate(int id, Calendar endDate) {
		for (int i = 0; i < list.size(); i++) {
			this.t1 = list.get(i);
			if (this.t1.getId() == id) {
				t1.setStartDate(endDate);
			}
		}
	}

	public void editStartDate(int id, Calendar startDate) {
		for (int i = 0; i < list.size(); i++) {
			this.t1 = list.get(i);
			if (this.t1.getId() == id) {
				t1.setEndDate(startDate);
			}
		}
	}

	public void editTeam(int id, ArrayList<Person> teamList) {
		for (int i = 0; i < list.size(); i++) {
			this.t1 = list.get(i);
			if (this.t1.getId() == id) {
				this.t1.setTaskTeam(teamList);
			}
		}
	}

	public ArrayList<Task> findByLeaderId(Person p1) {
		ArrayList<Task> tList = new ArrayList<Task>();
		for (int i = 0; i < list.size(); i++) {
			this.t1 = list.get(i);
			if (this.t1.getId() == p1.getId()) {
				tList.add(list.get(i));
			}
		}
		return tList;
	}
	public int printByStatus(CompletionStatus status){
		int count=0;
		for (int i=0;i < list.size();i++) {
			if(list.get(i).getStatus()==status){
				System.out.println(i);
				count++;
			}
		}
		return count;
	}
	public boolean testForEquality(int id1,int id2){
		Task t1 = null,t2 = null;
		for (int i=0;i < list.size();i++) {
			if(list.get(i).getId()==id1){
				t1 = list.get(i);
			}
		}
		for (int i=0;i < list.size();i++) {
			if(list.get(i).getId()==id2){
				t2 = list.get(i);
			}
		}
		
		if(t1.equals(t2)){
			return true;
		}
		else{
			return false;
		}
	}

	public Task getById(int id) {
		Task t1=null;
		for (int i=0;i < list.size();i++)  {
			if(list.get(i).getId()==id){
				t1 = list.get(i);
			}
		}
		return t1;
	}
	public void sortByStatus(){
		Collections.sort(list,new statusComparator());
		for(Task t : list){
			System.out.println(t);
		}
	}

	public double getAverageTime(IMeasurer measurer) {
		double sum =0;
		
		for(int i=0;i < list.size();i++)
		{
			sum+=measurer.getValue(list.get(i));
		} 
		
		return sum/list.size();
	}
}
