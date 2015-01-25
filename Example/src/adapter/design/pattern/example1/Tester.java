package adapter.design.pattern.example1;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class Tester {
	
	@Test
	public void test1(){
		String str = "{\"name\":\"some name\", \"address\":200 klbj road, \"state\":TX}";
		
		JSONStringToMAPAdapterImp testObj = new JSONStringToMAPAdapterImp();
		HashMap <String,String>testMap= new HashMap <String,String>(testObj.convertJsonStrToMap(str));
		assertEquals("some name",testMap.get("name"));
		assertEquals("200 klbj road",testMap.get("address"));
		assertEquals("TX",testMap.get("state"));
	}
	@Test
	public void test2(){
		String str = null;
		
		JSONStringToMAPAdapterImp testObj = new JSONStringToMAPAdapterImp();
		assertEquals(null,testObj.convertJsonStrToMap(str));
		
	}

}
