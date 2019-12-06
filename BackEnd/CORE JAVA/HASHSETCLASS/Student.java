
public class Student {
	int studId;
	String studName;
	public Student(int studId, String studName) {
		super();
		this.studId = studId;
		this.studName = studName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studId;
		result = prime * result + ((studName == null) ? 0 : studName.hashCode());
		return result;
	}
	public boolean equals(Object obj)
	{
		Student s=(Student)obj;
		if(s.studId==this.studId)
		{
			if(s.studName==this.studName)
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
	
	


