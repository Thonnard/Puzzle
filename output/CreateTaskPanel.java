package output;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

// this class is used to create a panel that shows the across and down tasks
public class CreateTaskPanel {

	// instance variables
	private JScrollPane taskPanel;

	// constructor
	public CreateTaskPanel (List<String> Across, List<String> Down) {

		// create textPane
		JTextPane textPane = new JTextPane();

		// create different styles
		// main title
		Style styleMainTitle = textPane.addStyle("", null);
		StyleConstants.setForeground(styleMainTitle, new Color(80,205,255));
		StyleConstants.setBackground(styleMainTitle, Color.white);
		StyleConstants.setBold(styleMainTitle, true);
		StyleConstants.setFontSize(styleMainTitle, 22);
		// subtitle
		Style styleTitle = textPane.addStyle("", null);
		StyleConstants.setForeground(styleTitle, Color.BLACK);
		StyleConstants.setBackground(styleTitle, Color.white);
		StyleConstants.setBold(styleTitle, true);
		StyleConstants.setFontSize(styleTitle, 20);
		// normal style		
		Style styleOne = textPane.addStyle("", null);
		StyleConstants.setForeground(styleOne, Color.BLACK);
		StyleConstants.setBackground(styleOne, Color.white);
		// style when clue starts with year
		Style styleTwo = textPane.addStyle("", null);
		StyleConstants.setBold(styleTwo, true);
		StyleConstants.setForeground(styleTwo, Color.BLACK);
		StyleConstants.setBackground(styleTwo, Color.white);

		// create doc to add to the textPane
		Document doc = textPane.getDocument();

		// add main title
		try {
			doc.insertString(doc.getLength(), "Puzzle instructions\n",styleMainTitle);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		

		// add "Across" title
		try {
			doc.insertString(doc.getLength(), "\nAcross\n",styleTitle);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// add across task
		for (String s : Across)
			try {
				// regex for string starting with year
				if(s.matches("^.*(\\.\\s)[0-9]{4},.*$")) {
					doc.insertString(doc.getLength(), s+"\n", styleTwo);
				} else {
					doc.insertString(doc.getLength(), s+"\n", styleOne);
				}

			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		
		// add "Down" title        
		try {
			doc.insertString(doc.getLength(), "\nDown\n",styleTitle);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// add down task
		for (String s : Down)
			try {
				// regex for string starting with year
				if(s.matches("^.*(\\.\\s)[0-9]{4},.*$")) {
					doc.insertString(doc.getLength(), s+"\n", styleTwo);
				} else {
					doc.insertString(doc.getLength(), s+"\n", styleOne);
				}

			} catch (BadLocationException e) {
				e.printStackTrace();
			}

		// make sure the user can not write in the textPane
		textPane.setEditable(false);

		// make sure user can't focus on text pane (so cheat keylistener remains available)
		textPane.setFocusable(false);
		
		// add text panel to scroll panel
		JScrollPane scroll = new JScrollPane(textPane);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.getVerticalScrollBar().setUnitIncrement(16); // set scroll speed	
		scroll.setMinimumSize(new Dimension(300,800));
		
		// scrollpanel to variable
		this.setTaskPanel(scroll);

	}

	// setters and getters
	public JScrollPane getTaskPanel() {
		return taskPanel;
	}
	public void setTaskPanel(JScrollPane taskPanel) {
		this.taskPanel = taskPanel;
	}

}
