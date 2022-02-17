package puzzle;

import javax.swing.JLabel;
import output.CreateSolutionPanel;

// class that is called to check the solution
public class CheckSolution {
	
	// declare vars, encapsulation = private
	private String userSolution = "";
	private boolean correct = false;
	
	// constructor	
	public CheckSolution(String realSolution, CreateSolutionPanel solutionPane) {
				
		for(int i = 0; i < realSolution.length(); i++) {
			JLabel lblSolution = (JLabel) solutionPane.getSolutionPanel().getComponent(i); // get labels in solution panel
			userSolution = userSolution + lblSolution.getText();
		}
		
		// print user solution in console
		System.out.println("Solution user: " + userSolution);
		
		// set boolean correct
		if(realSolution.toUpperCase().equals(userSolution)) {
			correct = true;
		}
		
	}

	// getters and setters
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public String getUserSolution() {
		return userSolution;
	}
	public void setUserSolution(String userSolution) {
		this.userSolution = userSolution;
	}
}
