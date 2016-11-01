package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import Model.Person;
import Utility.ScannerUtility;

public class PersonList implements Serializable {
	private static final long serialVersionUID = -2333707262049000153L;
	private ArrayList<Person> list;
	Person p1;

	public PersonList() {
		this.list = new ArrayList<Person>();
	}

	public ArrayList<Person> getList() {
		return list;
	}

	public void setList(ArrayList<Person> list) {
		this.list = list;
	}

	public void add(Person p) {
		int checkIfExists=0;
		for (int i = 0; i < this.list.size(); i++) {
			if(p.equals(list.get(i))){
				checkIfExists++;
			}
		}
		if(checkIfExists==0)
		{
			this.list.add(p);
		}
		else{
			System.out.println("Failed to add because the Person was the same");
		}
	}

	public int print() {
		int count=0;
		for (Person p : list) {
			System.out.println(p);
			count++;
		}
		return count;
	}

	public boolean delete(int id) {
		Person p1;
		for (int i = 0; i < this.list.size(); i++) {
			p1 = this.list.get(i);
			if (p1.getId() == id) {
				this.list.remove(i);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Person> clear() {
		return this.list = null;
	}

	public Person edit(int id, Person p1) {
		if (p1.getId() == id) {
			String name, email, telephone;

			name = ScannerUtility.getString("Enter your new name for your person");
			email = ScannerUtility.getString("Enter your new email for your person");
			telephone = ScannerUtility.getString("Enter your new telephone for your person");

			p1.setName(name);
			p1.setEmail(email);
			p1.setTelephone(telephone);
		} else {
			System.out.println("Wrong id entered!");
		}
		return p1;
	}
	public Person findById(int id){
		for (int i = 0; i < list.size(); i++) {
			p1 = list.get(id);
			if (p1.getId() == id) {
				return p1;
			}
		}
		return null;
	}
}