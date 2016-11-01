package Solution;

/**
 * We use this interface whenever we want to do things like getAverage(), getLargest() - see MainApp for an example
 * @author Home
 *
 */
public interface IMeasurer
{
	//notice this method takes an object not a Vehicle - this allows us to use this interface for lots of different object types
	public double getValue(Object o);

}
