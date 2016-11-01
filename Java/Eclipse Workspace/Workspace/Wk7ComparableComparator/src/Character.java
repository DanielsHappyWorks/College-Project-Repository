
public class Character {
	private String name;
	private boolean gender;
	private int height;
	
	public Character(String name, boolean gender, int height) {
		super();
		this.name = name;
		this.gender = gender;
		this.height = height;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Character [name=" + name + ", gender=" + gender + ", height=" + height + "]";
	}
}
