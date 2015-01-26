package thread.with.example;

import org.junit.Test;


public class Tester {
	
	
	@Test
	public void Test1() {
		//Use thread extentend method		
			new SimpleThread("WPB").start();
	        new SimpleThread("Austin").start();
	        new SimpleThread("Bentonville").start();
	    }
	
	@Test
	public void Test2() {
		SimpleRunableThread thread1 = new SimpleRunableThread ( "WPB");
		SimpleRunableThread thread2 = new SimpleRunableThread ( "Bentonville");
		new Thread(thread1).start ( );
		new Thread(thread2).start ( );
	}
	
}
