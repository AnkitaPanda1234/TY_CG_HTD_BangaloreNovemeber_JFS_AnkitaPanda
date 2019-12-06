
public class TestAnimal {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Dog d1=new Dog("pinly");
		Class c1=d1.getClass();
		Dog d2=(Dog)c1.newInstance(); // create object by using newInstance() which is present in class
		System.out.println(c1);  //Class keyword with Class Name in getClass()
		System.out.println(d2.name); // gives default value
		
		
		Class c2=Class.forName("Dog"); //search which class u want to find
		System.out.println(c2); // print class with class name  which == getClass()
		
		                            
	}

}
