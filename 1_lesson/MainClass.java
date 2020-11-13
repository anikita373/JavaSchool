import class_a.ClassA;
import class_b.ClassB;

public class MainClass
{
	public static void main(String[] args)
	{
		ClassA fristclass = new ClassA();
		ClassB secondclass = new ClassB();
		fristclass.printMessage();
		secondclass.printMessage();
		for (int i = 0; i < args.length; i++)
		{
			System.out.println(args[i]);
		} 
            

	}
}