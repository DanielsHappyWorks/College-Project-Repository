
public class MainApp {

	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		theApp.start();
		}
	public void start()
	{
		int x = 0;
		int y = ~x;
		//System.out.println("Y: "+y);
		
		x = 1;
		y = x<<2;
		//System.out.println("Y: "+y);
		
		x = 32;
		y = x>>1;
		//System.out.println("Y: "+y);
		
		x = 5;
		y = 3;
		int z = x & y; 
		//System.out.println("Z: "+z);
		
		x = 5;
		y = 3;
		z = x | y; 
		//System.out.println("Z: "+z);
		
		x = 5;
		y = 3;
		z = x ^ y; 
		//System.out.println("Z: "+z);
		
		int value = 11; //1011
		int position =3;
		int mask;
		mask = 1 << position;
		//System.out.println(mask); //1000 in binary
		
		int result = value & mask; //1000 in bin
		if(result > 0)
			System.out.println("1 present in value at pos");
		else
			System.out.println("1 not present in value at pos");
	}

}
/*
 * and
 1000
 1011
 =1000
 
 or
 1000
 1011
 =1011
 
 xor
  1000
 1011
 =0011
 */


/*int x = Integer.MIN_VALUE;
System.out.println("X: " + x);
int y = -1;
int sum = x + y;
System.out.println("Sum: " + sum);*/