package Exercice_1;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class Exo5 {

	public static <T> void supprimer (Collection<? extends Comparable<T>> c, T max) {

			for(Iterator <? extends Comparable <T>> i=c.iterator();i.hasNext();){
				Comparable <T> elm = i.next();
				if (elm.compareTo(max)>0)
					i.remove();
			}
	}

	public static void main (String[] args){

		Collection <Integer> col = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
		supprimer(col,4);
		System.out.println(col);

	} 
}
