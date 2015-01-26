package treemap.hashmap.linkedhashmap.examples.example1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Tester {
	Message m1 =new Message(1235440, "some text1", 1);
	Message m2 =new Message(4567890, "some text2", 14);
	Message m3 =new Message(6543280, "some text3", 7);
	Message m4 =new Message(4567891, "some text4", 999);
	Message m5 =new Message(9087098, "some text5", 2);
	
	@Test
	public void test1(){ //Maintain the order of the k, as definend in the comparator
		TreeMapImp tm = new TreeMapImp();
		
		tm.add(m1, 1500);
		tm.add(m2, 100);
		tm.add(m3, 700);
		tm.add(m4, 99900);
		tm.add(m5, -100);
		
		tm.print();
		Message m = tm.getLastKey();
		assertEquals(1,m.getTime(),0);
		assertEquals("some text1",m.getText());
		assertEquals(1500,tm.get(m1),0);
		
		
	}
	
	@Test
	public void test2(){ //Does not maintained the any order
		HashMapImp hm = new HashMapImp();
		hm.add(m1, 1500);
		hm.add(m2, 100);
		hm.add(m3, 700);
		hm.add(m4, 99900);
		hm.add(m5, -100);
		
		hm.print();
	}
	
	@Test
	public void test3(){ //maintain the order of the k,v put
		LinkedHashMapImp lhm = new LinkedHashMapImp();
		lhm.add(m1, 1500);
		lhm.add(m2, 100);
		lhm.add(m3, 700);
		lhm.add(m4, 99900);
		lhm.add(m5, -100);
		
		lhm.print();
	}

}
