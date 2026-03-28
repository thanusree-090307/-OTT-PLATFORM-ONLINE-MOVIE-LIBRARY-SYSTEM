package P1;

import java.util.Scanner;

class WatchedRecent{
	int top,size;
	String[] WR;
	WatchedRecent()
	{
		top=-1; size=50;
		WR=new String[size];
	}
	boolean IsEmpty()
	{
		if(top==-1)
			return true;
		else
			return false;
	}
	boolean IsFull()
	{
		if(top==size-1)
			return true;
		else 
			return false;
	}
	void push(String E)
	{
		WR[++top]=E;
	}
	String pop()
	{
		String E=WR[top];
	    WR[top--]=null;
	    return E;
	}
	String peek()
	{
		return WR[top];
	}
	boolean peep(String E)
	{
		boolean found=false;
		for(int i=0;i<=top;i++)
		{
			if(WR[i].equals(E))
			{
				found=true;
				break;
			}
		}
		return found;
	}
	void Display()
	{
		for(int i=top;i>=0;i--)
		{
			System.out.println("-->"+WR[i]);
		}
	}
}
public class WatchList {

	public static void main(String[] args) {
		String Opt;
		WatchedRecent W=new WatchedRecent();
		W.push("Amaran");
		W.push("Major");
		W.push("Hanuman");
		W.push("Mirai");
		W.push("Dude");
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("-------------------------");
			System.out.println("Enter your choice:");
			System.out.println("-------------------------");
			System.out.println("1.Add Movie to Watch\n2.Remove a Watched Movie\n3.Search a Movie\n4.Check Top Movie in recently Watched\n5.Display Movies in Watch List");
			int P=sc.nextInt();
			if(P==1)
			{
				if(W.IsFull())
				System.out.println("Watch List is full");
				else {
				System.out.println("Enter Movie Name to Add:");
				W.push(sc.next());
				System.out.println("------------------------");
				System.out.println("Movie is Added!");
				System.out.println("------------------------");
				}
			}
			else if(P==2)
			{
				if(W.IsEmpty())
					System.out.println("Watch List id Empty!!");
				else {
				System.out.println("-------------------------");
				System.out.println("Recent Watched Movie "+W.pop()+"\nIs Removed!!");
				System.out.println("-------------------------");
				}
			}
			else if(P==3)
			{
				if(W.IsEmpty())
					System.out.println("Watch List id Empty! \n search not possible!!");
				else {
					System.out.println("Enter Movie Name:");
					if(W.peep(sc.next()))
					{
						System.out.println("-------------------------");
						System.out.println("Movie found");
						System.out.println("-------------------------");
					}
					else {
						System.out.println("-------------------------");
						System.out.println("Movie not found!!");
						System.out.println("-------------------------");
					}
				}
			}
			else if(P==4)
			{
				if(W.IsEmpty())
					System.out.println("Watch List id Empty!");
				else {
					System.out.println("------------------------------------");
					System.out.println(W.peek()+" is the Recently Watched Movie");
					System.out.println("------------------------------------");
				}
			}
			else if(P==5)
			{
				if(W.IsEmpty())
					System.out.println("Watch List id Empty!");
				else {
					System.out.println("-------------------------");
					System.out.println("Movies in Watch List are:");
				W.Display();
				System.out.println("-------------------------");
				}
			}
			System.out.println("Enter Yes to continue and No to Stop");
			Opt=sc.next();
		}while(Opt.equals("Yes")||Opt.equals("yes")||Opt.equals("YES"));


	}

}
