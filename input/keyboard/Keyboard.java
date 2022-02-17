package input.keyboard;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

// this class extends the keyboard template abstract class and is used for all labels in the grid, except for the hint labels (blue)
public class Keyboard extends KeyboardTemplate {

	// constructor
	public Keyboard(String keyboardLayout, JLabel targetLabel, Color currentLabelColor) {
		super(keyboardLayout, targetLabel, currentLabelColor);

		// button counter
		int buttonCounter = 0;

		// keyboard
		for (int row = 0; row < getCurrentKeyboardLayout().length; ++row) {

			// panels (rows)
			setpRow(new JPanel(new GridBagLayout()));
			getcRow().gridy = row;

			// keys in columns
			for (int col = 0; col < getCurrentKeyboardLayout()[row].length; ++col) {
				// add button to panel
				getpRow().add(getBt()[buttonCounter], cButton); 

				buttonCounter++;
			}

			// add rows to keyboard
			this.getKeyboard().add(getpRow(), cRow);
		}
		
		// keyboard listener
		ArrayList<String> hints = new ArrayList<String>(); // empty hint ArrayList to pass to the KeyboardListener: no hints available so all (real keyboard) keys will be accessible
		this.getFrameKeyboard().addKeyListener(new KeyboardListener(getFrameKeyboard(), targetLabel, currentLabelColor, hints));
	}

}
