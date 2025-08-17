package javademo;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args)  {
		//HashSet treeset, LinkedHashset implements Set interface 
		//does not accept duplicate values  
		// There is no guarantee elements stored in sequential order..Random order 
		HashSet<String> hs = new HashSet<String>();
		hs.add("UK");
		hs.add("IND");
		hs.add("UK");
		System.out.println(hs);

		Iterator<String> i = hs.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}

	}

}
