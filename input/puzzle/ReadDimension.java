package input.puzzle;

import java.util.ArrayList;

// this class gets the dimensions of the puzzle
public class ReadDimension {

	// declaration instance variables (encapsulation: private)
	private int rows;
	private int columns;


	// constructor method
	public ReadDimension(ArrayList<String> task) {		
		
		// get the first line of the puzzle text file
		String firstLine = task.get(0);
		
		// split string around the space
		String[] splitStr = firstLine.split("\\s+");
		
		// get row and column value
		this.rows = Integer.valueOf(splitStr[0]);
		this.columns = Integer.valueOf(splitStr[1]);
	}

	// getters and setters
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
}

