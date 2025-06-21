package p;

public class Learn3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String literal - if string is same then new object will not create
		String s = ("Indian Cricket Team");
		String s1 = ("Indian Cricket");
		//New keyword was of creating string where every time its create object 
		String s2 = new String("Indian Hockey");
		String s3 = new String("Indian Hockey");
		
		String[] SplittedString = s.split("Cricket");
		
		System.out.println(SplittedString[0]);
		System.out.println(SplittedString[1]);
		//System.out.println(SplittedString[2]);
		System.out.println(SplittedString[1].trim());

	}

}
