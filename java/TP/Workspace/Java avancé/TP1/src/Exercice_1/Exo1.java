package Exercice_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Arrays;

public class Exo1 {

	public static void supprimer_paire (List<?> l) {

		boolean b = false;
		for(Iterator <?> i=l.iterator();i.hasNext();i.next()){
			if (b)
				i.remove();
			b=!b;
		}
	}

	public static void main (String[] args){

		List <Integer> l= new ArrayList <> (Arrays.asList(0,1,2,3,4,5));

		System.out.println(l);
		supprimer_paire(l);
		System.out.println(l);
	} 
}
