package staticAndNonstatic;

public class TestQspider {

	public static void main(String[] args) {
		QSpider rajajinagar=new QSpider();
		rajajinagar.swipe();
		rajajinagar.swipe();
		QSpider BTM=new QSpider();
		BTM.swipe();
		
		System.out.println(rajajinagar.branchStudent);
		System.out.println(BTM.branchStudent);
		System.out.println(QSpider.totalStudent);
	}

}
