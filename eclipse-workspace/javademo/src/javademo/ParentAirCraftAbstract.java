package javademo;

public abstract class ParentAirCraftAbstract {

	public void engine() {
		System.out.println("FOllow Engine Guidelines");

	}

	public void safetyGuideLines() {
		System.out.println("FOllow Engine safetyGuideLines");

	}

	public abstract void bodyColor();// if any method is abstract then class also should be abstract
	/* Abstract methods (without a body)
	// Concrete methods (with implementation)
	// if the class is created by abstract the it will not allow to instastaniate
	// the or create object
	// Private access modifier is not allowed
	Interface
	1) Interface contains only abstract methods	
	2) Access Specifiers for methods in interface must be public
	3) Variables defined must be public, static, final
	4) To implement an interface we use implements keyword
	Abstract Class
	1) Abstract class can contain abstract methods, concrete methods, or both
    2) Except private, we can have any access specifier for methods in abstract class
    3) Except private, variables can have any access specifiers
    4) To implement an interface we use Extends keyword */
}
