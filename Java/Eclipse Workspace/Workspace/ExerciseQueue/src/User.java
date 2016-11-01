public class User implements Comparable<User>
{
	private String firsName, lastName;
	private short age;
	private boolean gender;

	public User(String firsName, String lastName, short age, boolean gender)
	{
		super();
		this.firsName = firsName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}

	public String getFirsName()
	{
		return firsName;
	}

	public void setFirsName(String firsName)
	{
		this.firsName = firsName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public short getAge()
	{
		return age;
	}

	public void setAge(short age)
	{
		this.age = age;
	}

	public boolean isGender()
	{
		return gender;
	}

	public void setGender(boolean gender)
	{
		this.gender = gender;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firsName == null) ? 0 : firsName.hashCode());
		result = prime * result + (gender ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (firsName == null) {
			if (other.firsName != null)
				return false;
		}
		else if (!firsName.equals(other.firsName))
			return false;
		if (gender != other.gender)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		}
		else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "User [firsName=" + firsName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + "]";
	}
	
	/*
	@Override
	public int compareTo(User u) {
		return this.getAge()-u.getAge();
	}*/
	
	@Override
	public int compareTo(User u) {
		boolean bSameFirst = this.getFirsName().equalsIgnoreCase(u.getFirsName());
		boolean bSameLast = this.getLastName().equalsIgnoreCase(u.getLastName());
		
		if(bSameFirst && bSameLast){
			return this.getAge()-u.getAge();
		}
		else if(!bSameFirst && bSameLast){
			return this.getFirsName().compareToIgnoreCase(u.getFirsName());
		}
		else if(bSameFirst && !bSameLast){
			return this.getLastName().compareToIgnoreCase(u.getLastName());
		}
		else{
			return this.getLastName().compareToIgnoreCase(u.getLastName());
		}
	}
	
}