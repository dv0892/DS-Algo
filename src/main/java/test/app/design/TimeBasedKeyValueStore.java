package test.app.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class TimeMap {

    Map<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,x -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timeStamp) {
    	TreeMap<Integer,String> timeBasedValues = map.get(key);
        if( timeBasedValues == null )
        	return "";
        
        Map.Entry<Integer,String> entryObj = timeBasedValues.floorEntry(timeStamp);

        return entryObj == null  ? "" : entryObj.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */