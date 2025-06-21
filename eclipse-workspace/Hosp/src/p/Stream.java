package p;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> names = new ArrayList<String>();
		names.add("rama");
		names.add("sam");
		names.add("dan");
		names.add("josh");
		names.add("ann");

		// names.stream().filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//String[] names1 = { "alok", "arun", "bharath", "varun", "harish", "bramha", "aaa" };
		//List<String> names2 = Arrays.asList(names1);
		// names2.stream().filter(s->s.startsWith("a")).sorted().forEach(s->System.out.println(s));
		//names2.stream().filter(s -> s.length() > 4).limit(2).forEach(s -> System.out.println(s));

		List<Integer> values = Arrays.asList(91, 2, 42, 3, 64, 3, 58, 6, 5, 6, 04, 7 );
		
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
		
			
			

		}

	
}
