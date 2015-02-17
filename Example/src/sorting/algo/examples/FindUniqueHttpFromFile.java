package sorting.algo.examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class FindUniqueHttpFromFile {
	private String filePath;
	
	
	public FindUniqueHttpFromFile() {
		super();
	}
	

	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public Set<String> fileReadAndGetUniqueLines() throws IOException{
		BufferedReader br = null;
        String strLine = "";
        Set<String> unique =new HashSet<String>();
        try {
            br = new BufferedReader( new FileReader(this.filePath));
            while((strLine = br.readLine()) != null){
                unique.add(strLine);
            	System.out.println(strLine);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find the file: fileName");
        } catch (IOException e) {
            System.err.println("Unable to read the file: fileName");
        }finally{
        	br.close();
        }
        return unique;
	}
	public Integer fileReadAndGetUniqueLinesWithLineNumber() throws IOException{
		BufferedReader br = null;
        String strLine = "";
        Integer i;
        Map<String,Integer> unique =new HashMap<String,Integer>();
        Set<String> duplicates = new HashSet<String>();
        try {
            br = new BufferedReader( new FileReader(this.filePath));
            i=1;
            
            while((strLine = br.readLine()) != null){
               
                if(unique.containsKey(strLine)){
                	duplicates.add(strLine);
                }
                unique.put(strLine,i);
                
            	System.out.println(strLine+" Line No "+i);
            	i++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find the file: fileName");
        } catch (IOException e) {
            System.err.println("Unable to read the file: fileName");
        }finally{
        	br.close();
        }
        

        Iterator<Map.Entry<String,Integer>> iter = unique.entrySet().iterator();
        while (iter.hasNext()) {
        	Map.Entry<String,Integer> ent = iter.next();
			if(duplicates.contains(ent.getKey()))
			{
				iter.remove();
			}
		}
        
        Integer minLineNo;
        Iterator<Map.Entry<String,Integer>> iter2 = unique.entrySet().iterator();
        Map.Entry<String,Integer> ent = iter2.next();
        minLineNo = ent.getValue();
        while (iter2.hasNext()) {
        	 
        	 ent = iter2.next();
        	 Integer tmp =ent.getValue();
        	 if(tmp<=minLineNo)
        		 minLineNo=tmp;
		}
        
        return minLineNo;
        
     
	}
	
	
	public List<String> fileReadAndGetAllLines() throws IOException{
		List<String> allline = new ArrayList<String>();
		BufferedReader br = null;
        String strLine = "";
       
        try {
            br = new BufferedReader( new FileReader(this.filePath));
            while((strLine = br.readLine()) != null){
            	allline.add(strLine);
                System.out.println(strLine);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find the file: fileName");
        } catch (IOException e) {
            System.err.println("Unable to read the file: fileName");
        }finally{
        	br.close();
        }
        return  allline;
	}
	
	private class  lineObj{
		
		private int lineNo;
		private int count;
		public lineObj(int lineNo) {
			super();
			this.lineNo = lineNo;
		}
		public void addCount(){
			count++;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public int getLineNo() {
			return lineNo;
		}
		

	}
	
	public int findFirstUniqueLineNo() throws IOException{
		
		
		BufferedReader br = null;
        String strLine = "";
        Map<String,lineObj> unique =new HashMap<String,lineObj>();
        Integer lineNo = 0;
        try {
            br = new BufferedReader( new FileReader(this.filePath));
            lineNo=1;
            while((strLine = br.readLine()) != null){
            	if(unique.containsKey(strLine)){
            		unique.get(strLine).addCount();
            	}else{
	            	lineObj lo = new lineObj(lineNo);
	            	lo.setCount(1);
	                unique.put(strLine,lo);
            	}
            	lineNo++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find the file: fileName");
        } catch (IOException e) {
            System.err.println("Unable to read the file: fileName");
        }finally{
        	br.close();
        }

        int returnLineNo=0;
        Iterator<Entry<String, lineObj>> iter = unique.entrySet().iterator();
        while(iter.hasNext()){
        	Entry<String, lineObj> ent = iter.next();
        	lineObj lo = ent.getValue();
			if(lo.getCount()==1){
				returnLineNo=ent.getValue().getLineNo();
				break;
			}
        }
	
        while (iter.hasNext()) {
        	Entry<String, lineObj> ent = iter.next();
        	lineObj lo = ent.getValue();
			if(lo.getCount()==1)
			{
				if(returnLineNo> lo.getLineNo()){
					returnLineNo=lo.getLineNo();
				}
			}
		}
		return  returnLineNo;
	}
}

 
