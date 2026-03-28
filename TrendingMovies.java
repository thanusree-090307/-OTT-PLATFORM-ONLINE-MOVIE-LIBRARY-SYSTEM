package P1;
import java.util.Scanner;
class Trending{
	String Data;
	Trending Next;
}
class TrendingOpp{
	Trending NewMovie,CMovie,Front,Rear,DelMovie;
	boolean IsEmpty() {
		if(Front==null && Rear==null)
			return true;
		else
			return false;
	}
	void ExistingMovies(String S) {
		NewMovie=new Trending();
		NewMovie.Data=S;
		if(IsEmpty())
			Front=NewMovie;
		else {
			Rear.Next=NewMovie;
		}
		NewMovie.Next=null;
		Rear=NewMovie;
	}
	void Enqueue() {
		NewMovie=new Trending();
		System.out.println("Enter Movie Name:");
		System.out.println("-------------------------");
		Scanner sc=new Scanner(System.in);
		NewMovie.Data=sc.next();
		if(IsEmpty())
			Front=NewMovie;
		else {
			Rear.Next=NewMovie;
		}
		NewMovie.Next=null;
		Rear=NewMovie;
	}
	void Dequeue() {
		if(IsEmpty())
			System.out.println("No Trending Movies Available!!");
		else {
			DelMovie=Front;
			Front=Front.Next;
			DelMovie.Next=null;
			System.out.println("-------------------------");
			System.out.println(DelMovie.Data+" Movie is Removed!!");
			System.out.println("-------------------------");
			DelMovie=null;
		}
	}
	void peep() {
		if(IsEmpty())
			System.out.println("No Trending Movies Available!!");
		else {
			boolean found=false;
			System.out.println("Enter Movie Name to Search:");
			Scanner sc=new Scanner(System.in);
			String E=sc.next();
			CMovie=Front;
			while(CMovie!=null)
			{
				if(CMovie.Data.equals(E)) {
					found=true;
					break;
				}
				CMovie=CMovie.Next;
			}
			if(found) {
				System.out.println("-------------------------");
				System.out.println("Movie Found!");
				System.out.println("-------------------------");
			}
			else {
				System.out.println("-------------------------");
				System.out.println("Movie not Found!!");
				System.out.println("-------------------------");
			}
		}
	}
	void Display() {
		if(IsEmpty()) {
			System.out.println("-------------------------");
			System.out.println("No Trending Movies Available!!");
			System.out.println("-------------------------");
	}
		else {
			CMovie=Front;
			System.out.println("Trending Movies are:");
			System.out.println("-------------------------");
			while(CMovie!=null) {
				System.out.println("-->"+CMovie.Data);
				CMovie=CMovie.Next;
			}
			System.out.println("-------------------------");
		}
	}
}
public class TrendingMovies {
	
	public static void main(String[]args) {
		TrendingOpp T=new TrendingOpp();
		T.ExistingMovies("Doctor");
		T.ExistingMovies("Durandhar");
		T.ExistingMovies("RRR");
		T.ExistingMovies("Hello");
		String x;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("-------------------------");
			System.out.println("Enter your choice:");
			System.out.println("-------------------------");
			System.out.println("1.Display Trending Movies\n2.Add a Trending Movie\n3.Delete Non-Trending Movie \n4.Search a Trending Movie");
			int p=sc.nextInt();
			if(p==1) {
				T.Display();
			}
			else if(p==2){
				T.Enqueue();
				System.out.println("-------------------------");
				System.out.println("Movie is Added!");
				System.out.println("-------------------------");
			}
			else if(p==3){
				T.Dequeue();
			}
			else if(p==4) {
				T.peep();
			}
			System.out.println("Enter Yes to continue and No to Stop");
			x=sc.next();
		}while(x.equals("Yes")||x.equals("yes")||x.equals("YES"));
	}
 
}
