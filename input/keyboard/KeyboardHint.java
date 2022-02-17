package input.keyboard;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

// this class extends the keyboard template abstract class and is used for all hint labels in the grid
public class KeyboardHint extends KeyboardTemplate {

	// instance variables
	private String hint;  // to pass the hint character
	private String level; // for level (difficulty) of puzzle
	private Random random_element;	// to pass set.seed to make sure the randomization is always the same
	private ArrayList<String> keyboardHint = new ArrayList<String>(); 	// list for hint + random characters

	// constructor
	public KeyboardHint(String keyboardLayout, JLabel targetLabel, Color currentLabelColor,  String hint, String level, Random random_element) {
		super(keyboardLayout, targetLabel, currentLabelColor);
		this.hint = hint;
		this.level = level;
		this.random_element = random_element;

		// button counter
		int buttonCounter = 0;

		// call RandomHints method to get the Hint array (cf. below)
		ArrayList<String> hintArray = randomHints();;

		// keyboard
		for (int row = 0; row < getCurrentKeyboardLayout().length; ++row) {
			// panels (rows)
			setpRow(new JPanel(new GridBagLayout()));
			getcRow().gridy = row;

			// keys in columns
			for (int col = 0; col < getCurrentKeyboardLayout()[row].length; ++col) {

				// change properties (colors of keys
				if (getBt()[buttonCounter].getText().equals("CLEAR")) {
					getBt()[buttonCounter].setBackground(Color.LIGHT_GRAY);
				} else if (hintArray.contains(getBt()[buttonCounter].getText())) { // hint keys
					getBt()[buttonCounter].setBackground(new Color(136,205,255));
					getBt()[buttonCounter].setForeground(Color.BLACK);
				} else { // rest
					getBt()[buttonCounter].setForeground(Color.GRAY);
					getBt()[buttonCounter].setBackground(new Color(247,247,247));
					getBt()[buttonCounter].setEnabled(false);
				}	

				// add button to panel
				getpRow().add(getBt()[buttonCounter], cButton); 

				buttonCounter++;
			}

			// add rows to keyboard
			this.getKeyboard().add(getpRow(), cRow);			
		}
		
		// keyboard listener
		this.getFrameKeyboard().addKeyListener(new KeyboardListener(getFrameKeyboard(), targetLabel, currentLabelColor, hintArray));
	}

	// getters and setters
	public String getLevel() {
		return level;
	}
	public String getHint() {
		return hint;
	}


	// method to create random hints array
	private ArrayList<String> randomHints() {

		// create list for hints + random characters
		ArrayList<String> keyboardMinusHint = new ArrayList<String>(); 
		int counter = 0;
		for (int row = 0; row < getCurrentKeyboardLayout().length; ++row) { 
			for (int col = 0; col < getCurrentKeyboardLayout()[row].length; ++col) {				
				keyboardMinusHint.add(counter,getCurrentKeyboardLayout()[row][col]);
				counter++;
			}				
		}
		// remove hint (total = 25)
		keyboardMinusHint.remove(getHint());
		// remove CLEAR (total = 24) so it's not selected as random hint
		keyboardMinusHint.remove("CLEAR");
		// add hint
		keyboardHint.add(0, getHint());
		// set level of difficulty
		int levelDifficulty = 4; // standard: 4 random characters (level = "NORMAL" or any other string except for "EASY" or "HARD")
		if(getLevel().equals("EASY")) {
			levelDifficulty = 1;
		} else if (getLevel().equals("HARD")) {
			levelDifficulty = 9;
		}
		// random generator
		for (int i = 1; i <= levelDifficulty; i ++) {
			int index = random_element.nextInt(keyboardMinusHint.size());
			keyboardHint.add(i,keyboardMinusHint.get(index));
			keyboardMinusHint.remove(keyboardMinusHint.get(index)); // remove character that was chosen earlier in the for loop by random function to avoid equal characters
		}
		// add "CLEAR" again so input can be removed
		keyboardHint.add(levelDifficulty+1,"CLEAR");
		// return hint array
		return(keyboardHint);				
	}
}
