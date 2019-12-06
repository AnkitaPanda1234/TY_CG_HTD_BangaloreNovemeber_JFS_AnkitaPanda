import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutput {
	public static void main(String[] args) {
		try {
			FileOutputStream f1=new FileOutputStream("abc.txt");
			String s="Ankita Panda";
			byte[]b=s.getBytes();
			f1.write(b);
			System.out.println("sucess........");
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
