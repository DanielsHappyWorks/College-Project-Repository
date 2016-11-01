/*
 *  Version 0.2
 * -telephone changed to string and default constructor added
 * -Added basic validation
 * 
 * Version 0.1
 * -added hashcode and equals
 * 
 * Version 0.0
 * -class with getters/setters and a to string
 * 
 */

package Model;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = 6790891347724004221L;

	static int count = 1000;
	
	private String name, email, telephone;
	private int id;
	
	public Person()
	{
		this.name = "Default";
		this.id = count++;
		this.email = "Default@gmail.com";
		this.telephone = "0879999999";
	}
	public Person(String name,  String email, String telephone) {
		this.setName(name);
		this.id = count++;
		this.setEmail(email);
		this.setTelephone(telephone);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.length()>1 && name.length()<=32)
		{
			this.name = name;
		}
		else
		{
			this.name = "Default";
		}
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email.length()>4 && email.length()<=52)
		{
			this.email = email;
		}
		else
		{
			this.email = "Default@gmail.com";
		}
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
		if(email.length()>2 && email.length()<=14)
		{
			this.telephone = telephone;
		}
		else
		{
			this.telephone = "0879999999";
		}
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", telephone=" + telephone + ", id=" + id + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}
	
}