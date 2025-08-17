package javademo;

public class Palindrome {

	public static void main(String[] args) {
		String name = "madam";
		String rName = "";

		for (int i = name.length() - 1; i >= 0; i--) {
			rName = rName+name.charAt(i);
		

		}
		System.out.println("Reversed name for "+name+" is "+rName);
		if(rName.equals(name)) {
			System.out.println(name+" is a Palindrome");
		}
		else {
			System.out.println(name+" is not a Palindrome");
		}
	}
}
