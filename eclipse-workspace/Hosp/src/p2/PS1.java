package p2;

import org.testng.annotations.Test;

public class PS1 extends PS {

	@Test
	public void testRun() {
		doThis();
		PS2 ps2 = new PS2(3);//Have to create constructor in PS2 class
		System.out.println(ps2.increment());
		System.out.println(ps2.decrement());
		System.out.println(ps2.multiplyBy2());
	}

}
