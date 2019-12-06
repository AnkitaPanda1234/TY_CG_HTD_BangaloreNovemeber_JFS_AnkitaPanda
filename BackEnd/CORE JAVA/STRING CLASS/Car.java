
/*public class Car {
	Vehicle v1=()-> {   // with out parameter syntax
		System.out.println("car is moving");
		
	};

} */


/*public class Car{
	Vehicle v1=a -> {
		System.out.println("car is moving");
	};
   }      with one parameter      */

public class Car
{
	Vehicle v1=(a,b)->
	{
	System.out.println("car is moving");	
	}; // with two parameter
}
