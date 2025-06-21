package p;

public class Learn4 {
	public static void main(String[] args) {
		 
		String s2 = new String("Indian Hockey");
	
		
		for (int i=0; i<s2.length();i++)
		{
			System.out.println(s2.charAt(i));
		}
		
		System.out.println("=================================");
		//System.out.println(s2.length());
		
		for(int j=s2.length()-1;j>=0;j--)
		{
			System.out.println(s2.charAt(j));
		}

	}

}
