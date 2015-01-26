package thread.with.example;

public class SimpleRunableThread implements Runnable {

	
	String threadName;
	public SimpleRunableThread() {
	}
	public SimpleRunableThread(String str) {
		 threadName  = new String (str); // (1) Create a new thread.
	}
	public void run() {
	
		for (int i = 0; i < 10; i++) {
		    System.out.println(i + " " + this.threadName);
	            try {
			Thread.sleep((int)(Math.random() * 1000));
		    } catch (InterruptedException e) {}
		}
		System.out.println("DONE! " +  this.threadName);
	    
	
	}
}
