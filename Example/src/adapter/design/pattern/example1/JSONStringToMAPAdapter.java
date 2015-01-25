/**
 * 
 */
package adapter.design.pattern.example1;

import java.util.Map;



/**
 * @author masudgh
 *
 */
public interface JSONStringToMAPAdapter {
	/**
	 * 
	 * @param jsonStr
	 * @return
	 */
	 
	public Map<String,String> convertJsonStrToMap(String jsonStr);

}
