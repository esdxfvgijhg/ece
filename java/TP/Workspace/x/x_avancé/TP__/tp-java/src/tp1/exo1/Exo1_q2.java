package tp1.exo1;
import java.util.*;


public class Exo1_q2 {

	
	public static Collection<Collection> removeIfEmpty(Collection<Collection> list){
		Iterator<Collection> itt = list.iterator();
		while(itt.hasNext()){
			if (itt.next().isEmpty())itt.remove();
		}
		return null;
	}
	
	
	public static void main (String[] args){
		
		Collection<Integer> list1 = new ArrayList<Integer>(); list1.add(1);
		Collection<Integer> list2 = new ArrayList<Integer>(); list2.add(2);
		Collection<Integer> listEmpty = new ArrayList<Integer>();
		
		Collection<Collection> listOfLists= new ArrayList<Collection>(); 
		listOfLists.add(list1);
		listOfLists.add(list2);
		listOfLists.add(listEmpty);
		
		System.out.println(listOfLists);
	    
		Exo1_q2.removeIfEmpty(listOfLists);
		System.out.println(listOfLists);
		
	}

}

