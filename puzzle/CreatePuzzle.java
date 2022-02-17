package puzzle;

import javax.swing.JFrame;

import input.puzzle.CreateGridHashMap;
import input.puzzle.ReadDimension;
import input.puzzle.ReadGrid;
import input.puzzle.ReadPropertiesFile;
import input.puzzle.ReadPuzzleFile;
import input.puzzle.ReadTask;
import input.puzzle.SelectFile;
import output.*;

// this class creates all the necessary objects and puts everything together
public class CreatePuzzle {
	
	// instance variable: JFrame for puzzle
	private JFrame puzzle;

	// constructor
	public CreatePuzzle(String keyboardLayout, String level, String crack) {

		// input
		// create new dialog box to load propertiesFile
		SelectFile selectPuzzle = new SelectFile();
		// read the properties file
		ReadPropertiesFile propertiesFileOne = new ReadPropertiesFile(selectPuzzle.getPropertiesFile());
		// read the puzzle file (should be in same directory as propertiesFile)
		ReadPuzzleFile puzzleOne = new ReadPuzzleFile(selectPuzzle.getDirectory()+"/"+propertiesFileOne.getFilenameTask());
		// get the dimension of our new game
		ReadDimension dimensionPuzzleOne = new ReadDimension(puzzleOne.getTask());
		// get across and down tasks
		ReadTask taskPuzzleOne = new ReadTask(puzzleOne.getTask());
		// get grid
		ReadGrid gridPuzzleOne = new ReadGrid(puzzleOne.getTask());
		// convert grid to HashMap
		CreateGridHashMap gridHashMap = new CreateGridHashMap(gridPuzzleOne.getGrid(), dimensionPuzzleOne.getRows(), dimensionPuzzleOne.getColumns());

		// GUI
		// create new taskPanel (clues)
		CreateTaskPanel taskPanel = new CreateTaskPanel(taskPuzzleOne.getAcross(), taskPuzzleOne.getDown());
		// create new gridPanel
		CreateGridPanel gridPanel = new CreateGridPanel(gridHashMap.getGridHashMap(), dimensionPuzzleOne.getRows(), dimensionPuzzleOne.getColumns(), keyboardLayout, level);
		// create new solutionPanel
		CreateSolutionPanel solutionPanel = new CreateSolutionPanel(propertiesFileOne.getSolution(), keyboardLayout);
		// create new checkPanel
		CreateCheckPanel checkPanel = new CreateCheckPanel(propertiesFileOne.getSolution(), solutionPanel);
		// create puzzle gui
		JFrame guiPuzzle = new CreateGUI(propertiesFileOne.getSolution(), crack).CreateGUIPuzzle(taskPanel, gridPanel, solutionPanel, checkPanel);
		setPuzzle(guiPuzzle);
	}

	// send message to console when starting
	public void launch() {
		System.out.println("Starting!");
	}

	// getters and setters
	public JFrame getPuzzle() {
		return puzzle;
	}
	public void setPuzzle(JFrame puzzle) {
		this.puzzle = puzzle;
	}

}
