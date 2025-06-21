package p;

import java.util.ArrayList;

public class Learn2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList a = new ArrayList();
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("Selenium");
		a1.add("Selenium1");
		a1.add("Selenium2");
		a1.add("Selenium3");
		a1.add("Selenium4");	
		a1.add("Selenium5");
		//a1.remove(0);
		
		for (int i=0;i<a1.size();i++) 
		{	
			System.out.println( a1.get(i));
		}
		System.out.println("=================================");
		for (String val:a1) //Enhanced for loop
		{
			System.out.println(val);
		}
		System.out.println(a1.contains("Selenium"));
		System.out.println(a1.isEmpty());
	}
}
