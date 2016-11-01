
public class ProductTypeFilter implements IFilter 
{
	private ProductType targetType;

	public ProductTypeFilter(ProductType targetType)
	{
		this.targetType = targetType;
	}
	
	@Override
	public boolean matches(Object o) 
	{
		//ensure the object passed in is type Product
		if(o instanceof Product)
		{
			Product p = (Product)o;
			
			//is it a match for the type specified in the constructor?
			if(p.getProductType() == targetType)
				return true;
			else
				return false;
		}
		
		//wasnt a product so return false
		return false;
	}

}
