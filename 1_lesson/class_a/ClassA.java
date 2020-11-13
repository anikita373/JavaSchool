package class_a;
import java.util.Scanner;

public class ClassA
{
	public void printMessage()
	{
				System.out.println("Don't trust the flies, they are government spies");
		System.out.println("Do you trust them? [y/n]");
	  
	    Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
		
	switch(answer){             
		case "y": 
			System.out.println("Nice :)");
			break;
		case "n": 
			System.out.println("Not nice :(");
			break;
		default:
			System.out.println("I dont understand u :/");
    }
	}
}