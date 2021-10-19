package com.kekellisson.componentGenerator.useCases.enumParser;

import java.util.List;
import java.util.Map;

public class EnumParserOutputData {

	private String packageName;
	private String enumName;
	private List<EnumItem> enumItemList;
	private Map<String, String> attributesMap;
	
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getEnumName() {
		return enumName;
	}
	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}
	public List<EnumItem> getEnumItemList() {
		return enumItemList;
	}
	public void setEnumItemList(List<EnumItem> enumItemList) {
		this.enumItemList = enumItemList;
	}
	public Map<String, String> getAttributesMap() {
		return attributesMap;
	}
	public void setAttributesMap(Map<String, String> attributesMap) {
		this.attributesMap = attributesMap;
	}
	
}
