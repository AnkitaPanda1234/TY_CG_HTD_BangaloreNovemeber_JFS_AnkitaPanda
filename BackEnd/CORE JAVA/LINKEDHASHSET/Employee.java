
public class Employee {
	
	int age;
	String name;
	public Employee(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	public String toString()
	{
		return "Employee[age="+age+"name is"+" "+name+" ]" ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	       }

	public boolean equals(Object obj)
	{
		Employee e1=(Employee) obj;
		if(age==this.age)
		{
			if(name==this.name)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		
		}
	
}
	
}
