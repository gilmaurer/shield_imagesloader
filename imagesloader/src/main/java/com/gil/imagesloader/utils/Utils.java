package com.gil.imagesloader.utils;

import java.net.URL;

public class Utils {

	private static final String PATH = "C:\\temp\\images\\";
	
	public static String StringtoJsonString(String res, String key) {
		StringBuilder sb = new StringBuilder();
		sb.append("{").append("\"" + key + "\": ").append(res).append("}");
		return sb.toString();
	}

	public static String formatDestinition(String imageUrl, String title) {
		String type = imageUrl.substring(imageUrl.lastIndexOf("."));
		String fileName = title.trim().replaceAll(" ", "_");
		StringBuilder sb = new StringBuilder();
		sb.append(PATH).append(fileName).append(type);
		return sb.toString();
	}

}
