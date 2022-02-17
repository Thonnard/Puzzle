package input.puzzle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

// this class converts the grid from a list to a HashMap
public class CreateGridHashMap {

	// declaration instance variable (encapsulation: private)
	private Map<Integer, String> gridHashMap = new HashMap<Integer, String>();	

	// constructor method
	public CreateGridHashMap(List<String> getGrid, int getRows, int getColumns) {	
		int counter = 0;
		try {
			// for every line j in the grid
			for(int j = 0; j < getRows; j++) {

				// split string around every space
				String[] elements = getGrid.get(j).split(" ");

				// add split string to HashMap
				for(int i = 0; i < getColumns; i++) {
					this.gridHashMap.put(counter, elements[i]);
					counter++;
				}
			}

		} catch (ArrayIndexOutOfBoundsException iob) {
			System.out.println("Puzzle dimensions not equal to grid dimensions! Please check your puzzle file... " + iob);
			// show dialog box with information about error
			JOptionPane.showMessageDialog(null, "Puzzle dimensions not equal to grid dimensions! Please check your puzzle file and restart the program.", 
					"Error puzzle dimensions!",
					JOptionPane.WARNING_MESSAGE);
			System.exit(-1);
		}
	}


	// getters and setters
	public Map<Integer, String> getGridHashMap() {
		return gridHashMap;
	}
	public void setGridHashMap(Map<Integer, String> gridHashMap) {
		this.gridHashMap = gridHashMap;
	}
}

