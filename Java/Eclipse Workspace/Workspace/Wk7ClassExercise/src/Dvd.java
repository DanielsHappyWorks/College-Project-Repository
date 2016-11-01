
public class Dvd {
	private String name, director;
	private double cost;
	private int runtime;
	
	public Dvd(String name, String director, double cost, int runtime) {
		super();
		this.name = name;
		this.director = director;
		this.cost = cost;
		this.runtime = runtime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String toString() {
		return "Dvd [name=" + name + ", director=" + director + ", cost=" + cost + ", runtime=" + runtime + "]";
	}
	
	public void print()
	{
		System.out.println("Dvd [name=" + name + ", director=" + director + ", cost=" + cost + ", runtime in minutes=" + runtime + "]");
	}
	
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		if(obj instanceof Dvd)
		{
			Dvd dd = (Dvd)obj;
			return (this.name == dd.name) && (this.cost == dd.cost) && (this.director == dd.director) && (this.runtime == dd.runtime);
		}
		return false;
		
	}
}
