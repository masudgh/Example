package adapter.design.pattern.example1;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

public class JSONStringToMAPAdapterImp implements JSONStringToMAPAdapter {

	@Override
	public Map<String,String> convertJsonStrToMap(String jsonStr) {
		
		if( StringUtils.isNotBlank(jsonStr)){
			JSONObject jsonObj = new JSONObject(jsonStr);
			JsonToMapConvertor jm = new JsonToMapConvertor();
			return jm.jsonToMap(jsonObj);
		}
		return null;
	}

}
