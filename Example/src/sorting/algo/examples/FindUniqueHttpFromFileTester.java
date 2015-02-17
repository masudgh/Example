package sorting.algo.examples;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class FindUniqueHttpFromFileTester {
	
	private FindUniqueHttpFromFile testObj;
	@Before
	public void init(){
		this.testObj = new FindUniqueHttpFromFile();
		
	}
	
	@Test
	public void testUniqueLines() throws IOException{
		this.testObj.setFilePath("C:/Users/poly/WorkspaceKepler/Example/resources/httpinput.txt");
		Set<String> unique =new HashSet<String>(this.testObj.fileReadAndGetUniqueLines());
		assertEquals(6,unique.size());
	};
	
	@Test
	public void testTotalLines() throws IOException{
		this.testObj.setFilePath("C:/Users/poly/WorkspaceKepler/Example/resources/httpinput.txt");
		List<String> alllines =new ArrayList<String>(this.testObj.fileReadAndGetAllLines());
		assertEquals(8,alllines.size());
	};
	
	@Test
	public void testFirstUniqueLine() throws IOException{
		this.testObj.setFilePath("C:/Users/poly/WorkspaceKepler/Example/resources/httpinput.txt");
		Integer firstOccurance =this.testObj.fileReadAndGetUniqueLinesWithLineNumber();
		
		
		
		assertEquals((Integer)5,firstOccurance);
	};

	@Test
	public void testFirstUniqueLine2() throws IOException{
		this.testObj.setFilePath("C:/Users/poly/WorkspaceKepler/Example/resources/httpinput.txt");
		int firstOccurance =this.testObj.findFirstUniqueLineNo();
		assertEquals(5,firstOccurance);
	};
}
