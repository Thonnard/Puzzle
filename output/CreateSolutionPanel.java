package output;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import input.keyboard.Keyboard;

// this class is used to create the panel that contains the solution grid
public class CreateSolutionPanel {

	// declaration instance variables (encapsulation: private)
	private JScrollPane solutionScrollPanel;
	private JPanel solutionPanel;
	private String userSolution = ""; // String to collect the user input for the solution
	private final static Color labelHighlight = new Color(200,240,187); 	// color light green (highlight label when clicked)

	// constructor
	public CreateSolutionPanel(String solution, String keyboardLayout) {

		// create JPanel
		JPanel solutionPanel = new JPanel();

		// set layout
		solutionPanel.setLayout(new GridLayout(1, solution.length()));		

		// create solution grid
		for (int i=1; i<=solution.length(); i++) { 

			JLabel lbl = new JLabel("T");
			lbl.setText("");

			// bring up keyboard when label is clicked
			lbl.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// only react for exactly 1 mouse click
					if (e.getClickCount() == 1 && !e.isConsumed()) { 
						e.consume(); 
						// get current label color
						Color currentLabelColor = lbl.getBackground();
						// set "highlight" label color
						lbl.setBackground(labelHighlight);
						new Keyboard(keyboardLayout,((JLabel)e.getSource()), currentLabelColor).launch();						
					} else {
						// multiple mouse clicks: do nothing
					}					
				}
			});						

			// set opaque to true (only for label)
			lbl.setOpaque(true);

			// set background color
			lbl.setBackground(Color.GRAY);

			// set other properties
			lbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // border size and color
			lbl.setFont(new Font("Arial", Font.BOLD, 18));	// font style	
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			lbl.setVerticalAlignment(SwingConstants.CENTER);
			lbl.setForeground(new Color(0,0,0));  // use RGB colors; changes color of text 
			lbl.setPreferredSize(new Dimension(60,60));

			// add to grid
			solutionPanel.add(lbl);

			// update userSolution
			this.userSolution = this.userSolution + lbl.getText();
		}

		// make sure user can't focus on solution panel
		solutionPanel.setFocusable(false);

		// add text panel to scroll panel
		JScrollPane scroll = new JScrollPane(solutionPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.getVerticalScrollBar().setUnitIncrement(16); // set scroll speed	
		scroll.setMinimumSize(new Dimension(solution.length()*60,60));

		// save JPanel to object
		this.setSolutionPanel(solutionPanel);

		// save scroll panel to object
		this.setSolutionScrollPanel(scroll);

	}


	// getters and setters
	public JScrollPane getSolutionScrollPanel() {
		return solutionScrollPanel;
	}
	public void setSolutionScrollPanel(JScrollPane solutionScrollPanel) {
		this.solutionScrollPanel = solutionScrollPanel;
	}
	public String getUserSolution() {
		return userSolution;
	}
	public JPanel getSolutionPanel() {
		return solutionPanel;
	}
	public void setSolutionPanel(JPanel solutionPanel) {
		this.solutionPanel = solutionPanel;
	}

}
