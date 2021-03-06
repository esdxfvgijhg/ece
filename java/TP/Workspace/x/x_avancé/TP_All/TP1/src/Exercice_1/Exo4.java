package Exercice_1;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Exo4 {

	public static <T>void  insere (Collection<T> c1, Collection<? extends Collection <T>> c2){

		for(Collection<T> elm1:c2)
			for(T elm2:elm1)
				c1.add(elm2);
	}

	public static void main (String[] args){

		Collection <Integer> col1 = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4));
		Collection <Integer> col2 = new ArrayList<Integer>(Arrays.asList(5,6,7,8,9));
		Collection <Collection<Integer>> col3 = new ArrayList<Collection<Integer>>();

		col3.add(col2);
		insere(col1,col3);
		System.out.println(col1);

	} 
}
