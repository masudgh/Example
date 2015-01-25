package builder.design.pattern.example1;

import org.junit.Test;

import factory.design.pattern.example1.Logger;
import factory.design.pattern.example1.LoggerFactory;
import builder.design.pattern.example1.User.UserBuilder;

public class BuilderTest {
	private Logger log = LoggerFactory.getlogger();
	
	@Test
	public void testUserbuild1(){
		User user = new UserBuilder("test", "user1", "1234567890")
					.withAddress("fake address 1234")
					.withAge(40)
					.withPhone("111-111-2222")
					.build();
		System.out.println(user);
		log.debug(user.toString());		
	}

}
