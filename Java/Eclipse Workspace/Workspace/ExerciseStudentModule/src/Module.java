public class Module {
	private String name;
	private int ca, exam;
	
	public Module(String name, int ca, int exam) {
		super();
		this.name = name;
		this.ca = ca;
		this.exam = exam;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCa() {
		return ca;
	}

	public void setCa(int ca) {
		this.ca = ca;
	}

	public int getExam() {
		return exam;
	}

	public void setExam(int exam) {
		this.exam = exam;
	}

	@Override
	public String toString() {
		return "Module [name=" + name + ", ca=" + ca + ", exam=" + exam + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ca;
		result = prime * result + exam;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Module other = (Module) obj;
		if (ca != other.ca)
			return false;
		if (exam != other.exam)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
