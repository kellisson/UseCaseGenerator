package com.kekellisson.componentGenerator.useCases;

public class StringUtils {

	public static String snakeCase(String field) {
		String[] pieces = field.split("(?=\\p{Upper})");
		StringBuilder builder = new StringBuilder();
		builder.append(pieces[0]);
		for(int i = 1; i < pieces.length; i++) {
			builder.append("_").append(pieces[i]);
		}
		return builder.toString().toLowerCase();
	}
	
	public static String upperFirst(String field) {
		String capitalFirstLetter = field.substring(0, 1).toUpperCase();
		return capitalFirstLetter + field.substring(1);
	}
	
	public static String lowerFirst(String field) {
		String capitalFirstLetter = field.substring(0, 1).toLowerCase();
		return capitalFirstLetter + field.substring(1);
	}
	
	public static String splitWhenUpperCase(String field) {
		String[] pieces = field.split("(?=\\p{Upper})");
		StringBuilder builder = new StringBuilder();
		builder.append(pieces[0]);
		for(int i = 1; i < pieces.length; i++) {
			builder.append(" ").append(pieces[i]);
		}
		return builder.toString();
	}
	
}
