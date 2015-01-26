package treemap.hashmap.linkedhashmap.examples.example1;



public class Message  {

	private int id;
	private String text;
	private int time;
	
	public Message(int id, String text, int time) {
		super();
		this.id = id;
		this.text = text;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public int getTime() {
		return time;
	}

	//@Override
	//public int compareTo(Message m) {
	//	return this.time - m.getTime();
	//}
	
	

}
