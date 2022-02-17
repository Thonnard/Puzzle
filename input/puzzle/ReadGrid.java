package input.puzzle;

import java.util.ArrayList;
import java.util.List;

// this class reads the grid to an array list
public class ReadGrid {

	// declaration instance variables (encapsulation: private)
	private List<String> grid = new ArrayList<String>();
	private int startGrid; // start line of grid
	private int endGrid; // final line of grid

	// constructor method
	public ReadGrid(ArrayList<String> task) {

		// set boundaries
		this.startGrid = 1;
		this.endGrid = task.indexOf("ACROSS");

		// get grid
		this.grid = task.subList(this.startGrid, this.endGrid);			
	}

	// getters and setters
	public List<String> getGrid() {
		return grid;
	}
	public void setGrid(List<String> grid) {
		this.grid = grid;
	}	
}