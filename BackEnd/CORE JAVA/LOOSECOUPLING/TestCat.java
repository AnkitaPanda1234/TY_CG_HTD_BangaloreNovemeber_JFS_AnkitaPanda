
public class TestCat {

	public static void main(String[] args) {
		Cat c1=new Cat();
		 Chips c2=new Chips();
		 Lays l1=new Lays();
		 Kurkure k1=new Kurkure();
		 Bingo b1=new Bingo();
		 
		 c1.feedChips(k1);///loose coupling
		 
		// b1.feedChips(k1);   tight coupling

	}

}
