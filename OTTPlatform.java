package P1;
import java.util.Scanner;

class Movie
{
	int MovieId; 
	String MName,GCode;
	double Ratings;
	String Views;
	Movie(int MId,String MovieName,String GenreCode,double Rating,String View )
	{
		this.MovieId=MId;
		this.MName=MovieName;
		this.GCode=GenreCode;
		this.Ratings=Rating;
		this.Views=View;
	}
	void DisplayAvaMovie()
	{
		System.out.println("MovieID: "+MovieId);
		System.out.println("Movie Name: "+MName);
		System.out.println("Genre Code: "+GCode);
		System.out.println("Ratings: "+Ratings);
		System.out.println("Views: "+Views);
	}
}
public class OTTPlatform {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opt; String choice;
		System.out.println("------------Welcome To Movie World !!----------- \n");
		Movie[] M1=new Movie[8];
		M1[0]=new Movie(111,"Bahubali:The Beginning","ACT",8.0,"50M");
		M1[1]=new Movie(112,"Hit-3","THR",7.0,"20M");
		M1[2]=new Movie(113,"3-Idiots","COM",8.4,"60M");
		M1[3]=new Movie(114,"Hi Nanna","FAM",8.2,"25M");
		M1[4]=new Movie(115,"Sita Ramam","ROM",8.6,"40M");
		M1[5]=new Movie(116,"Arundhati","HOR",7.4,"10M");
		M1[6]=new Movie(117,"Bajirao Mastani","HIS",7.2,"30M");
		M1[7]=new Movie(118,"RRR","ACT",8.5,"45M");
		TrendingOpp T=new TrendingOpp();
		T.ExistingMovies("Doctor");
		T.ExistingMovies("Durandhar");
		T.ExistingMovies("RRR");
		T.ExistingMovies("Hello");
		HistoryOpp W1=new HistoryOpp();
		WatchedRecent W=new WatchedRecent();
		W.push("Amaran");
		W.push("Major");
		W.push("Hanuman");
		W.push("Mirai");
		W.push("Dude");
		do
		{
		System.out.println("Enter Your choice: ");
		System.out.println("-----------------------");
		System.out.println("1.Check Movies Available\n2.Trending Movies List\n3.Search Movies\n4.Watch History\n5.Watch List\n6.Sort Movies");
		opt=sc.nextInt();
		switch(opt)
		{
		case 1:
			AvailableMovies.displayAvailableMovies(M1);
			break;
		case 2:
			String x;
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
			System.out.println("-------------------------");
			System.out.println("Exited from Trending Movies");
			System.out.println("-------------------------");
			break;
		case 3:
			System.out.println("Enter Your choice:");
			System.out.println("-----------------------");
			System.out.println("1.Search by MovieId\n2.Search by Movie Name\n3.Search by Genre Code");
			int c=sc.nextInt();
			System.out.println("---------------------------------");
			if(c==1) {
				System.out.println("Enter MovieId:");
				int MI=sc.nextInt();
				boolean found=false;
			for(int i=0;i<M1.length;i++) {
				if(MI==M1[i].MovieId) {
					found=true;
					M1[i].DisplayAvaMovie();
					System.out.println("---------------------------------");
					break;
				}
			}
			if(!found) {
				System.out.println("Movie Not Available");
			}
			}
			if(c==2) {
				System.out.println("Enter Movie Name:");
				String MN=sc.next();
				boolean found=false;
			for(int i=0;i<M1.length;i++) {
				if(MN.equals(M1[i].MName)) {
					found=true;
					M1[i].DisplayAvaMovie();
					System.out.println("---------------------------------");
					break;
				}
			}
			if(!found) {
				System.out.println("Movie Not Available");
			}
			}
			if(c==3) {
				System.out.println("Enter Genre Code:");
				String GC=sc.next();
				boolean found=false;
			for(int i=0;i<M1.length;i++) {
				if(GC.equals(M1[i].GCode)) {
					found=true;
					M1[i].DisplayAvaMovie();
					System.out.println("---------------------------------");
				}
			}
			if(!found) {
				System.out.println("Movie Not Available");
			}
			}
			break;
		case 4:
			String s;
			System.out.println("Movies in Watch History:");
			System.out.println("-------------------------");
			W1.presentmovies();
			W1.Display();
			do
			{
			System.out.println("----------------------");
			System.out.println("Enter your choice:");
			System.out.println("----------------------");
			System.out.println("1.Add Movie to Watch History\n2.Delete Movie from Watch History");
			int ch=sc.nextInt();
			if(ch==1)
			{
				W1.AddMovie();
				W1.Display();
			}
			else if(ch==2)
			{
				W1.Delete();
			}
			System.out.println("---------------------------------");
			System.out.println("Type Yes to cotinue or No to stop ");
		    s=sc.next();
		}while(s.equals("yes")||s.equals("Yes")||s.equals("YES"));
			System.out.println("-------------------------");
			System.out.println("Exited from Watch History");
			System.out.println("-------------------------");
			break;
		case 5:
			String Opt;
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
						System.out.println("Watch List is Empty!!");
					else {
					System.out.println("-------------------------");
					System.out.println("Recent Watched Movie "+W.pop()+"\nIs Removed!!");
					System.out.println("-------------------------");
					}
				}
				else if(P==3)
				{
					if(W.IsEmpty())
						System.out.println("Watch List is Empty! \n search not possible!!");
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
						System.out.println("Watch List is Empty!");
					else {
						System.out.println("------------------------------------");
						System.out.println(W.peek()+" is the Recently Watched Movie");
						System.out.println("------------------------------------");
					}
				}
				else if(P==5)
				{
					if(W.IsEmpty())
						System.out.println("Watch List is Empty!");
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
			System.out.println("-------------------------");
			System.out.println("Exited from Watch List");
			System.out.println("-------------------------");
			break;
		case 6:
			System.out.println("Enter Your choice:");
			System.out.println("-----------------------");
			System.out.println("1.Sort by rating\n2.Sort by views\n3.Sort by alphabetical order");
			int Schoice=sc.nextInt();
			if(Schoice==1) {
				for(int r=1;r<M1.length;r++)
				{
					for(int i=0;i<M1.length-r;i++)
					{
						if(M1[i].Ratings<M1[i+1].Ratings) {
							Movie temp=M1[i];
							M1[i]=M1[i+1];
							M1[i+1]=temp;
						}
					}
				}
			}
			else if(Schoice==2) {
				for(int r=1;r<M1.length;r++)
				{
					for(int i=0;i<M1.length-r;i++)
					{
						if(M1[i].Views.compareTo(M1[i+1].Views)<0) {
							Movie temp=M1[i];
							M1[i]=M1[i+1];
							M1[i+1]=temp;
						}
					}
				}
			}
			else if(Schoice==3) {
				for(int r=1;r<M1.length;r++)
				{
					for(int i=0;i<M1.length-r;i++)
					{
						if(M1[i].MName.compareTo(M1[i+1].MName)>0) {
							Movie temp=M1[i];
							M1[i]=M1[i+1];
							M1[i+1]=temp;
						}
					}
				}
			}
			for(int i=0;i<M1.length;i++) {
				M1[i].DisplayAvaMovie();
				System.out.println("---------------------------------");
			}
			break;
		}
		System.out.println("Enter Y to continue and N to Exit: ");
		choice=sc.next();
		}while(choice.equals("Y")||choice.equals("y"));
		System.out.println("Exiting from the page....");
		System.out.println("Exited successfully!");
	}

}
