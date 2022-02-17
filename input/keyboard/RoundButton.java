package input.keyboard;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

//class to make round buttons + change color when clicked
public class RoundButton extends JButton {

	// instance variables
	private final static Color greenColor = new Color(200,240,187);	
	private static final long serialVersionUID = 1L;


	// constructor
	public RoundButton(String label) {
		super(label);

		setBackground(Color.lightGray);
		setFocusable(false);
		setContentAreaFilled(false);
	}

	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(getGreenColor());
		} else {
			g.setColor(getBackground());
		}
		g.fillRoundRect(0, 0, getSize().width-1,getSize().height-1, 13, 13);

		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawRoundRect(0, 0, getSize().width-1,getSize().height-1, 13, 13);

	}


	// getter
	public Color getGreenColor() {
		return greenColor;
	}

}
