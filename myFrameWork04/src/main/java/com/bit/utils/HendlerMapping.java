package com.bit.utils;

import java.util.HashMap;
import java.util.Map;

public class HendlerMapping {
	private static Map<String, BitController> map = new HashMap<String, BitController>();
	
	public static void setMap(String url, String value){
		try {
			Class<?> clzz = Class.forName(value);
			BitController controller=(BitController) clzz.newInstance();
			map.put(url, controller);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static BitController getMap(String url){
		return map.get(url);
	}
}
