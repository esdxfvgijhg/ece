package tp2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Exo3 {
	public void setEntier (int entier){
		this.entier=entier;
		System.out.println(this.entier);
	}
	private int entier = 12;

	public static void main (String [] args) throws IllegalAccessException{
		Exo3 o = new Exo3();	
		Class <?> c = o.getClass();
		Method[] ms = c.getMethods();
		for (Method m:ms) {
			if (m.getName().startsWith("set") && 
				m.getParameterCount()==1 &&
				m.getParameterTypes()[0] == int.class) {
					o.setEntier(42);
			}
		}
	}
}
