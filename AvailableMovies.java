package P1;
import java.io.FileWriter;
import java.io.IOException;

public class AvailableMovies {

	public static void displayAvailableMovies(Movie[] M1) {
		try {
			FileWriter fw=new FileWriter("MoviesAvailable.txt");
			fw.write("=========Welcome To Movie World!=========");
			for(int i=0;i<M1.length;i++) {
				fw.write("MovieID: "+ M1[i].MovieId+"\n");
				fw.write("Movie Name: "+ M1[i].MName+"\n");
				fw.write("Genre Code: "+ M1[i].GCode+"\n");
				fw.write("Ratings: "+ M1[i].Ratings+"\n");
				fw.write("Views: "+ M1[i].Views+"\n");
				fw.write("---------------------------------\n");
				
				M1[i].DisplayAvaMovie();
				System.out.println("--------------------------------");
			}
			fw.close();
			System.out.println("Available Movies Displayed!!");
			System.out.println("--------------------------------");
		}catch(IOException e) {
			System.out.println("Error In Displaying Movies");
		}
	}

}
