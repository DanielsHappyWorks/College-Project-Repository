/*
 * Version 0.1
 * -All variables declared 
 * -bacic methods added ie getters setters to string etc
 * 
 * Version 0.0 
 * -Most variables declared
 */
package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Task implements Serializable{
	private static final long serialVersionUID = -1212984281186811397L;
	//SimpleDateFormat myFormat= new SimpleDateFormat("d/MM/YY");

	static int count = 1000;
	
	private String name;
	private int id;
	private Person taskLeader;
	private ArrayList<Person> taskTeam;
	private Calendar startDate, endDate, completionDate;
	private CompletionStatus status;
	private boolean overdue;
	
	public Task(String name, Calendar startDate) {
		this.name = name;
		this.taskLeader = null;
		this.id = count++;
		this.taskTeam = null;
		this.startDate = startDate;
		this.endDate = Calendar.getInstance();
		this.completionDate = Calendar.getInstance();
		this.status = CompletionStatus.Ongoing;
		this.overdue = false;
	}
	
	public Task(String name, int id, Person taskLeader, ArrayList<Person> taskTeam, Calendar startDate,
			Calendar endDate, Calendar completionDate, CompletionStatus status, boolean overdue) {
		this.name = name;
		this.id = id;
		this.taskLeader = taskLeader;
		this.taskTeam = taskTeam;
		this.startDate = startDate;
		this.endDate = endDate;
		this.completionDate = completionDate;
		this.status = status;
		this.overdue = overdue;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person getTaskLeader() {
		return taskLeader;
	}
	public void setTaskLeader(Person taskLeader) {
		this.taskLeader = taskLeader;
	}
	public int getId() {
		return id;
	}
	public ArrayList<Person> getTaskTeam() {
		return taskTeam;
	}
	public void setTaskTeam(ArrayList<Person> taskTeam) {
		this.taskTeam = taskTeam;
	}
	public Calendar getStartDate() {
		return startDate;
	}
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	public Calendar getEndDate() {
		return endDate;
	}
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	public Calendar getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(Calendar completionDate) {
		this.completionDate = completionDate;
	}
	public CompletionStatus getStatus() {
		return status;
	}
	public void setStatus(CompletionStatus status) {
		this.status = status;
	}
	public boolean isOverdue() {
		return overdue;
	}
	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}

	@Override
	public String toString() {
		SimpleDateFormat myFormatter = new SimpleDateFormat("d MMM YY");
		String startD = myFormatter.format(startDate.getTime());
		String endD = myFormatter.format(endDate.getTime());
		String compD = myFormatter.format(completionDate.getTime());
		
		return "Task [name=" + name + ", id=" + id + ", taskLeader=" + taskLeader + ", taskTeam=" + taskTeam
				+ ", startDate=" + startD + ", endDate=" + endD + ", completionDate=" + compD
				+ ", status=" + status + ", overdue=" + overdue + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((completionDate == null) ? 0 : completionDate.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (overdue ? 1231 : 1237);
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((taskLeader == null) ? 0 : taskLeader.hashCode());
		result = prime * result + ((taskTeam == null) ? 0 : taskTeam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (completionDate == null) {
			if (other.completionDate != null)
				return false;
		} else if (!completionDate.equals(other.completionDate))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (overdue != other.overdue)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status != other.status)
			return false;
		if (taskLeader == null) {
			if (other.taskLeader != null)
				return false;
		} else if (!taskLeader.equals(other.taskLeader))
			return false;
		if (taskTeam == null) {
			if (other.taskTeam != null)
				return false;
		} else if (!taskTeam.equals(other.taskTeam))
			return false;
		return true;
	}
	public Task clone()
	{
		Task clone = new Task(this.name, this.id, this.taskLeader, this.taskTeam, this.startDate,
				this.endDate, this.completionDate, this.status, this.overdue);
		return clone;
	}

}
