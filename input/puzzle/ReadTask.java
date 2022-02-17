package input.puzzle;

import java.util.ArrayList;
import java.util.List;

// this class gets the task (across and down lines)
public class ReadTask {
	
	// declaration instance variables (encapsulation: private)
	private List<String> across = new ArrayList<String>();
	private List<String> down = new ArrayList<String>();
	private int startAcross; // start line Across
	private int endAcross; // final line Across
	private int startDown; // start line Down
	private int endDown; // final line Down
	
	
	// constructor method
	public ReadTask(ArrayList<String> task) {

		// set boundaries
		this.startAcross = task.indexOf("ACROSS")+1;
		this.endAcross = task.indexOf("DOWN");
		this.startDown = task.indexOf("DOWN")+1;
		this.endDown = task.size();

		// get across tasks and down tasks
		this.across = task.subList(this.startAcross, this.endAcross);
		this.down = task.subList(this.startDown, this.endDown);
	}
	

	// getters and setters
	public List<String> getAcross() {
		return across;
	}	
	public List<String> getDown() {
		return down;
	}
	public void setAcross(List<String> across) {
		this.across = across;
	}
	public void setDown(List<String> down) {
		this.down = down;
	}
	
}