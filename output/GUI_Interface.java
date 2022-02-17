package output;

import javax.swing.JFrame;

// template for our puzzle GUI
public interface GUI_Interface {
	
	// method to create a GUI for our puzzle; needs to be JFrame with at least a taskPanel, a gridPanel, a solutionPanel and a checkPanel
	JFrame CreateGUIPuzzle(CreateTaskPanel taskPanel, CreateGridPanel gridPanel, CreateSolutionPanel solutionPanel, CreateCheckPanel checkPanel);
}
