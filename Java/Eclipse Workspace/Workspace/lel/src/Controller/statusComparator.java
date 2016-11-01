package Controller;

import java.util.Comparator;

import Model.Task;

public class statusComparator implements Comparator<Task>{

	@Override
	public int compare(Task o1, Task o2) {
		return o1.getStatus().getPriority()-o1.getStatus().getPriority();
	}

}
