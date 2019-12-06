
public class InstanceBlock {
	
	final int Maximum;
	static final double PI;
	public InstanceBlock()
	{
		System.out.println("constructor is executed");
	}
	public InstanceBlock(int a)
	{
		System.out.println("constructor is overloaded");
	}
	/////through IIB(instance initializer block)
 
	{
		System.out.println("instance block is executed");
		this.Maximum=2000;
	}
	////SIB(static initializer block which execute first)
	static{
		System.out.println("static block is executed");
		PI=3.14;
	}
}
