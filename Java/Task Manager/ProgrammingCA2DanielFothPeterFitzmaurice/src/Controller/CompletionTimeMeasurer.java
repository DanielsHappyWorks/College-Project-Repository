package Controller;

import Model.Task;

public class CompletionTimeMeasurer implements IMeasurer{
	@Override
	public double getValue(Object obj) {
		Task t =(Task)obj;
		double CompletionTime = 24*60*60*1000*(t.getStartDate().getTimeInMillis()-t.getCompletionDate().getTimeInMillis());
		return CompletionTime;
	}

}
