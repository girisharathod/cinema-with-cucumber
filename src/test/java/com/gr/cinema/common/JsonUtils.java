package com.gr.cinema.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {

	public static String toJsonString(Object obj) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(obj);
	}
	
	public static <T> T fromJsonStr(String jsonStr, Class<T> genClass){
		return new Gson().fromJson(jsonStr, genClass);
	}
	
}
