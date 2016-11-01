public class Primitive 
{
	private int x, y;
	
	public Primitive (int x, int y)
	{
		this.x = x; this.y = y;
	}
	
	public int getX(){return this.x;}
	public int getY(){return this.y;}
	public double getArea()
	{
		return 0;
	}
	
	public String toString()
	{
		return "X: " + this.x + " , "  + "Y: " + this.y;
	}
	
}
