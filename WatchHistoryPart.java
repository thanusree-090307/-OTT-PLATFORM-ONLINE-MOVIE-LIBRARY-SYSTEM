package P1;
import java.util.Scanner;
class History{
	String Data;
	History Next;
}
class HistoryOpp{
	History NewMovie,NextMovie,CMovie,PMovie,Head,DelMovie;
	void presentmovies()
	{
		if(Head==null) {
		NewMovie=new History();
		NewMovie.Data="Durandhar";
		Head=NewMovie;
		
		NextMovie=new History();
		NextMovie.Data="KGF";
		NextMovie.Next=null;
		NewMovie.Next=NextMovie;
		}
	}
	void Display()
	{
		if(Head==null)
			System.out.println("Watch History is empty");
		else {
			CMovie=Head;
			while(CMovie!=null) {
				System.out.print("-->"+CMovie.Data+"\n");
				CMovie=CMovie.Next;
			}
		}
	}
	void AddMovie()
	{
		NewMovie=new History();
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter Movie Name to Add:");
		NewMovie.Data=sc.next();
		NewMovie.Next=Head;
		Head=NewMovie;
		System.out.println("Movie is Added ");
		System.out.println("-------------------------");
	}
	void Delete() 
	 {
		if(Head==null)
			System.out.println("Watch History is Empty");
		else {
			System.out.println("Enter Movie Name to Remove:");
			Scanner sc=new Scanner(System.in);
			String Name=sc.next();
			boolean found=false;
			CMovie=Head;
			PMovie=null;
			while(CMovie!=null) {
			if(Name.equals(CMovie.Data)) {
				if(PMovie==null)
				{
					System.out.println(Head.Data+" Movie is Deleted!!");
					System.out.println("-------------------------");
					Head=Head.Next;
				}
				else
				{
				DelMovie=CMovie;
				PMovie.Next=CMovie.Next;
				DelMovie.Next=null;
				System.out.println(DelMovie.Data+" Movie is Removed!!");
				System.out.println("-------------------------");
				DelMovie=null;
				}
				found=true;
				System.out.println("Movies in Watch History are:");
				System.out.println("-------------------------");
				Display();
				break;
			}
			PMovie=CMovie;
			CMovie=CMovie.Next;
			}
			if(found==false) {
				System.out.println("----------------------------------");
				System.out.println("Movie not found in Watch History!!");
			}
		}
  }
}
public class WatchHistoryPart {

	public static void main(String[] args) {
		HistoryOpp obj1=new HistoryOpp();
		Scanner sc=new Scanner (System.in);
		String s;
		System.out.println("Movies in Watch History:");
		System.out.println("-------------------------");
		obj1.presentmovies();
		obj1.Display();
		do
		{
		System.out.println("Enter your choice:");
		System.out.println("----------------------");
		System.out.println("1.Add Movie to Watch History\n2.Delete Movie from Watch History");
		int choice=sc.nextInt();
		if(choice==1)
		{
			obj1.AddMovie();
			obj1.Display();
		}
		else if(choice==2)
		{
			obj1.Delete();
		}
		System.out.println("---------------------------------");
		System.out.println("Type Yes to cotinue or No to stop ");
	    s=sc.next();
	}while(s.equals("yes")||s.equals("Yes")||s.equals("YES"));
		
	}

}
