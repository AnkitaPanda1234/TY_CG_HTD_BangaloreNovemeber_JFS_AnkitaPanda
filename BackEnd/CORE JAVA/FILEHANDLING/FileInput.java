import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInput {
	public static void main(String[] args) {
		FileInputStream f1;
		try {
			f1 = new FileInputStream("abc.txt");
			//int a=f1.read();
			//System.out.println((char)a);
			int j=0;
			while((j=f1.read())!=-1)
			{
				System.out.print((char)j);
			}
		} 
		
		catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
