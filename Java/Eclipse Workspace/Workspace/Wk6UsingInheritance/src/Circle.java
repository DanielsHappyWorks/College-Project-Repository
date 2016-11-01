
public class Circle extends Primitive
{
	private float radius;
	
	public Circle(int x, int y, float radius)
	{
		super(x,y);
		this.radius = radius;
	}
	
	public float getRadius(){return this.radius;}
	
	public double getArea()
	{
		return Math.PI * this.radius * this.radius;
	}
	
	public String toString()
	{
		String out = super.toString();
		return out +" Radius: " + this.radius+", Area: "+ getArea();
	}
}
