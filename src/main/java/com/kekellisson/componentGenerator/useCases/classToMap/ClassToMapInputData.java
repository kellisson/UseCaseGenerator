package com.kekellisson.componentGenerator.useCases.classToMap;

import java.util.List;
import java.util.Map;

public class ClassToMapInputData {

	private String className;
	
	private String packageName;
	
	private Map<String, List<String>> componentsDataMap;
	
	private Map<String, Map<String, String>> componentsParametersTypeMap;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Map<String, List<String>> getComponentsParametersMap() {
		return componentsDataMap;
	}

	public void setComponentsDataMap(Map<String, List<String>> componentsDataMap) {
		this.componentsDataMap = componentsDataMap;
	}

	public Map<String, Map<String, String>> getComponentsParametersTypeMap() {
		return componentsParametersTypeMap;
	}

	public void setComponentsParametersTypeMap(Map<String, Map<String, String>> componentsParametersTypeMap) {
		this.componentsParametersTypeMap = componentsParametersTypeMap;
	}

	public Map<String, List<String>> getComponentsDataMap() {
		return componentsDataMap;
	}
	
	
}
