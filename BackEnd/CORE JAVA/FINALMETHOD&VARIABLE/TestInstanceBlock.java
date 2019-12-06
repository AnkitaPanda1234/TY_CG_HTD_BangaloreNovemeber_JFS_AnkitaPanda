
public class TestInstanceBlock {

	public static void main(String[] args) {
		InstanceBlock ib=new InstanceBlock();
	      System.out.println(ib.Maximum);
	      
	      System.out.println(InstanceBlock.PI);
	      System.out.println(".................");/////instance block executed first before constructor
	      InstanceBlock i2=new InstanceBlock(23);
	      System.out.println(i2.Maximum);
	      
	      
	      
	}

}
