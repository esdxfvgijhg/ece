package Exercice_1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;
import java.util.stream.LongStream;

public class Exo5 {

	public static void créer_flux(){

		Stream<Long> stream = Stream.generate(System::nanoTime).limit(10);
		Long[] strArr = stream.toArray(Long[]::new);
		System.out.println(Arrays.toString(strArr));

		//LongStream b = LongStream.generate(()->{return System.nanoTime();});
    //b.forEach(System.out::println);

  }

  public static void main(String[] args) {
		créer_flux();
  }
}
