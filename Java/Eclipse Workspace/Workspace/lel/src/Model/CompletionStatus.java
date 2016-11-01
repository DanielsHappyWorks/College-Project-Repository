/*
 * Version 0.0
 * -Declared all potential statuses of a task
 */
package Model;
public enum CompletionStatus {
	Completed(4),
	Ongoing(3),
	Paused(2),
	Cancelled(1);
	
	private int priority;
	
	public int getPriority(){
		return this.priority;
	}
	
	private CompletionStatus(int priority){
		this.priority =priority;
	}
}
