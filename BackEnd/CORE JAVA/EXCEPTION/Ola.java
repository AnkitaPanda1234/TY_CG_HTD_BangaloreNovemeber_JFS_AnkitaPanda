package throwkey;

public class Ola {
	GoogleMap g1;

	public Ola(GoogleMap g1) {
		super();
		this.g1 = g1;
	}
	void find(String a)
	{
		try
		{
			g1.findLocation(a);
		}
		catch(NullPointerException e)
		{
			System.out.println("ola user please fill the location");
			
		}
	}

}
