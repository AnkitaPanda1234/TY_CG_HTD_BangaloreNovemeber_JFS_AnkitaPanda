import java.util.TreeSet;

public class TreeSet3 {
     public static void main(String[] args) {
    	 EmployeeName em=new EmployeeName();
    	 EmployeeAge eg=new EmployeeAge();
    	 EmployeeSalary es=new EmployeeSalary();
    	 
    	 TreeSet<Employee> t1=new TreeSet<Employee>(es);
    	 
    	 t1.add(new Employee(22,56000,"Ankita"));
    	 t1.add(new Employee(23,26000,"sonu"));
    	 t1.add(new Employee(24,36000,"john"));
    	 for (Employee employee : t1) 
    	 {
    		 System.out.println("Employee name is"+employee.name);
    		 System.out.println("employee age is"+employee.age);
    		 System.out.println("employee salary is "+employee.salary);
    		 System.out.println(".......................");
			
		}
	
}
}
