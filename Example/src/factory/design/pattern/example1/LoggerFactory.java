package factory.design.pattern.example1;

import java.io.IOException;

public class LoggerFactory {
	private static Logger log =null;
	public static Logger getlogger(){
		try{
			log =new FileLogger();
		}catch(IOException e){
			log =new ConsoleLogger();
		}
		
		return log;
	}
}
