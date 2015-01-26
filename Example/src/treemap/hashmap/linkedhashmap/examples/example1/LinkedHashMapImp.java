package treemap.hashmap.linkedhashmap.examples.example1;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LinkedHashMapImp {
	LinkedHashMap<Message, Integer> lhm;

	public LinkedHashMapImp() {
		super();
		lhm = new LinkedHashMap<Message, Integer>();
	}
	
	public void add(Message m, Integer value){
		lhm.put(m, value);
	}
	
	public void print(){ // it maintainted the order it put the k,v 
		System.out.println("Linked HashMap impementation....");
		for (Entry<Message, Integer> entry : lhm.entrySet()) {
		    Message key = entry.getKey();
		    Integer value = entry.getValue();

		    System.out.printf("%s : %s\n", key.getTime(), value);
		}
	}

}
