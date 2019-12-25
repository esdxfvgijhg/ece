import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.*;
import static java.util.Comparator.*;

public class Exo8 {
	
  //Question 8
  
  public static Stream<Apple> randomApples (Farm origin) {
  	return generate(() -> new Apple(new Random().nextInt(1000),"Rouge",origin));
  }

  public static void main (String[] args) {
		Market m1 = new Market("Paris",3);
		Market m2 = new Market("Rome",3);
		Market m3 = new Market("London",3);
		Market m4 = new Market("Brest",3);

  	Farm f1 = new Farm ("Toto",3,12,new ArrayList<Market>(Arrays.asList(m1,m2,m3)));
  	Farm f2 = new Farm ("Diti",3,12,new ArrayList<>(Arrays.asList(m1,m2,m4)));
  	Farm f3 = new Farm ("Uutu",3,12,new ArrayList<>(Arrays.asList(m4,m2,m3)));

		Apple a1 = new Apple (2,"Black",f1);
		Apple a2 = new Apple (2,"Yellow",f1);
		Apple a3 = new Apple (2,"Red",f3);

		randomApples(f1).forEach(System.out::println);

  }    
}
