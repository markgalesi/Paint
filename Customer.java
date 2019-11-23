//Mark Galesi
//Customer class
//Spec:Customer profile, defines how a customer will interact with the player
import java.awt.Color;
public class Customer
{
	private double standard;
	private int budget;
	private String name;
	public Customer()
	{
		standard = 0;
		budget = 0;
		name = "";
	}
	public Customer(double s, int b, String n)
	{
		standard = s;
		budget = b;
		name = n;
	}
	public String getName()
	{
		return name;
	}
	public double getIntelligence()
	{
		return standard;
	}
	public int getBudget()
	{
		return budget;
	}
}