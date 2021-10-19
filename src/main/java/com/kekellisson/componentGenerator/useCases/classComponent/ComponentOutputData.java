package com.kekellisson.componentGenerator.useCases.classComponent;

import java.util.List;
import java.util.Map;

public class ComponentOutputData {

	private String packageName;
	private String className;
	private List<String> constantFieldName;
	private Map<String,String> constantFieldValue;
	private List<Parameter> parametersList;
	private List<String> importsList;
	
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
	public List<String> getConstantFieldName() {
		return constantFieldName;
	}
	public void setConstantFieldName(List<String> constantFieldName) {
		this.constantFieldName = constantFieldName;
	}
	public Map<String, String> getConstantFieldValue() {
		return constantFieldValue;
	}
	public void setConstantFieldValue(Map<String, String> constantFieldValue) {
		this.constantFieldValue = constantFieldValue;
	}
	public List<Parameter> getParametersList() {
		return parametersList;
	}
	public void setParametersList(List<Parameter> parametersList) {
		this.parametersList = parametersList;
	}
	public List<String> getImportsList() {
		return importsList;
	}
	public void setImportsList(List<String> importsList) {
		this.importsList = importsList;
	}
	
}
