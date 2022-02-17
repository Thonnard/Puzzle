package input.keyboard;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


// this class is called in the virtual keyboard (cf. class KeyboardTemplate) and passes the virtual keyboard's key text to the label in the puzzle grid
public class ButtonListener implements ActionListener {

	// declaration instance variables 
	private JFrame frameKeyboard; // JFrame for keyboard
	private JLabel targetLabel; // label referring to the clicked label in the puzzle grid
	private Color currentLabelColor; // original color of the selected label

	// constructor
	public ButtonListener (JFrame frameKeyboard, JLabel targetLabel, Color currentLabelColor ) {
		this.frameKeyboard = frameKeyboard;
		this.targetLabel = targetLabel;
		this.currentLabelColor = currentLabelColor;

		// close keyboard when focus is lost and reset label to original color (this avoids opening multiple keyboards but still allows the grid to be clicked)
		this.frameKeyboard.addWindowFocusListener( new WindowFocusListener() {
			@Override
			public void windowLostFocus(WindowEvent e) {
				frameKeyboard.dispose();
				targetLabel.setBackground(currentLabelColor);
			}
			@Override
			public void windowGainedFocus(WindowEvent e) {
				// do nothing

			}
		});;


	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		// change text, reset label color
		if(((JButton)e.getSource()).getText().equals("CLEAR")) {		// for key "CLEAR"
			targetLabel.setText("");
			System.out.println("User input: CLEAR");
		} else {
			targetLabel.setText(((JButton)e.getSource()).getText());	// for all other keys
			System.out.println("User input: " + ((JButton)e.getSource()).getText());
		}

		// reset label color
		targetLabel.setBackground(currentLabelColor);
		// dispose keyboard
		frameKeyboard.dispose();
	}
}
