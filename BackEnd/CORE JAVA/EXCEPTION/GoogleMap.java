package throwkey;

public class GoogleMap {
	void findLocation(String loc)
	{
		try
		{
			System.out.println(loc.length());
		}
		catch(NullPointerException n)
		{
			System.out.println("google please fill the location name");
			throw n;
		}
	}

}
