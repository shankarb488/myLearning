package javademo;

public class StaticKeyword {

	String name;// instance variables
	String Address;// instance variables
	static String City = "Bengaluru";// class variables
	// if its static then all the objects will share the variable
	static int i = 0;
	int j = 0;

	StaticKeyword(String name, String Address) {// local variables
		this.name = name;// this refers to current class
		this.Address = Address;
		i++;
		j++;
		System.out.println(i);
		System.out.println(j);

	}

	public void getAddress() {
		System.out.println(Address + " " + City);

	}

	public static void getCity() {
		System.out.println(City);
		// Static methods only accepts static Variables

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticKeyword sk = new StaticKeyword("Bob", "Marthalli");
		StaticKeyword sk1 = new StaticKeyword("Ram", "Jalahalli");
		sk.getAddress();
		sk1.getAddress();
		StaticKeyword.getCity();//Without object we can call static method

	}

}
