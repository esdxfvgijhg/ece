import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Collection;

public class Wildcards {

	public static <T> void copy(List<? super T> dst, List<? extends T> src) {
		for (int i = 0; i < src.size(); i++) {
			dst.set(i, src.get(i));
		}
	}

	public static double sum(Collection<? extends Number> nums) {
		double s = 0.0;
		for (Number num : nums) s += num.doubleValue();
		return s;
	}

	public static <T extends Comparable<T>> T max(Collection<T> coll) {
		T candidate = coll.iterator().next();
		for (T elt : coll) {
			if (candidate.compareTo(elt) < 0) candidate = elt;
		}
		return candidate;
	}

	public static void main(String[] args) {
/*
		List<Number> nums = new ArrayList<Number>();
		nums.add(2);
		nums.add(3.14);
		assert nums.toString().equals("[2, 3.14]");
		System.out.println(nums);

		List<Number> nums = new ArrayList<Number>();
		List<Integer> ints = Arrays.asList(1, 2);
		List<Double> dbls = Arrays.asList(2.78, 3.14);
		nums.addAll(ints);
		nums.addAll(dbls);
		assert nums.toString().equals("[1, 2, 2.78, 3.14]");		
		System.out.println(nums);


		List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
		List<Integer> ints = Arrays.asList(5, 6);
		copy(objs, ints);
		System.out.println(objs);
		Wildcards.<Object>copy(objs, ints);
		System.out.println(objs);
		Wildcards.<Number>copy(objs, ints);
		System.out.println(objs);
		Wildcards.<Integer>copy(objs, ints);
		System.out.println(objs);

		List<Integer> ints = Arrays.asList(1,2,3);
		assert sum(ints) == 6.0;
		System.out.println(sum(ints));
		List<Double> doubles = Arrays.asList(2.78,3.14);
		assert sum(doubles) == 5.92;
		System.out.println(sum(doubles));
		List<Number> nums = Arrays.<Number>asList(1,2,2.78,3.14);
		assert sum(nums) == 8.92;
		System.out.println(sum(nums));

		Number x=null;
		Integer y=null;
		x=y;

		List<Number> n=null;
		List<Integer> i=null;
		//i=n;

		List<Number> ints1 = Arrays.asList(1,2,3);
		List<? super Integer> nums1 = ints1;
		System.out.println(nums1.set(2, 5));//on peut ecrire
		System.out.println(nums1.get(2));//on peut lire

		List<Integer> ints2 = Arrays.asList(1,2,3);
		List<? extends Number> nums2 = ints2;
		System.out.println(nums2.get(2));//on peut que lire

		Object obj = "one";
		List<Object> objs = Arrays.<Object>asList("one", 2, 3.14, 4);
		List<Integer> ints = Arrays.asList(2, 4);
		System.out.println(objs.contains(obj));
		System.out.println(objs.containsAll(ints));
		System.out.println(!ints.contains(obj));
		System.out.println(!ints.containsAll(objs));

		List list = new ArrayList();
		list.add(2);
		list.add("aghiles");
		System.out.println(list);
*/		

	}
}
