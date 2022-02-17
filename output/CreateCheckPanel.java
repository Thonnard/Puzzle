package output;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import java.lang.Character.*;

import puzzle.CheckSolution;

// this is a class to create the JPanel that contains the "Check" button in the main puzzle frame
public class CreateCheckPanel {	
	
	// declaration instance variables (encapsulation: private)
	private JPanel checkPanel;
	private String realSolution; // to pass actual solution of puzzle
	
	
	// constructor
	public CreateCheckPanel (String realSolution, CreateSolutionPanel solutionPane) {
		this.setRealSolution(realSolution);		
		
		// create JPanel
		JPanel checkPanel = new JPanel();
		
		// create button
		JButton btn = new JButton("Check");
		
		// check solution
		btn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// check if solution is correct
				CheckSolution test = new CheckSolution(realSolution, solutionPane);
				
				// messages
				String messageCorrect = "Congratulations! \n \nYou have entered \nthe correct solution:"+ "\n\n" + "\"" + realSolution + "\"";
				String messageIncorrect;				
				if(test.getUserSolution().length()==0) {
					messageIncorrect = "Oops! \n \nYou have not entered \na solution";
				} else {
					messageIncorrect = "Oops! \n \nYou have entered \nan incorrect solution:"+ "\n\n" + "\"" + test.getUserSolution() + "\"";
				}
				
				// output depending on result
				if(test.isCorrect()) {
					System.out.println("Correct solution!");					
					ImageIcon icon = new ImageIcon("src/images/Victory.jpg");
					Image image = icon.getImage(); // transform it 
					Image newimg = image.getScaledInstance(240, 120,  java.awt.Image.SCALE_SMOOTH); 
					ImageIcon iconFinale = new ImageIcon(newimg);  // transform it back
					JOptionPane.showMessageDialog(null, messageCorrect, 
							"You won!",
							JOptionPane.INFORMATION_MESSAGE, iconFinale);
					System.out.println("Program finished.");
					System.exit(1);
				} else {
					System.out.println("Incorrect solution!");					
					ImageIcon icon = new ImageIcon("src/images/incorrect.jpg");
					Image image = icon.getImage(); // transform it 
					Image newimg = image.getScaledInstance(240, 120,  java.awt.Image.SCALE_SMOOTH); 
					ImageIcon iconFinale = new ImageIcon(newimg);  // transform it back
					JOptionPane.showMessageDialog(null, messageIncorrect, 
							"Wrong answer!",
							JOptionPane.INFORMATION_MESSAGE, iconFinale);
				}

			}
		});
	

		// add button to panel
		checkPanel.add(btn);

        // pass panel to object
        this.setCheckPanel(checkPanel);		
	}

	
	// getters and setters
	public JPanel getCheckPanel() {
		return checkPanel;
	}
	public void setCheckPanel(JPanel checkPanel) {
		this.checkPanel = checkPanel;
	}
	public String getRealSolution() {
		return realSolution;
	}
	public void setRealSolution(String realSolution) {
		this.realSolution = realSolution;
	}


}
