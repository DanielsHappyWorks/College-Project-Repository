public class StringRegexFilter implements IFilter<String>
{
	private String regex;
	
	public StringRegexFilter(String regex)
	{
		this.regex = regex;
	}
	
	@Override
	public boolean matches(String str) 
	{
		return str.matches(regex);
	}
}
