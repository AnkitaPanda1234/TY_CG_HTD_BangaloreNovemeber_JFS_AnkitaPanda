

public class Car extends Vehicle{
	int cost=7000;
	void carDetails()
	{
		int cost=5000;
		System.out.println("cost of car is"+cost);
		System.out.println("cost of car is"+this.cost);
		System.out.println("cost of car is"+super.cost);
		
		
	}
	

}
