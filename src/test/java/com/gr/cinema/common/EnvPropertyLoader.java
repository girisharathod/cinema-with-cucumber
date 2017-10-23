package com.gr.cinema.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnvPropertyLoader {
	
	@Autowired
	Properties envProperties; 

	
	public Map<String,String> getEnvMap(){
		
		Set<Entry<Object, Object>> entrySet = envProperties.entrySet();
		
		Map<String, String> envMap = new HashMap<String,String>();
		
		for(Entry<Object,Object> entry : entrySet) {
			//System.out.println("Key - "+entry.getKey()+" : Value "+entry.getValue());
			if (entry.getKey() != null && entry.getValue() != null){
				envMap.put(entry.getKey().toString(), entry.getValue().toString());
			}			
		}
		return  envMap;
	}
	
}


