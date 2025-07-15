package javademo;

import java.util.ArrayList;

public class Final {

	public static void main(String[] args) {
		//if we declare variable as final we cannot change it
		//if we make class as final we cannot extend it
		
		final int i = 1;
		//i=2;
		
	    ArrayList<String> a = new ArrayList<String>();
        a.add("apple");
        a.add("banana");
        a.add("cherry");
        a.add("mango");
        a.add("apple");
        
        System.out.println(a);
		

	}

}
