package factory.design.pattern.example1;

import org.junit.Test;


public class LoggerTest {
	
	@Test
	public void testLogger1(){
		Logger log = LoggerFactory.getlogger();
		log.debug("This is factory test");
		log.error("This is factory test");
	}
}
