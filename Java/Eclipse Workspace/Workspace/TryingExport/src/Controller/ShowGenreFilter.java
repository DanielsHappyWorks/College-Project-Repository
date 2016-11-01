package Controller;
import Model.IFilter;
import Model.Show;

public class ShowGenreFilter implements  IFilter<Show>
{
	private String regex;
	
	public ShowGenreFilter(String regex)
	{
		this.regex = regex;
	}

	@Override
	public boolean matches(Show obj) {
		String str = obj.getGenre();
		return str.matches(regex);
	}
}
