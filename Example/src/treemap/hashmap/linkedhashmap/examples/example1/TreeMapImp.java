package treemap.hashmap.linkedhashmap.examples.example1;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapImp  {
	
	TreeMap <Message,Integer> tm;

	public TreeMapImp() {
		super();
		this.tm = new TreeMap <Message,Integer>(
	            new Comparator<Message>() {
	                @Override
	                public int compare(Message e1, Message e2) {
	                    return e2.getTime() - e1.getTime();
	                }
	            });
	}
	
	public void add(Message m,Integer value){
		tm.put(m, value);
	}
	
	public Set<Message> getKeys(){
		return tm.keySet();
	}
	
	public Integer get(Message m){
		return tm.get(m);
	}

	public Integer getTimeForValue(Message m){
		return tm.get(m);
	}
	public Message getLastKey(){
		return tm.lastKey();
	}
	public void print(){
		 System.out.println("TreeMap impementation....");
		for (Entry<Message, Integer> entry : tm.entrySet()) {
		    Message key = entry.getKey();
		    Integer value = entry.getValue();

		    System.out.printf("%s : %s\n", key.getTime(), value);
		}
	}
}
