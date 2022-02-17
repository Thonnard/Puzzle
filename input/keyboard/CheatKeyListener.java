package input.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

import input.puzzle.MixSolution;

// this class is called by the main puzzle JFrame and provides the option to turn on/off cheat mode and enter some cheat codes
public class CheatKeyListener implements KeyListener {

	// instance variables
	private String cheat = "";
	private boolean cheatMode = false;
	private String solution;
	private String crack;


	// constructor
	public CheatKeyListener(String solution, String crack) {
		this.solution = solution;
		this.crack = crack;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			setCheat(getCheat()+"A");
		}
		if (e.getKeyCode() == KeyEvent.VK_B) {
			setCheat(getCheat()+"B");
		}
		if (e.getKeyCode() == KeyEvent.VK_C) {
			setCheat(getCheat()+"C");
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			setCheat(getCheat()+"D");
		}
		if (e.getKeyCode() == KeyEvent.VK_E) {
			setCheat(getCheat()+"E");
		}
		if (e.getKeyCode() == KeyEvent.VK_F) {
			setCheat(getCheat()+"F");
		}
		if (e.getKeyCode() == KeyEvent.VK_G) {
			setCheat(getCheat()+"G");
		}
		if (e.getKeyCode() == KeyEvent.VK_H) {
			setCheat(getCheat()+"H");
		}
		if (e.getKeyCode() == KeyEvent.VK_I) {
			setCheat(getCheat()+"I");
		}
		if (e.getKeyCode() == KeyEvent.VK_J) {
			setCheat(getCheat()+"J");
		}
		if (e.getKeyCode() == KeyEvent.VK_K) {
			setCheat(getCheat()+"K");
		}
		if (e.getKeyCode() == KeyEvent.VK_L) {
			setCheat(getCheat()+"L");
		}
		if (e.getKeyCode() == KeyEvent.VK_M) {
			setCheat(getCheat()+"M");
		}
		if (e.getKeyCode() == KeyEvent.VK_N) {
			setCheat(getCheat()+"N");
		}
		if (e.getKeyCode() == KeyEvent.VK_O) {
			setCheat(getCheat()+"O");
		}
		if (e.getKeyCode() == KeyEvent.VK_P) {
			setCheat(getCheat()+"P");
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			setCheat(getCheat()+"Q");
		}
		if (e.getKeyCode() == KeyEvent.VK_R) {
			setCheat(getCheat()+"R");
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			setCheat(getCheat()+"S");
		}
		if (e.getKeyCode() == KeyEvent.VK_T) {
			setCheat(getCheat()+"T");
		}
		if (e.getKeyCode() == KeyEvent.VK_U) {
			setCheat(getCheat()+"U");
		}
		if (e.getKeyCode() == KeyEvent.VK_V) {
			setCheat(getCheat()+"V");
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			setCheat(getCheat()+"W");
		}
		if (e.getKeyCode() == KeyEvent.VK_X) {
			setCheat(getCheat()+"X");
		}
		if (e.getKeyCode() == KeyEvent.VK_Y) {
			setCheat(getCheat()+"Y");
		}
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			setCheat(getCheat()+"Z");
		}

		// cheat mode on
		if(getCheat().contains("CHEATSON")) {
			setCheatMode(true);
			setCheat(""); // reset
			System.out.println("Cheat mode unlocked! ");
		}

		// cheat mode off
		if(getCheat().contains("CHEATSOFF")) {
			setCheatMode(false);
			setCheat(""); // reset
			System.out.println("Cheat mode off! ");
		}

		// puzzle cracked
		if(isCheatMode() & getCheat().contains(getCrack())) {
			System.out.println("Puzzle unlocked!\nExiting program.");
			JOptionPane.showMessageDialog(null, "You have cracked the puzzle cheater!\nSolution: " + getSolution(), 
					"Magic!",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0); // puzzle cracked, exit program
		}

		// show first character
		if(isCheatMode() & getCheat().contains("FIRST")) {
			System.out.println("First character revealed!");
			JOptionPane.showMessageDialog(null, "First character of the solution: " + getSolution().charAt(0), 
					"Magic!",
					JOptionPane.INFORMATION_MESSAGE);
			setCheat(""); // reset
		}

		// show last character
		if(isCheatMode() & getCheat().contains("LAST")) {
			System.out.println("Last character revealed!");
			JOptionPane.showMessageDialog(null, "Last character of the solution: " + getSolution().substring(getSolution().length() - 1), 
					"Magic!",
					JOptionPane.INFORMATION_MESSAGE);
			setCheat(""); // reset
		}

		// show all characters in random order
		if(isCheatMode() & getCheat().contains("ALL")) {
			MixSolution s = new MixSolution(); // create MixSolution object (cf. class MixSolution) to mix characters of solution
			System.out.println("All characters revealed!");
			JOptionPane.showMessageDialog(null, "All characters of solution:\n" + s.mix(getSolution()), 
					"Magic!",
					JOptionPane.INFORMATION_MESSAGE);
			setCheat(""); // reset
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
	public boolean isCheatMode() {
		return cheatMode;
	}
	public void setCheatMode(boolean cheatMode) {
		this.cheatMode = cheatMode;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getCrack() {
		return crack;
	}
	public void setCrack(String crack) {
		this.crack = crack;
	}

}
