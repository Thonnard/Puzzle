package input.keyboard;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

// this class is called when a keyboard JFrame is shown and makes sure the user can use the (real) keyboard to provide input
public class KeyboardListener implements KeyListener {

	// instance variables
	private String cheat = ""; // variable for cheat String
	private JLabel targetLabel; // for clicked label in puzzle grid
	private JFrame frameKeyboard; // for virtual keyboard
	private Color currentLabelColor; // to reset color of clicked label in puzzle grid
	private ArrayList<String> hints; // Arraylist to pass hints

	// constructor
	public KeyboardListener(JFrame frameKeyboard, JLabel targetLabel, Color currentLabelColor, ArrayList<String> hints) {
		this.frameKeyboard = frameKeyboard;
		this.targetLabel = targetLabel;
		this.setCurrentLabelColor(currentLabelColor);
		this.hints = hints;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			if(!hints.isEmpty() & hints.contains("A")) { // if hints ArrayList is not empty (= there are hints), so passed via class KeyboardHint, and if hints ArrayList contains the pressed key character
				targetLabel.setText("A");
				System.out.println("User input: " + "A");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) { // else: hints ArrayList is empty (no hints available) so passed via Keyboard class -> character always available
				targetLabel.setText("A");
				System.out.println("User input: " + "A");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_B) {
			if(!hints.isEmpty() & hints.contains("B")) {
				targetLabel.setText("B");
				System.out.println("User input: " + "B");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("B");
				System.out.println("User input: " + "B");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_C) {
			if(!hints.isEmpty() & hints.contains("C")) {
				targetLabel.setText("C");
				System.out.println("User input: " + "C");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("C");
				System.out.println("User input: " + "C");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}			
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			if(!hints.isEmpty() & hints.contains("D")) {
				targetLabel.setText("D");
				System.out.println("User input: " + "D");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("D");
				System.out.println("User input: " + "D");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_E) {
			if(!hints.isEmpty() & hints.contains("E")) {
				targetLabel.setText("E");
				System.out.println("User input: " + "E");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("E");
				System.out.println("User input: " + "E");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_F) {
			if(!hints.isEmpty() & hints.contains("F")) {
				targetLabel.setText("F");
				System.out.println("User input: " + "F");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("F");
				System.out.println("User input: " + "F");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_G) {
			if(!hints.isEmpty() & hints.contains("G")) {
				targetLabel.setText("G");
				System.out.println("User input: " + "G");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("G");
				System.out.println("User input: " + "G");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_H) {
			if(!hints.isEmpty() & hints.contains("H")) {
				targetLabel.setText("H");
				System.out.println("User input: " + "H");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("H");
				System.out.println("User input: " + "H");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_I) {
			if(!hints.isEmpty() & hints.contains("I")) {
				targetLabel.setText("I");
				System.out.println("User input: " + "I");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("I");
				System.out.println("User input: " + "I");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_J) {
			if(!hints.isEmpty() & hints.contains("J")) {
				targetLabel.setText("J");
				System.out.println("User input: " + "J");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("J");
				System.out.println("User input: " + "J");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_K) {
			if(!hints.isEmpty() & hints.contains("K")) {
				targetLabel.setText("K");
				System.out.println("User input: " + "K");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("K");
				System.out.println("User input: " + "K");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_L) {
			if(!hints.isEmpty() & hints.contains("L")) {
				targetLabel.setText("L");
				System.out.println("User input: " + "L");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("L");
				System.out.println("User input: " + "L");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_M) {
			if(!hints.isEmpty() & hints.contains("M")) {
				targetLabel.setText("M");
				System.out.println("User input: " + "M");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("M");
				System.out.println("User input: " + "M");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_N) {
			if(!hints.isEmpty() & hints.contains("N")) {
				targetLabel.setText("N");
				System.out.println("User input: " + "N");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("N");
				System.out.println("User input: " + "N");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_O) {
			if(!hints.isEmpty() & hints.contains("O")) {
				targetLabel.setText("O");
				System.out.println("User input: " + "O");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("O");
				System.out.println("User input: " + "O");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_P) {
			if(!hints.isEmpty() & hints.contains("P")) {
				targetLabel.setText("P");
				System.out.println("User input: " + "P");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("P");
				System.out.println("User input: " + "P");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			if(!hints.isEmpty() & hints.contains("Q")) {
				targetLabel.setText("Q");
				System.out.println("User input: " + "Q");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("Q");
				System.out.println("User input: " + "Q");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_R) {
			if(!hints.isEmpty() & hints.contains("R")) {
				targetLabel.setText("R");
				System.out.println("User input: " + "R");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("R");
				System.out.println("User input: " + "R");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			if(!hints.isEmpty() & hints.contains("S")) {
				targetLabel.setText("S");
				System.out.println("User input: " + "S");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("S");
				System.out.println("User input: " + "S");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_T) {
			if(!hints.isEmpty() & hints.contains("T")) {
				targetLabel.setText("T");
				System.out.println("User input: " + "T");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("T");
				System.out.println("User input: " + "T");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_U) {
			if(!hints.isEmpty() & hints.contains("U")) {
				targetLabel.setText("U");
				System.out.println("User input: " + "U");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("U");
				System.out.println("User input: " + "U");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_V) {
			if(!hints.isEmpty() & hints.contains("V")) {
				targetLabel.setText("V");
				System.out.println("User input: " + "V");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("V");
				System.out.println("User input: " + "V");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			if(!hints.isEmpty() & hints.contains("W")) {
				targetLabel.setText("W");
				System.out.println("User input: " + "W");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("W");
				System.out.println("User input: " + "W");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_X) {
			if(!hints.isEmpty() & hints.contains("X")) {
				targetLabel.setText("X");
				System.out.println("User input: " + "X");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("X");
				System.out.println("User input: " + "X");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_Y) {
			if(!hints.isEmpty() & hints.contains("Y")) {
				targetLabel.setText("Y");
				System.out.println("User input: " + "Y");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("Y");
				System.out.println("User input: " + "Y");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			if(!hints.isEmpty() & hints.contains("Z")) {
				targetLabel.setText("Z");
				System.out.println("User input: " + "Z");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			} else if (hints.isEmpty()) {
				targetLabel.setText("Z");
				System.out.println("User input: " + "Z");
				targetLabel.setBackground(currentLabelColor);
				frameKeyboard.dispose();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DELETE) {
			targetLabel.setText("");
			System.out.println("User input: " + "DEL");
			targetLabel.setBackground(currentLabelColor);
			frameKeyboard.dispose();
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			targetLabel.setBackground(currentLabelColor);
			frameKeyboard.dispose();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// do nothing		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// do nothing		
	}


	// getters and setters
	public String getCheat() {
		return cheat;
	}
	public void setCheat(String cheat) {
		this.cheat = cheat;
	}
	public JLabel getTargetLabel() {
		return targetLabel;
	}
	public void setTargetLabel(JLabel targetLabel) {
		this.targetLabel = targetLabel;
	}
	public JFrame getFrameKeyboard() {
		return frameKeyboard;
	}
	public void setFrameKeyboard(JFrame frameKeyboard) {
		this.frameKeyboard = frameKeyboard;
	}
	public Color getCurrentLabelColor() {
		return currentLabelColor;
	}
	public void setCurrentLabelColor(Color currentLabelColor) {
		this.currentLabelColor = currentLabelColor;
	}
}
