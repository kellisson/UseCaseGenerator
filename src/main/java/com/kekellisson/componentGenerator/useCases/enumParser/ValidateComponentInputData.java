package com.kekellisson.componentGenerator.useCases.enumParser;

import java.util.List;

public class ValidateComponentInputData {
	
	private String enumPackage;
	private String enumName;
	private List<String> enumValuesList;
	
	public String getEnumPackage() {
		return enumPackage;
	}
	public void setEnumPackage(String enumPackage) {
		this.enumPackage = enumPackage;
	}
	public String getEnumName() {
		return enumName;
	}
	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}
	public List<String> getEnumValuesList() {
		return enumValuesList;
	}
	public void setEnumValuesList(List<String> enumValuesList) {
		this.enumValuesList = enumValuesList;
	}
	
}
