package Controller;
import Model.IFilter;
import Model.Show;

public class ShowPriceRangeFilter implements IFilter<Show>{
	private double hi;
	private double lo;
	public ShowPriceRangeFilter(double lo, double hi){
		this.lo = lo;
		this.hi = hi;
	}
	@Override
	public boolean matches(Show s) {
		double price = s.getPrice();
		return ((price >= lo)&&(price <= hi));
	}
}
