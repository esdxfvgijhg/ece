package EatBreakfastTemplateWithHook;

public class EatBreakfastTemplateWithHook {
	public static void main(String[] args) {

		AbstractBreakaFastWithHook temp1 = new Omelette();
		temp1.templateMethod(2);

		System.out.println("");		

		AbstractBreakaFastWithHook temp2 = new SunnySide();
		temp2.templateMethod(3);

		System.out.println("");
		

		AbstractBreakaFastWithHook temp3 = new ScrambledEggs();
		temp3.templateMethod(1);
	}
}
