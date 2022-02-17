package puzzle;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

// this is our program main class containing the main method
public class Program {

	// settings
	private final static String keyboardLayout = "AZERTY"; // options: AZERTY or QWERTY; anythings else will lead to AZERTY
	private final static String level = "NORMAL"; // options: EASY, NORMAL or HARD; anything else will lead to NORMAL
	private final static String crack = "JAVAFTW"; // if cheat mode is on, you can use this string to crack the puzzle


	// main method
	public static void main(String[] args){

		// startup message to console
		System.out.println("Program initiated.");

		// startup dialog message
		String startMessage = "Hello there! Welcome to PuzzleMania!\n\n" + "Please select a propertiesFile to start your puzzle.\n\n" + 
				"Make sure your puzzle file is located in\nthe same directory as your propertiesFile!\n\n" + 
				"Press OK to get started!";

		// get icon
		ImageIcon icon = new ImageIcon("src/images/welcome.jpg"); // still runs if jpg is not found (exception is caught)
		Image image = icon.getImage(); // transform 
		Image newimg = image.getScaledInstance(260, 135,  java.awt.Image.SCALE_SMOOTH); // dimensions
		ImageIcon iconFinale = new ImageIcon(newimg);  // transform it back

		// dialog
		JOptionPane.showMessageDialog(null, startMessage, 
				"PuzzleMania!",
				JOptionPane.INFORMATION_MESSAGE, iconFinale);

		// start puzzle
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){	

				// start new puzzle
				CreatePuzzle newPuzzle = new CreatePuzzle(keyboardLayout, level, crack);
				newPuzzle.launch();

			}
		});
		
	}


}
