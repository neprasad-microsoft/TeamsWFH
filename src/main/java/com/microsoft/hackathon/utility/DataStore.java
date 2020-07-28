package com.microsoft.hackathon.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.microsoft.model.KeyValuePair;

public class DataStore {
	
	public static Map<String,String> dataStore= new HashMap<String,String>();
	
	public static void storeData( List<KeyValuePair> keyValuePairList)
	{
		for(KeyValuePair kv:keyValuePairList)
		{
			dataStore.put(kv.key, kv.value);
		}
		
	}
	
	public static String getDataFromDataStore( String key)
	{
		
		return dataStore.get(key);
	}

}
