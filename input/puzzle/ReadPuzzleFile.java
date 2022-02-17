package input.puzzle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

// this class reads the puzzle file (completely)
public class ReadPuzzleFile {
	
	//private String task;
	private ArrayList<String> task = new ArrayList<String>();

	// constructor method
	public ReadPuzzleFile(String filenameTask) {
		
		// read file	
		try (BufferedReader br = new BufferedReader(new FileReader(filenameTask));) {
			String s;
			
			try {
				while((s=br.readLine())!=null) {
				    task.add(s); 
				}	
				
				// test whether the puzzle file is empty or in wrong format (needs at least 7 lines: 1 line for dimension, 2 lines for grid, 2 lines for across, 2 lines for down) 
				// doens't protect 100%...
				if(task.isEmpty() || task.size() < 7) {
					System.out.println("Puzzle file is empty or not in the right format!");
					// show dialog box
					JOptionPane.showMessageDialog(null, "Puzzle file seems to be empty or is in the wrong format.\n"
							+ "Please provide a puzzle file in this format (example):\n"
							+ "\n"
							+ "3 3\n"
							+ "O O O \n" 
							+ "O X S \n" 
							+ "O X H(C) \n"
							+ "ACROSS\n"
							+ "...\n"
							+ "DOWN\n"
							+ "...", 
							"Puzzle file not found!",
						    JOptionPane.WARNING_MESSAGE);
					System.exit(-1); // unsuccessful termination with exception
				}
				
			} catch (IOException io) {
				System.out.println("An IO exception occurred: " + io);
			} 			
		} catch (FileNotFoundException fnf) {
			System.out.println("File not found: " + fnf);
			System.out.println("Please make sure your puzzle file is located in the same directory as your propertiesFile!");
			// show dialog box if puzzle file is not found
			JOptionPane.showMessageDialog(null, "Please make sure your puzzle text file is in the same directory as your propertiesFile before you restart the program.", 
					"Puzzle file not found!",
				    JOptionPane.WARNING_MESSAGE);
			System.exit(-1); // unsuccessful termination with exception
		} catch (IOException io) {
			System.out.println("An IO exception occurred: " + io);
		} finally {
			System.out.println("Puzzle successfully loaded.");
		}
		
	
	}
	
	// getters and setters
	public ArrayList<String> getTask() {
		return task;
	}
	public void setTask(ArrayList<String> task) {
		this.task = task;
	}

}





