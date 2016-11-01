import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> 
{
	@Override
	public int compare(Product o1, Product o2) 
	{
		//remember with floating-point values we need to substract and use if conditional statements
		double priceDiff = o1.getPrice() - o2.getPrice();
		
		if(priceDiff > 0)
			return 1;
		else if(priceDiff > 0)
			return -1;
		else
			return 0;
	}

}
