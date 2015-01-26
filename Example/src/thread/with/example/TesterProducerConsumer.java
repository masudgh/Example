package thread.with.example;

import org.junit.Test;


public class TesterProducerConsumer {
		
	/*public static void  main(String args[]){
        SyncThreadTest();
       // NonSyncThreadTest();
	}*/
	
	@Test
	public  void SyncThreadTest() throws InterruptedException{
		CubbyHole c1 = new CubbyHole();
		Producer prd = new Producer(c1, 1);
		Consumer cus = new Consumer(c1, 1);
        prd.start();
        cus.start();
        cus.join();
        prd.join();
	}
	
	@Test
	public  void NonSyncThreadTest() throws InterruptedException{
		CubbyHole c1 = new CubbyHole();
		NonSyncProducer prd = new NonSyncProducer(c1, 1);
		NonSyncConsumer cus = new NonSyncConsumer(c1, 1);
        prd.start();
        cus.start();
        cus.join();
        prd.join();
        
	}
	 
	 
}
