
public class TestVehicle {
	public static void main(String[] args) throws CloneNotSupportedException {
		Vehicle v1=new Vehicle("benz");
		Object o1=v1.clone(); //create object using clone()
		
		Vehicle v2=(Vehicle) o1; //downcast to vehicle 
		System.out.println(v2.name);
	}

}
