package thread.with.example;

class NonSyncConsumer extends Thread {
    private CubbyHole cubbyhole;
    private int number;

    public NonSyncConsumer(CubbyHole c, int number) {
	cubbyhole = c;
	this.number = number;
    }

    public void run() {
	int value = 0;
	for (int i = 0; i < 10; i++) {
	    value = cubbyhole.getSeq();
	    System.out.println("Consumer #" + this.number + " got: " + value);
	}
    }
}
