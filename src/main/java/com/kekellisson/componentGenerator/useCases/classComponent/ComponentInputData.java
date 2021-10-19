package com.kekellisson.componentGenerator.useCases.classComponent;

import java.util.List;
import java.util.Map;

public class ComponentInputData {

	private String packageName;	
	private String className;
	private List<String> fieldsName;
	private Map<String, String> fieldTypeMap;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<String> getFieldsName() {
		return fieldsName;
	}

	public void setFieldsName(List<String> fieldsName) {
		this.fieldsName = fieldsName;
	}

	public Map<String, String> getFieldTypeMap() {
		return fieldTypeMap;
	}

	public void setFieldTypeMap(Map<String, String> fieldTypeMap) {
		this.fieldTypeMap = fieldTypeMap;
	}
}
