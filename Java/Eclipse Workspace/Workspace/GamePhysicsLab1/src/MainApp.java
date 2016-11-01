import java.util.ArrayList;
import java.util.Collections;

public class MainApp {
	
	public static void main(String[] args){
		MainApp theApp = new MainApp();
		theApp.start();
	}

	public void start() {
		double t;
		double x;
		double y;
		double pOfTandHx;
		double pOfTx;
		double pOfTandHy;
		double pOfTy;
		
		//p(t)=(tSin(t),5Cos(t)+5)
		for(int i=0; i<=100;i++){
			t=(double)i/10;
			x=t*(Math.sin(t));
			y=5*(Math.cos(t))+5;
			
			System.out.println("Time t = "+t+" \t p(t) = ("+x+","+y+")");
			System.out.println("d(t,h) = ");
			System.out.println();
			
		}
		//d(t,h) = p(t+h) - p(t);
		pOfTandHx = t*(Math.sin(t));
		pOfTandHy = t*(Math.sin(t));
		pOfTx = 5*(Math.cos(t))+5;
		pOfTy = 5*(Math.cos(t))+5;
		System.out.println("d(3,1) = ");
		
		//av(t,h) = 1/h(p(t+h) p(t));
	}
}