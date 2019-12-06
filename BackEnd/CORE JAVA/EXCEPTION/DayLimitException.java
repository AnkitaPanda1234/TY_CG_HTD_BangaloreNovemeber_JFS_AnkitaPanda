package customeunchecked;

public class DayLimitException extends RuntimeException {
	
	String msg="exceed amout ";

	public DayLimitException() {
		super();
	}

	public DayLimitException(String msg) {
		super();
		this.msg =msg;
	}
	 public String getMessage()
	 {
		 return this.msg;
	 }

}
