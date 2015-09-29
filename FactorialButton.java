/************************************************************
* FactorialButton.java
* Dean & Dean
*
* When user clicks button or presses Enter in input text box,
* entered number's factorial displays in the output text box.
************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FactorialButton extends JFrame{
	private static final int WIDTH = 300;
	private static final int HEIGHT = 100;
	private JTextField xBox; // holds user entry
	private JTextField xfBox; // holds generated factorial
 //*********************************************************
	public FactorialButton(){
		setTitle("Factorial Calculator");
		setSize(WIDTH, HEIGHT);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createContents();
		setVisible(true);
	} // end FactorialButton constructor
 //*********************************************************
	private void createContents(){
		JLabel xLabel = new JLabel("x:");
		JLabel xfLabel = new JLabel("x!:");
		JButton btn = new JButton("Factorial");
		Listener listener = new Listener();
		xBox = new JTextField(2);
		xfBox = new JTextField(10);
		xfBox.setEditable(false);
		add(xLabel);
		add(xBox);
		add(xfLabel);
		add(xfBox);
		add(btn);
		xBox.addActionListener(listener);
		btn.addActionListener(listener);
	} // end createContents
//****************************************************
// Inner class for event handling.
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int x; // numeric value for user-entered x
			int xf; // x factorial
			try{
				x=Integer.parseInt(xBox.getText());
			}
			catch (NumberFormatException nfe){
				x = -1; // indicates an invalid x
			}
			if (x < 0)
				xfBox.setText("undefined");
			else{
				if (x == 0 || x == 1)
					xf = 1;
				else{
					xf = 1;
					for (int i=2; i<=x; i++)
						xf *= i;
				} // end else
				xfBox.setText(Integer.toString(xf));
			} // end else
		} // end actionPerformed
	} // end class Listener
//****************************************************
	public static void main(String[] args){
		new FactorialButton();
	} // end main
} // end class FactorialButton
