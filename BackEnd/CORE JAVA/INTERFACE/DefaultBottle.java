
public interface DefaultBottle {
	
	void open();
	void drink();
	static void close()
	{
		System.out.println("close Pepsi");
	}
	
	default void juice()
	{
		System.out.println("juice name is");
	}

}
