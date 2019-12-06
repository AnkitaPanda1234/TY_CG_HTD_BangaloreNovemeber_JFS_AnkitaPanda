
public class Crush 
{
	void recieve(Phone p)
	{
		if(p instanceof BasicSet)
		{
			System.out.println("Thank you");
		}
		else if(p instanceof Oppo)
		{
			System.out.println("Thank you so much ");
		}
		else if(p instanceof OnePlus)
		{
			System.out.println("Thank you dear");
		}
		else if(p instanceof Apple)
		{
			System.out.println("i Love you");
		}
		else{
			System.out.println("idiot");
		}
	}

}
