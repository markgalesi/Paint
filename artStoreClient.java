//Mark Galesi
//artStoreRunner
import java.util.Scanner;
import java.util.ArrayList;
public class artStoreClient
{
	static double balance = 300;
	static int day = 1;
	static int numWork = 0;
	static int cap = 2;
	static ArrayList<Customer> inStore = new ArrayList<Customer>();
	public static void main(String[] args)
	{
		String name = "";
		double price = 0;
		int location = 0;
		int choice = 0;
		int inventory = 3;
		int index = 0;
		int cap = 2;
		int capCost = cap*50;
		int storeCost = cap*50;
		double sellingPrice = 0;
		boolean bankrupt = false;
		boolean working = false;
		boolean firstWork = true;
		Scanner sc = new Scanner(System.in);
		ArtStore a = new ArtStore();
		Creation c;
		ToolBar m;

		System.out.println("Art Store");
		choice = getChoice();
		while((choice >= 1) && (choice <= 7))
		{
			//addPainting
			if(choice == 1)
			{
				//player has a portfolio limit
					if(a.portfolioSize() < cap)
					{
						numWork++;
						//Name painting
						if(firstWork)
						{
							System.out.print("Name your Work:");
							name = sc.nextLine();
						}
						else
						{
							System.out.print("Name your Work:");
							sc.nextLine();
							name = sc.nextLine();
						}
						//paint
						System.out.println("\t\t\tLoading Canvas...");
						working = true;
						m = new ToolBar();
						//stopes user from doing anything in the menu while painting
						while(working)
						{
							System.out.print("");
							working = m.getFinish();
						}
						System.out.println(name + " has been added to your Portfolio");
						//adds creation to portfolio
						a.addPainting(new Painting(name, m.getArr()));
						//paintings cost money to make, using the value calculation, subtracts from your total balance
						balance -= a.viewWork(a.portfolioSize()-1).Value();
						System.out.println(name + " cost $ " + String.format("%.2f", a.viewWork(a.portfolioSize()-1).Value()) + " to make, your balance is now $" + String.format("%.2f", balance));
						//stops user from having a negative balance
						if(balance < 0)
						{
							System.out.println("\t\t\t***You do not have enough funds to create such a masterpiece, you have been refunded " + String.format("%.2f", a.viewWork(a.portfolioSize()-1).Value()) + "***");
							balance += a.viewWork(a.portfolioSize()-1).Value();
							a.remove(a.portfolioSize()-1);
						}
					}
					else
						System.out.println("\t\t\t***No more slots in portfolio***");



				choice = getChoice();
			}
			//valueOfPortfolio
			if(choice == 2)
			{
				System.out.print("Value of all paintings in portfolio?: $" + a.valueOfPortfolio() + "\n");
				choice = getChoice();
			}
			//viewPortfolio
			if(choice == 3)
			{
				System.out.println(a.viewPortfolio());
				choice = getChoice();
			}

			//viewWork
			if(choice == 4)
			{
				//checks if there is a painting to view
				if(a.portfolioSize() >0)
				{
					System.out.println("Choose a work:");
					for(int i=0;i<a.portfolioSize();i++)
					{
						System.out.println("" + (i+1) + ") " + a.viewWork(i).getName());
					}
					location = sc.nextInt()-1;
					System.out.println("\t\t\tLoading Canvas...");
					//opens up canvas window
					c = new Creation(false);
					//display colors on the canvas
					c.View(a.viewWork(location).getPainting());
					choice = getChoice();
				}
				else
					System.out.println("\t\t\t***Your prtfolio is empty***");
				choice = getChoice();

			}
			//sell
			if(choice == 5)
			{
				//checks for paintngs to sell
				if(a.portfolioSize() >0)
				{
					//checks for customers to sell to
					if(inStore.size() > 0)
					{
						firstWork = false;
						//choose customer
						System.out.println("Which customer would you like to sell to");
						for(int i=0;i<inStore.size();i++)
						{
							System.out.println("" + (i+1) + ") " + inStore.get(i).getName());
						}

						index = sc.nextInt()-1;
						//choose painting
						System.out.println("Choose a work to sell to " + inStore.get(index).getName() + ":");
						for(int i=0;i<a.portfolioSize();i++)
						{
							System.out.println("" + (i+1) + ") " + a.viewWork(i).getName());
						}
						location = sc.nextInt()-1;
						//checks if customer has budget for that painting
						if(a.viewWork(location).getPrice() <= inStore.get(index).getBudget())
						{
							//calculates value paid by customer and adds it to your budget
							System.out.println("\t\t\t" + inStore.get(index).getName() + ":I'll buy it for $" + String.format("%.2f", (a.viewWork(location).Value()*(100.0/inStore.get(index).getIntelligence()))));
							sellingPrice = a.viewWork(location).Value()*(100/inStore.get(index).getIntelligence());
							balance += sellingPrice;
							//removes painting
							a.remove(location);
							//customer leaves
							a.exitCustomer(index);
						}
						else
						{
							System.out.println("\t\t\t" + inStore.get(index).getName() + ":I don't have the budget for that piece");
						}
					}
					else
						System.out.println("\t\t\t***There is nobody to sell to***");
				}
				else
					System.out.println("\t\t\t***Your prtfolio is empty***");

				choice = getChoice();

			}
			//new day, brings new customers in, resets daily limit of paintings
			if(choice == 6)
			{
				System.out.println("\t\t\t***New Day***");
				day++;
				a.clearCustomers();
				a.spawnCustomers();
				inStore = a.inStore();
				numWork = 0;
				choice = getChoice();
			}
			//upgrade
			if(choice == 7)
			{
				//sets upgrade cost values
				capCost = cap*50;
				storeCost = a.capacity()*150;
				System.out.println("Choose upgrade");
				System.out.println("1)Portfolio cap(Current:" + cap + ")Cost:$" + capCost);
				System.out.println("2)Store Capacity(Current:" + a.capacity() + ")Cost:$" + storeCost);
				System.out.println("3)Cancel");
				index = sc.nextInt();
				if(index == 1)
				{
					if(balance - capCost >=0)
					{
						cap++;
						balance-= capCost;
						System.out.println("\t\t\t***Your portfolio cap is now" + cap + "***");
						System.out.println("\t\t\t***balance:" + balance);
					}
					else
					{
						System.out.println("\t\t\t***You cannot afford it***");
					}
				}
				if(index == 2)
				{
					if(balance - storeCost >=0)
					{
						a.upgradeCapacity();
						balance-=storeCost;
						System.out.println("\t\t\t***Your store can now hold" + a.capacity() + "people***");
						System.out.println("\t\t\t***balance:" + balance);
					}
					else
					{
						System.out.println("\t\t\t***You cannot afford it***");
					}
				}
				if(index == 3)
				{
						System.out.println("\t\t\t**No upgrades purchaced***");
						System.out.println("\t\t\t***balance:" + balance);
				}
				choice = getChoice();

			}
			//quit
			if(choice == 8)
			{
				System.exit(1);
			}

		}
	}

	public static int getChoice()
	{
		Scanner sc = new Scanner(System.in);
		int x =0;
		//checks if you've created the daily limit of paintings
		if(numWork>=cap)
		{
			return 6;
		}
		System.out.println("Day:" + day + "|Balance:$" + String.format("%.2f", balance));
		System.out.println("");
		//displays all of the customers in the store
		for(int i=0;i<inStore.size();i++)
		{
			System.out.println("\t\t\t***" + inStore.get(i).getName() + " is looking for a painting***");
		}
		System.out.println("");
		System.out.println("1) Add a Painting");
		System.out.println("2) Value of Paintings in Portfolio");
		System.out.println("3) View the Portfolio");
		System.out.println("4) View a Work");
		System.out.println("5) Sell a painting");
		System.out.println("6) New Day");
		System.out.println("7) Upgrade");
		System.out.println("8) quit");
		x = sc.nextInt();
		return x;
	}

}