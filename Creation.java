//Mark Galesi
//Creation class
//Spec:Canvas object used to create paintings and the Color[][] used to value them
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Creation extends JFrame
{
	//private Timer tmr;
	//private TimerListener tmrListener;
	private MouseListener mouse;
	private JLabel[][] mat;
	private Color[][] matColor;
	private int red = 50;
	private int blue = 50;
	private int green = 30;
	private int magenta = 20;
	private int cyan = 20;
	private int orange = 30;
	private int yellow = 30;
	private ArrayList<Painting> portfolio;
	private int cubeSize = 5;
	private int width = 1000;
	private int height = 600;
	private int matX = width/cubeSize;
	private int matY = height/cubeSize;
	private int x = 0;
	private int y = 0;
	private int r = 0;
	private int g = 0;
	private int b = 0;
	private int numPainting = 0;
	private String workName = "";
	private int workNum = 0;
	private boolean inBounds = true;
	private boolean editable = true;
	Color labelColor;
	Color activeColor = Color.white;
	Container cp = getContentPane();
	Painting p;

	public Creation(boolean edit)
	{
		super("Canvas");
		//Whether painting is being created or viewed
		editable = edit;

		Container cp = getContentPane();
		cp.setLayout(null);
		cp.addMouseListener(new mouseListener());
        addMouseListener(new mouseListener());
		cp.addMouseMotionListener(new motionListener());
        addMouseMotionListener(new motionListener());


		//Array or labels used to create the image
		mat = new JLabel[matX][matY];
		//Array that stores the different colors used in the array
		matColor = new Color[matX][matY];

		/*Populates array, adds each to the content pane and sets size depending on size of window
		*sets location depending on the size of each cube, defaault background is white
		*/
		for(int row=0;row<mat.length;row++)
		{
			for(int col=0;col<mat[row].length;col++)
			{
				mat[row][col] = new JLabel("");
				cp.add(mat[row][col]);
				mat[row][col].setLocation(row*cubeSize,col*cubeSize);
				mat[row][col].setSize(width/matX,height/matY);
				mat[row][col].setBackground(Color.white);
				matColor[row][col] = Color.white;
				mat[row][col].setOpaque(true);
			}
		}

		//setSize
		setSize(width,height);
		setVisible(true);
        setResizable(false);
	}
	//returns the array of colors so that it can be paired with a name and given a value to be stored in an array
	public Color[][] Finish()
	{
		return matColor;
	}
	//sets each label back to white
	public void clear()
	{
		for(int row=0;row<mat.length;row++)
		{
			for(int col=0;col<mat[row].length;col++)
			{
					mat[row][col].setBackground(Color.white);
					matColor[row][col] = Color.white;
			}
		}
	}
	//sets the color of each pixel to a color according to a specific array of colors
	public void View(Color[][]arr)
	{
		for(int row=0;row<mat.length;row++)
		{
			for(int col=0;col<mat[row].length;col++)
			{
					mat[row][col].setBackground(arr[row][col]);
					matColor[row][col] = arr[row][col];
			}
		}
	}
	//changes active color to a different one
	public void changeColor(Color newColor)
	{
		activeColor = newColor;
	}

	//mouseMotionListener
	//where i researched motionListeners:https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseMotionListener.html
	private class motionListener implements MouseMotionListener
	{
		public void mouseMoved(MouseEvent e)
		{
		}
		public void mouseDragged(MouseEvent e)
		{
			if((inBounds) && (editable))
			{
				//gets coords of mouse while dragging and scales it to the resolution of the label[][]
				x = (e.getX())/cubeSize;
				y = (e.getY())/cubeSize;
				//sets the label the mouse is over to the current color
				mat[x][y].setBackground(activeColor);
				matColor[x][y] = activeColor;
			}
		}
	}
	//mouseListener
	//Where i researched mouse listeners:https://docs.oracle.com/javase/tutorial/uiswing/events/mouselistener.html
	private class mouseListener implements MouseListener
	{
		public void mousePressed(MouseEvent e)
		{
			if(editable)
			{
				//gets coords of mouse while clicking and scales it to the resolution of the label[][]
				x = (e.getX())/cubeSize;
				y = (e.getY())/cubeSize;
				//sets the label the mouse is over to the current color
				mat[x][y].setBackground(activeColor);
				matColor[x][y] = activeColor;
			}
		}

		public void mouseReleased(MouseEvent e)
		{
		}

		public void mouseEntered(MouseEvent e)
		{
			inBounds = true;
		}

		public void mouseExited(MouseEvent e)
		{
			inBounds = false;
		}

		public void mouseClicked(MouseEvent e)
		{
		}
	}
}