//Mark Galesi
//Painting class
//Spec:Basic object of a painting, has a name and value
import javax.swing.*;
import java.awt.Color;
public class Painting
{
	double price;
	String name;
	double value;
	//used to generate value and view paintings in runner
	private Color[][] mat;
	public Painting()
	{
		name = "";
		price = 0;
		mat = new Color[0][0];
	}
	public Painting(String n, Color[][]paint)
	{
		name = n;
		mat = paint;
	}
	//name accessor method
	public String getName()
	{
		return name;
	}
	//price accessor method
	public double getPrice()
	{
		return price;
	}
	//painting accessor method
	public Color[][] getPainting()
	{
		return mat;
	}
	//returns value based upon the # of each color used, each color having a different score
	public double Value()
	{
		double value = 0;
		Color c;
		for(int row=0;row<mat.length;row++)
		{
			for(int col=0;col<mat[row].length;col++)
			{
				c = mat[row][col];
				if(c==Color.red)
					value+=2;
				if(c==Color.blue)
					value+=2;
				if(c==Color.green)
					value+=3;
				if(c==Color.magenta)
					value+=4;
				if(c==Color.cyan)
					value+=4;
				if(c==Color.orange)
					value+=3;
				if(c==Color.pink)
					value+=3;
				if(c==Color.yellow)
					value+=3;
			}
		}
		return value/30;
	}
	//String representation of the painting
	public String toString()
	{
		String result = "";
		result += name;
		result += price;
		for(int row=0;row<mat.length;row++)
		{
			for(int col=0;col<mat[row].length;col++)
			{
				result += "\n" + mat[row][col];
			}
		}
		return result;
	}
}