package input.keyboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// this abstract class provides the template for all virtual keyboard
public abstract class KeyboardTemplate {

	// instance variables
	// frames, panels, constraints
	private JFrame frameKeyboard = new JFrame("Enter a character");
	private final JPanel keyboard = new JPanel();
	private JPanel pRow;
	protected GridBagConstraints cRow = new GridBagConstraints(), cButton = new GridBagConstraints();
	// qwerty keyboard
	private final String[][] keyQwerty = {
			{"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"},
			{"A", "S", "D", "F", "G", "H", "J", "K", "L"},
			{"Z", "X", "C", "V", "B", "N", "M", "CLEAR"}
	};
	// azerty keyboard
	private final String[][] keyAzerty = {
			{"A", "Z", "E", "R", "T", "Y", "U", "I", "O", "P"},
			{"Q", "S", "D", "F", "G", "H", "J", "K", "L", "M"},
			{"W", "X", "C", "V", "B", "N", "CLEAR"}
	};
	// variable for current keyboard layout
	private final String[][] currentKeyboardLayout;
	// standard buttonSize
	private static final Dimension buttonSize = new Dimension(85,5);
	// font for buttons
	private final static Font myFont = new Font("Helvetica", Font.BOLD, 14);
	// variables location keyboard frame
	private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private final Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
	private final Point newLocation;  
	// total number of buttons
	private int totalButtons = 0;
	// button
	private JButton[] bt;


	// constructor
	public KeyboardTemplate(String keyboardLayout, JLabel targetLabel, Color currentLabelColor) {

		// set azerty/qwerty layout of keyboard
		if(keyboardLayout.equals("QWERTY")) {
			this.currentKeyboardLayout = this.keyQwerty;
		} else  {
			this.currentKeyboardLayout = this.keyAzerty; // set standard to azerty
		}

		// set gridbaglayout for keyboard
		this.keyboard.setLayout(new GridBagLayout());

		// gridbagconstraint settings
		this.cRow.anchor = GridBagConstraints.SOUTH;
		this.cButton.ipady = 21;
		this.cButton.ipadx = 7;
		this.cButton.insets = new Insets(5,10,5,10);

		// set total number of buttons
		for (int row = 0; row < this.currentKeyboardLayout.length; row++) {
			this.totalButtons = this.totalButtons + this.currentKeyboardLayout[row].length;
		}	

		// buttons
		bt = new RoundButton[this.totalButtons];
		//button counter		
		int buttonCount = 0;
		// set button properties
		for (int row = 0; row < getCurrentKeyboardLayout().length; ++row) {
			for (int col = 0; col < getCurrentKeyboardLayout()[row].length; ++col) {
				// round buttons, set text
				bt[buttonCount] = new RoundButton(getCurrentKeyboardLayout()[row][col]);
				// add button listener
				bt[buttonCount].addActionListener(new ButtonListener(getFrameKeyboard(), targetLabel, currentLabelColor));				
				// set standard colors
				if (bt[buttonCount].getText().equals("CLEAR")) {
					bt[buttonCount].setBackground(Color.LIGHT_GRAY);
				} else {
					bt[buttonCount].setBackground(Color.WHITE);
				}
				bt[buttonCount].setForeground(Color.BLACK);
				// set font buttons
				bt[buttonCount].setFont(getMyFont());
				// set button size
				bt[buttonCount].setPreferredSize(getButtonSize());
				// increment counter
				buttonCount++;
			}
		}

		// set location keyboard (on top of puzzle but a bit to the right - partly based on keyboard layout)
		this.newLocation = new Point(middle.x - getCurrentKeyboardLayout()[0].length*getButtonSize().width/2, middle.y);
		this.frameKeyboard.setLocation(getNewLocation());

		// set keyboard to not resizable
		this.frameKeyboard.setResizable(false);

		// add keyboard panel to frame
		this.frameKeyboard.add(getKeyboard()); 

		// set frame icon
		try {
			this.frameKeyboard.setIconImage(ImageIO.read(new File("src/images/Jigsaw-Puzzle-PNG-Picture.png")));
		} catch (IOException ioe) {
			System.out.println("Icon image file not found! " + ioe);
		}

		// default actions when closing frame
		this.frameKeyboard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// send  message to console when closing keyboard frame and reset label color
		this.frameKeyboard.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				// reset label background
				targetLabel.setBackground(currentLabelColor);
				// feedback to console
				System.out.println("Keyboard closed.");
			}
		});


		// add key listener so user can provide input via (real) keyboard instead of mouse
		//this.frameKeyboard.addKeyListener(new KeyboardListener(getFrameKeyboard(), targetLabel, currentLabelColor));
	}



	// getters and setters
	public JFrame getFrameKeyboard() {
		return frameKeyboard;
	}
	public void setFrameKeyboard(JFrame frameKeyboard) {
		this.frameKeyboard = frameKeyboard;
	}
	public String[][] getCurrentKeyboardLayout() {
		return currentKeyboardLayout;
	}	
	public JPanel getKeyboard() {
		return keyboard;
	}
	public Dimension getButtonSize() {
		return buttonSize;
	}
	public JPanel getpRow() {
		return pRow;
	}
	public void setpRow(JPanel pRow) {
		this.pRow = pRow;
	}
	public Font getMyFont() {
		return myFont;
	}
	public GridBagConstraints getcRow() {
		return cRow;
	}
	public void setcRow(GridBagConstraints cRow) {
		this.cRow = cRow;
	}
	public GridBagConstraints getcButton() {
		return cButton;
	}
	public void setcButton(GridBagConstraints cButton) {
		this.cButton = cButton;
	}
	public Point getNewLocation() {
		return newLocation;
	}
	public int getTotalButtons() {
		return totalButtons;
	}
	public JButton[] getBt() {
		return bt;
	}


	// method to launch keyboard
	public void launch() {
		frameKeyboard.pack();
		frameKeyboard.setVisible(true);
	}

}
