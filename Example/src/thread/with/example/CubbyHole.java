package thread.with.example;

class CubbyHole {
    private int seq;
    private boolean available = false;
	public CubbyHole(){
		
	}
    
    public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}

    public synchronized int get() {
		    while (available == false) {
		    try {
			wait();
		    } catch (InterruptedException e) {
		    	e.printStackTrace();
		    }
		}
        available = false;
        notify();
        return seq;
    }

    public synchronized void put(int value) {
		while (available == true) {
		    try {
			wait();
		    } catch (InterruptedException e) {
		    }
		}
		seq = value;
	    available = true;
	    notify();
	}
    
}
