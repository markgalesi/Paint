//Mark Galesi
//ArtStore class
//Spec:Art Store:manages customers, paintings and store functions
import java.util.ArrayList;
import java.util.Collections;

public class ArtStore
{
	private ArrayList<Painting> portfolio;
	private ArrayList<Customer> inStore;
	private ArrayList<Customer> customers;
	private int portfolioLength = 0;
	private int capacity = 3;
	Painting p = new Painting();

	public ArtStore()
	{
		portfolio = new ArrayList<Painting>();
		//represents all customers inside the store, looking to buy art
		inStore = new ArrayList<Customer>();
		//represents all customers not inside the store
		customers = new ArrayList<Customer>();
		//default 15 customers, intelligence will be used to get a price each customer will pay for the art, the higher the intel, the lower they will pay for the terrible art the user creates
		customers.add(new Customer(120,100000,"Benjamin"));
		customers.add(new Customer(95,50000,"Mary"));
		customers.add(new Customer(90,2500,"John"));
		customers.add(new Customer(85,2000,"Patricia"));
		customers.add(new Customer(80,1500,"Robert"));
		customers.add(new Customer(105,1200,"Jennifer"));
		customers.add(new Customer(55,1000,"Michael"));
		customers.add(new Customer(55,800,"Elizabeth"));
		customers.add(new Customer(100,600,"William"));
		customers.add(new Customer(35,500,"Linda"));
		customers.add(new Customer(40,400,"David"));
		customers.add(new Customer(35,300,"Barbra"));
		customers.add(new Customer(110,200,"Richard"));
		customers.add(new Customer(87,100,"Susan"));
		customers.add(new Customer(15,50,"Jessica"));
	}

	//depending on the stores capacity(which can be upgraded), moves x random customers to inside the store
	public void spawnCustomers()
	{
		int x = 0;
		for(int i=0;i<capacity;i++)
		{
			x = (int)(Math.random()*customers.size()-1);
			inStore.add(customers.get(x));
			customers.remove(x);
		}
	}
	//takes a specific customer and moves them outside the store
	public void exitCustomer(int i)
	{
		customers.add(inStore.get(i));
		inStore.remove(i);
	}
	//removes all customers from inside store
	public void clearCustomers()
	{
		for(int i=0;i<inStore.size();i++)
		{
			customers.add(inStore.get(i));
		}
		inStore.clear();
	}
	//allows more customers to be inside the store at one time
	public void upgradeCapacity()
	{
		capacity++;
	}
	//capacity accessor method
	public int capacity()
	{
		return capacity;
	}
	//customers in store accessor method
	public ArrayList<Customer> inStore()
	{
		return inStore;
	}
	//returns total # of customers
	public int Customers()
	{
		return customers.size();
	}
	//adds painting to portfolio
	public void addPainting(Painting p)
	{
			portfolio.add(p);
			portfolioLength++;
	}
	//removes painting from portfolio
	public void remove(int location)
	{
		portfolio.remove(location);
		portfolioLength--;
	}
	//portfolio size accessor method
	public int portfolioSize()
	{
		return portfolio.size();
	}
	//returns the string representation of a specific painting
	public String viewPainting(int location)
	{
		return portfolio.get(location).toString();
	}
	//returns the actual painting made, so it can be viewed
	public Painting viewWork(int location)
	{
		return portfolio.get(location);
	}
	//returns total value ofa all paintings in portfolio
	public double valueOfPortfolio()
	{
		double sum=0;
		for(int i=0;i<portfolio.size();i++)
		{
			sum+=portfolio.get(i).getPrice();
		}
		return sum;
	}
	//string representation of portfolio
	public String viewPortfolio()
	{
		String result ="";
		for(int i=0;i<portfolio.size();i++)
		{
			result += "Name" + portfolio.get(i).getName() + "||Price" + portfolio.get(i).getPrice() + "\n";
		}
		return result;
	}


}