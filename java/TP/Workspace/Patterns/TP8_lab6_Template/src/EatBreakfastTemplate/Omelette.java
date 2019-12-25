package EatBreakfastTemplate;

public class Omelette extends AbstractBreakaFast {
	public void crackEggs(int numOfEggs) {
		System.out.println("Cracking " + numOfEggs +  " eggs");
	}
	
	public void prepare() {
		System.out.println("Stirring the eggs");
	}
	
	public void cook() {
		System.out.println("Flipping the omelette while cooking");
	}

}
