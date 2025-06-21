package p;

public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodsDemo d= new MethodsDemo();
		String s = d.getData();
		System.out.println(s);
		MethodsDemo1 d1 = new MethodsDemo1();
		String s1 = d1.getUserData();
		System.out.println(s1);
		String s2 = getData1();
		System.out.println(s2);
	}	
	public String getData()
	{
		System.out.println("From Method getData");
		return "getData";
	}
	public static String getData1()
	{
		System.out.println("From Method getData1");
		return "getData1";
	}

}
