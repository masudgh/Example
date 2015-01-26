package treemap.hashmap.linkedhashmap.examples.example1;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapImp {
	HashMap<Message, Integer> hm ;

	public HashMapImp() {
		super();
		// TODO Auto-generated constructor stub
		hm = new HashMap<Message, Integer>();
	}
	
	public void add(Message m,Integer value){
		hm.put(m, value);
	}
	
	public void print(){ //HashMap does not return the key the order it inserted the key, values
		System.out.println("HashMap impementation....");
		for (Entry<Message, Integer> entry : hm.entrySet()) {
		    Message key = entry.getKey();
		    Integer value = entry.getValue();

		    System.out.printf("%s : %s\n", key.getTime(), value);
		}
	}

}
