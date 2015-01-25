package factory.design.pattern.example1;

public class ConsoleLogger implements Logger{

	ConsoleLogger(){}
	
	@Override
	public void debug(String msg) {
		// TODO Auto-generated method stub
		System.out.println("DEBUG: "+ msg);
		
	}

	@Override
	public void error(String msg) {
		// TODO Auto-generated method stub
		System.out.println("ERROR: "+ msg);
	}

}
