public class Square extends Primitive
{
	private int width, height;
	public Square(int x, int y, int width, int height)
	{
		super(x,y);
		this.width = width;
		this.height = height;
		
		
	}
	public int getWidth() {return this.width;}
	public int getHeight() {return this.height;}
	
	public double getArea()
	{
		return this.width*this.height;
	}
	
	public String toString()
	{
		return super.toString() + ", Width: "+this.width+ ", Height: "+this.height+", Area: "+ getArea();
	}
}
