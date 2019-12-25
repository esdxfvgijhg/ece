import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Collection;

abstract class Fruit implements Comparable<Fruit> {
	protected String name;
	protected int size;

	protected Fruit(String name, int size) {
		this.name = name; this.size = size;
	}

	public boolean equals(Object o) {
		if (o instanceof Fruit) {
			Fruit that = (Fruit)o;
			return this.name.equals(that.name) && this.size == that.size;
		}else 
			return false;
	}

	public int hashCode() {
		return name.hashCode()*29 + size;
	}

	public int compareTo(Fruit that) {
		return this.size < that.size ? - 1 :
			this.size == that.size ? 0 : 1 ;
	}
}
	class Apple extends Fruit {
		public Apple(int size) { 
			super("Apple", size); 
		}
	}

	class Orange extends Fruit {
		public Orange(int size) { 
			super("Orange", size); 
		}
	}

	class Test {
		public static void main(String[] args) {
			Apple a1 = new Apple(1); Apple a2 = new Apple(2);
			Orange o3 = new Orange(3); Orange o4 = new Orange(4);
			List<Apple> apples = Arrays.asList(a1,a2);
			System.out.println(Collections.max(apples).equals(a2));
			List<Orange> oranges = Arrays.asList(o3,o4);
			System.out.println(Collections.max(oranges).equals(o4));
			List<Fruit> mixed = Arrays.<Fruit>asList(a1,o3);
			System.out.println(Collections.max(mixed).equals(o3));
		}
	}