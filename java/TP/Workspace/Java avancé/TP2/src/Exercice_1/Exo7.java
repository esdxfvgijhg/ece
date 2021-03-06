package Exercice_1;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.lang.reflect.Constructor;

public class Exo7 extends Super7{

	public static <T,S> boolean superClasse(T classe,S superClasse) throws Exception{

		Class <?> sc = classe.getClass();
		//Class <?> sc = c.getSuperclass();
		while (sc!=null){
			if(sc==superClasse.getClass())
				return true;
			sc=sc.getSuperclass();
		}
		return false;
	}

	public static <S,T> void ajout (Collection<S> c1, Collection<T> classe, S superClasse) throws Exception {
		for (T elm:classe)
			if (superClasse(elm,superClasse))
				c1.add((S)elm);
	}

	public static void main(String[] args) throws Exception {
		Exo7 o = new Exo7();
		Super7 s = new Super7();

		Collection <Super7> col1 = new ArrayList<Super7>();
		Collection <Object> col2 = new ArrayList<Object>();
		col2.add(3);
		col2.add("aghiles");
		col2.add(o);

		ajout(col1,col2,s);
		System.out.println(col1);
	}
}
