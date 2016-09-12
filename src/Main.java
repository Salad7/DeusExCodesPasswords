import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static void main(String [] args)
	{
		Database.init();
		
		Database.loadFile("./res/test");
		
		System.out.println(Database.printAll());
		
	}
	
	
}
