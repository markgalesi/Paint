//Mark Galesi
//ToolBar class
//Spec:Toolbar that allows user to change colors and clear the board and submit paintings
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ToolBar extends JFrame
{
	private Timer tmr;
	private boolean working;
	private JButton btnClear;
	private JButton btnRed;
	private JButton btnBlue;
	private JButton btnGreen;
	private JButton btnBlack;
	private JButton btnLightGray;
	private JButton btnMagenta;
	private JButton btnCyan;
	private JButton btnOrange;
	private JButton btnDarkGray;
	private JButton btnPink;
	private JButton btnGray;
	private JButton btnWhite;
	private JButton btnYellow;
	private JButton btnFinish;
	private JButton btnExit;
	private Color[][]temp;
	Creation foo = new Creation(true);

	public ToolBar()
	{
		super("Tool Bar");

		working = true;
		temp = new Color[200][120];
       	//buttons
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ButtonListener());

		btnRed = new JButton("Red(.06¢)");
		btnRed.addActionListener(new ButtonListener());

		btnBlue = new JButton("Blue(.06¢)");
		btnBlue.addActionListener(new ButtonListener());

		btnGreen = new JButton("Green(.10¢)");
		btnGreen.addActionListener(new ButtonListener());

		btnBlack = new JButton("Black");
		btnBlack.addActionListener(new ButtonListener());

		btnLightGray = new JButton("Light Gray");
		btnLightGray.addActionListener(new ButtonListener());

		btnMagenta = new JButton("Magenta(.13¢)");
		btnMagenta.addActionListener(new ButtonListener());

		btnCyan = new JButton("Cyan(.13¢)");
		btnCyan.addActionListener(new ButtonListener());

		btnOrange = new JButton("Orange(.10¢)");
		btnOrange.addActionListener(new ButtonListener());

		btnDarkGray = new JButton("Dark Gray");
		btnDarkGray.addActionListener(new ButtonListener());

		btnPink = new JButton("Pink(.10¢)");
		btnPink.addActionListener(new ButtonListener());

		btnGray = new JButton("Gray");
		btnGray.addActionListener(new ButtonListener());

		btnWhite = new JButton("White");
		btnWhite.addActionListener(new ButtonListener());

		btnYellow = new JButton("Yellow(.10¢)");
		btnYellow.addActionListener(new ButtonListener());

		btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ButtonListener());

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ButtonListener());


		Container cp = getContentPane();
		cp.setLayout(new GridLayout(16,1));

		//container
		cp.add(btnClear);
		cp.add(btnRed);
		cp.add(btnBlue);
		cp.add(btnGreen);
		cp.add(btnBlack);
		cp.add(btnLightGray);
		cp.add(btnMagenta);
		cp.add(btnCyan);
		cp.add(btnOrange);
		cp.add(btnDarkGray);
		cp.add(btnPink);
		cp.add(btnGray);
		cp.add(btnWhite);
		cp.add(btnYellow);
		cp.add(btnFinish);
		cp.add(btnExit);

		//setSize
		setSize(350,700);
		setLocation(1000,50);
		setVisible(true);

	}
    public static void main(String[] args)
    {
		Menu menu = new Menu();
	}
	//signals when the user is done painting
	public boolean getFinish()
	{
		return working;
	}
	//returns temp to be recorded in an object stored in an array
	public Color[][] getArr()
	{
		return temp;
	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			if(event.getSource() == btnClear)
			{
				foo.clear();
			}
			if(event.getSource() == btnRed)
			{
				foo.changeColor(Color.red);
				repaint();
			}
			if(event.getSource() == btnBlue)
			{
				foo.changeColor(Color.blue);
			}
			if(event.getSource() == btnGreen)
			{
				foo.changeColor(Color.green);
			}
			if(event.getSource() == btnBlack)
			{
				foo.changeColor(Color.black);
			}
			if(event.getSource() == btnLightGray)
			{
				foo.changeColor(Color.lightGray);
			}
			if(event.getSource() == btnMagenta)
			{
				foo.changeColor(Color.magenta);
			}
			if(event.getSource() == btnCyan)
			{
				foo.changeColor(Color.cyan);
			}
			if(event.getSource() == btnOrange)
			{
				foo.changeColor(Color.orange);
			}
			if(event.getSource() == btnDarkGray)
			{
				foo.changeColor(Color.darkGray);
			}
			if(event.getSource() == btnPink)
			{
				foo.changeColor(Color.pink);
			}
			if(event.getSource() == btnGray)
			{
				foo.changeColor(Color.gray);
			}
			if(event.getSource() == btnWhite)
			{
				foo.changeColor(Color.white);
			}
			if(event.getSource() == btnYellow)
			{
				foo.changeColor(Color.yellow);
			}
			if(event.getSource() == btnFinish)
			{
				working = false;
				//sets temp to painting created
				temp = foo.Finish();
				setVisible(false);
				foo.setVisible(false);
			}
			if(event.getSource() == btnExit)
			{
				setVisible(false);
				dispose();
			}

		}
	}
}