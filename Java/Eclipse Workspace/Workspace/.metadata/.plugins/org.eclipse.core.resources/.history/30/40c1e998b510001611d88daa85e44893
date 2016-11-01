package Controller;
import Model.IFilter;
import Model.Show;

public class ShowNameFilter implements  IFilter<Show>
{
	private String regex;
	
	public ShowNameFilter(String regex)
	{
		this.regex = regex;
	}

	@Override
	public boolean matches(Show obj) {
		String str = obj.getName();
		return str.matches(regex);
	}
}
