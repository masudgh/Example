package factory.design.pattern.example1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements Logger {
	
	private PrintWriter pw;
	FileLogger () throws IOException{
		 pw = new PrintWriter(new FileWriter("resources/out.log" ) );
	}
	@Override
	public void debug(String msg) {
		// TODO Auto-generated method stub
		 pw.println("DEBUG: "+ msg);
		 pw.flush();
	}

	@Override
	public void error(String msg) {
		// TODO Auto-generated method stub
		 pw.println("ERROR: "+ msg);
		 pw.flush();
		
	}

}
