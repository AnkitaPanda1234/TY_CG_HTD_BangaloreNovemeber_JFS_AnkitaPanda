
public class Vehicle implements Cloneable {
	String name;

	public Vehicle(String name) {
		super();
		this.name = name;
	}
	
@Override
protected Object clone() throws CloneNotSupportedException {
	// TODO Auto-generated method stub
	return super.clone();
}
}
