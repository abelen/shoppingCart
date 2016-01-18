package shoppingCart;

import org.json.simple.JSONValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anthonybelen on 1/18/16.
 */
public class ResponseParseFactory {

    public String getFailureJsonString(String msg) {
        String jsonString = "";
        Map list = new HashMap();
        list.put("response_status", "false");

        list.put("result", msg+"");
        jsonString = JSONValue.toJSONString(list);
        return jsonString;
    }

    public String getSuccessJsonString(String msg) {
        String jsonString = "";
        Map map = new HashMap();
        map.put("response_status", "true");

        map.put("result", msg);
        jsonString = JSONValue.toJSONString(map);
        return jsonString;
    }
}