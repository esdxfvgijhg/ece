package Exercice_1;

import java.lang.reflect.Constructor;

public class Exo5 extends Super5 {

	public static void firstSuperClass(Object o) throws Exception{

		boolean b = false;
		Class <?> c = o.getClass();
		
		Class <?> sc= c.getSuperclass();
		while (sc!=null && b==false){
			//System.out.println(sc.getName());
			Constructor<?>[] cons = sc.getConstructors();
			for (Constructor<?> con:cons){
				if(con.getParameterCount()==0){
					System.out.println(con.getName());
					sc.newInstance();
					b=true;
				}
			}
			sc=sc.getSuperclass();
		}
	}

	public static void main (String [] args) throws Exception {
		Exo5 o = new Exo5();
		firstSuperClass(o);
	}
}
