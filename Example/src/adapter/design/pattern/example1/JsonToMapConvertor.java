package adapter.design.pattern.example1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

import factory.design.pattern.example1.Logger;
import factory.design.pattern.example1.LoggerFactory;

public class JsonToMapConvertor {
	private Logger log = LoggerFactory.getlogger();
	
	public Map<String,String> jsonToMap(JSONObject json){
		@SuppressWarnings("unchecked")
		Iterator<String> keys = json.keys();
		Map<String,String> valList= new HashMap<String,String>();
	    while(keys.hasNext()){
	        String key = keys.next();
	        String val = null;
	        try{
	             JSONObject value = json.getJSONObject(key);
	             val=value.toString();
	        }catch(Exception e){
	             val = json.getString(key);
	        }
	        if(val != null){
	            log.debug("Key value pairs are : "+key+" : "+val);
	            valList.put(key,val);
	        }
	    }
		return valList;
	}

}
