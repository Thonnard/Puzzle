package output;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import input.keyboard.Keyboard;
import input.keyboard.KeyboardHint;

// this class is used to create the grid panel 
public class CreateGridPanel {

	// declaration instance variables (encapsulation: private)
	private JScrollPane gridPanel;
	private final static Random random_element = new Random(); // for setting seed (always same randomization for keyboard hints)
	private final static Color labelHighlight = new Color(200,240,187); 	// color light green (highlight label when clicked)

	// constructor
	public CreateGridPanel(Map<Integer, String> gridHashMap, Integer Rows, Integer Columns, String keyboardLayout, String level) {

		// create JPanel
		JPanel gridPanel = new JPanel();

		// set layout
		gridPanel.setLayout(new GridLayout(Rows, Columns));

		// create grid
		int count = 0;
		for (int i=1; i<=Rows; i++) {
			for (int j=1; j<=Columns; j++) {

				// new label, empty
				JLabel lbl = new JLabel("");

				// set opaque to true
				lbl.setOpaque(true);

				// set background color
				if(gridHashMap.get(count).equals("X")) {
					lbl.setBackground(Color.BLACK);
				} else if (gridHashMap.get(count).equals("O")) {
					lbl.setBackground(Color.WHITE);
				} else if (gridHashMap.get(count).equals("S")) {
					lbl.setBackground(Color.GRAY);
				} else {
					lbl.setBackground(new Color(136,205,255));
				}							

				// listener for all labels except black
				if(!gridHashMap.get(count).equals("X")) { // label not equal to X
					if(!(gridHashMap.get(count).equals("O") | gridHashMap.get(count).equals("S"))) { // label not equal to O or S (so it's a hint label)
						String hint = gridHashMap.get(count).substring(gridHashMap.get(count).indexOf("(")+1, gridHashMap.get(count).indexOf(")"));						
						// bring up hint keyboard when label is clicked once
						lbl.addMouseListener(new MouseAdapter() {
							public void mousePressed(MouseEvent e) {
								// only react for exactly 1 mouse click
								if (e.getClickCount() == 1 && !e.isConsumed()) {
									e.consume();
									// get current label color
									Color currentLabelColor = lbl.getBackground();
									// set "highlight" label color
									lbl.setBackground(labelHighlight);
									// make sure the random characters are always the same for each hint so they can not be deduced
									random_element.setSeed(9999); 
									// new hint keyboard
									new KeyboardHint(keyboardLayout,((JLabel)e.getSource()), currentLabelColor, hint, level, random_element).launch();									
								} else {
									// multiple mouse clicks: do nothing
								}
							}
						});
					} else { // label = O or S
						// bring up keyboard when label is clicked
						lbl.addMouseListener(new MouseAdapter() {
							public void mousePressed(MouseEvent e) {
								// only react for exactly 1 mouse click
								if (e.getClickCount() == 1 && !e.isConsumed()) {
									e.consume(); 
									// get current label color
									Color currentLabelColor = lbl.getBackground();
									// set "highlight" label color
									lbl.setBackground(labelHighlight);
									// new keyboard
									new Keyboard(keyboardLayout,((JLabel)e.getSource()), currentLabelColor).launch();
									
								} else {
									// multiple mouse clicks: do nothing
								}								
							}
						});

					}
				}

				// other properties
				lbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // border size and color
				lbl.setFont(new Font("Arial", Font.BOLD, 18));	// font style
				lbl.setHorizontalAlignment(SwingConstants.CENTER);
				lbl.setVerticalAlignment(SwingConstants.CENTER);
				lbl.setForeground(new Color(0,0,0));  // use RGB colors; changes color of text 
				lbl.setPreferredSize(new Dimension(60,60));

				// add label to grid
				gridPanel.add(lbl);

				// increment counter
				count ++;
			}
		}

		// make sure user can focus on grid panel
		gridPanel.setFocusable(true);

		// add  gridPanel to scroll panel
		JScrollPane scroll = new JScrollPane(gridPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.getVerticalScrollBar().setUnitIncrement(16); // set scroll speed	
		scroll.setMinimumSize(new Dimension (Rows*60,Columns*60));

		// save panel to object
		this.setGridPanel(scroll);
	}

	// getters and setters
	public JScrollPane getGridPanel() {
		return gridPanel;
	}
	public void setGridPanel(JScrollPane gridPanel) {
		this.gridPanel = gridPanel;
	}

}
