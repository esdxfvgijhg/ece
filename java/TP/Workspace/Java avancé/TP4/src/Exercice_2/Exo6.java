package Exercice_2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exo6 {

	public static void exo () {
		//LongStream s = LongStream.generate(System::nanoTime);
  	IntStream entiers = IntStream.iterate(0,x -> x+1);
  	//Stream<BigInteger> pairs = Stream.iterate(BigInteger.ZERO, x -> BigInteger.valueOf(x).add(2)); 
  	Stream<BigInteger> pairs = Stream.iterate(BigInteger.ZERO, BigInteger.valueOf(2)::add);
  	Stream<BigInteger> pairs1000 = pairs.limit(1000);
  	//pairs1000.forEach(System.out::println);
  	//pairs1000.forEach(x -> {System.out.print(x+" ");});
  	entiers.limit(100).mapToObj(String::valueOf).forEach(System.out::println);
		//entiers.limit(100).forEach(System.out::println);
  	//entiers.map(x -> x*3).limit(100).mapToObj(String::valueOf).forEach(System.out::println);
	}

  public static void main(String[] args) {

	  Stream<BigInteger> impairs = Stream.iterate(BigInteger.ONE, BigInteger.valueOf(2)::add);
	  Stream<BigInteger> premiers = impairs.filter(x-> x.isProbablePrime(1)).limit(10);
	  premiers.forEach(System.out::println);

	  //BigInteger somme = premiers.reduce(BigInteger.ZERO,BigInteger::add);
		//System.out.println(somme);

  }
}
