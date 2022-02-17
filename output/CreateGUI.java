package output;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import input.keyboard.CheatKeyListener;

// this class implements the GUI_interface interface class and combines all puzzle components in one JFrame
public class CreateGUI implements GUI_Interface {	

	// instance variables
	private JFrame frame;
	private CreateTaskPanel taskPanel;
	private CreateGridPanel gridPanel;
	private CreateSolutionPanel solutionPanel;
	private CreateCheckPanel checkPanel;
	private String solution;
	private String crack;


	// constructor
	public CreateGUI(String solution, String crack) {
		this.solution = solution;
		this.crack = crack;
		
		// JFrame for our puzzle
		frame = new JFrame("PuzzleMania");

	}

	// overriding CreatGUIPuzzle from the GUI_Interface
	// this method combines the 4 JPanels (task, grid, solution) into one frame
	@Override
	public JFrame CreateGUIPuzzle(CreateTaskPanel taskPanel, CreateGridPanel gridPanel, CreateSolutionPanel solutionPanel, 
			CreateCheckPanel checkPanel) {
		this.taskPanel = taskPanel;
		this.gridPanel = gridPanel;
		this.solutionPanel = solutionPanel;
		this.checkPanel = checkPanel;		

		// main panel
		JPanel mainPanel = new JPanel();

		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// padding of panels
		c.insets = new Insets(5,5,5,5); // spacing top, spacing left, spacing bottom, spacing right

		// add subpanels to main panel and main panel to frame
		// TaskPanel
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		mainPanel.add(taskPanel.getTaskPanel(), c);
		// gridPanel
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 4;
		c.gridheight = 1;
		mainPanel.add(gridPanel.getGridPanel(), c);
		// solutionPanel
		c.fill = GridBagConstraints.NONE;
		c.gridx = 2;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		mainPanel.add(solutionPanel.getSolutionPanel(), c);
		// checkPanel
		c.fill = GridBagConstraints.NONE;
		c.gridx = 4;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		mainPanel.add(checkPanel.getCheckPanel(), c);


		// add mainPanel to scrollPane and scroll to frame
		JScrollPane scrollBar = new JScrollPane(mainPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBar.getVerticalScrollBar().setUnitIncrement(16); 
		frame.add(scrollBar);
				
		// set DefaultLookAndFeelDecorated so icon shows in linux (ugly)
		//JFrame.setDefaultLookAndFeelDecorated(true);

		// set frame size options
		// get screen resolution
		Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize(); 
		// get Frame dimensions
		int frameWidth = taskPanel.getTaskPanel().getMinimumSize().width + gridPanel.getGridPanel().getMinimumSize().width;
		int frameHeight = gridPanel.getGridPanel().getMinimumSize().height+150;
		
		// set resizable to true (standard)
		frame.setResizable(true);

		// check if window size is not bigger than screen resolution, otherwise adapt
		if (frameWidth >= screenResolution.getWidth() | frameHeight >= screenResolution.getHeight()) { // frame is bigger than screen
			frame.setPreferredSize(new Dimension((int) (screenResolution.getWidth()-200),(int) (screenResolution.getHeight()-200)));	
		} else {
			frame.setResizable(false); // puzzle frame fits on the screen, make it not resizable
		}		

		// set window icon
		try {
			frame.setIconImage(ImageIO.read(new File("src/images/Jigsaw-Puzzle-PNG-Picture.png")));
		} catch (IOException ioe) {
			System.out.println("Icon image file not found! " + ioe);
		}

		// pack
		frame.pack();

		// open window in center
		frame.setLocationRelativeTo(null);

		// focusable
		frame.setFocusable(true);

		// cheat mode key listener (cf. class CheatKeyListener)
		frame.addKeyListener(new CheatKeyListener(solution, crack));

		// request focus on frame when focus is gained again (e.g. after check dialog) - needed for cheat key listener to work at all times
		frame.addWindowFocusListener( new WindowFocusListener() {
			@Override
			public void windowLostFocus(WindowEvent e) {
				// do nothing specific
			}
			@Override
			public void windowGainedFocus(WindowEvent e) {
				// request focus so cheat key listener keeps working
				frame.requestFocus();
			}
		});;		

		// set default close operation to "nothing" in order to be able to show a prompt when exiting
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// prompt on exit
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int result = JOptionPane.showConfirmDialog(frame,
						"Are you sure you want to quit?", "PuzzleMania",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					System.out.println("Program finished.");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}		          
				else if (result == JOptionPane.NO_OPTION)
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});

		// show frame
		frame.setVisible(true);
		
		// frame to object
		setFrame(frame);
		
		// return
		return(frame);
	}



	// getters and setters
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public CreateTaskPanel getTaskPanel() {
		return taskPanel;
	}
	public void setTaskPanel(CreateTaskPanel taskPanel) {
		this.taskPanel = taskPanel;
	}
	public CreateGridPanel getGridPanel() {
		return gridPanel;
	}
	public void setGridPanel(CreateGridPanel gridPanel) {
		this.gridPanel = gridPanel;
	}
	public CreateSolutionPanel getSolutionPanel() {
		return solutionPanel;
	}
	public void setSolutionPanel(CreateSolutionPanel solutionPanel) {
		this.solutionPanel = solutionPanel;
	}
	public CreateCheckPanel getCheckPanel() {
		return checkPanel;
	}
	public void setCheckPanel(CreateCheckPanel checkPanel) {
		this.checkPanel = checkPanel;
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
