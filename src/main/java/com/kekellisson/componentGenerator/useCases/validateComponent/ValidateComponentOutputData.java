package com.kekellisson.componentGenerator.useCases.validateComponent;

import java.util.List;

public class ValidateComponentOutputData {

	private String className;
	private String packageName;
	private String exceptionClassName;
	private String exceptionTemplateMessage;
	private String validationMethodName;
	
	private List<String> importList;
	private List<ValidationComponentOutputData> validationMethodList;
	
	public String getExceptionClassName() {
		return exceptionClassName;
	}
	public void setExceptionClassName(String exceptionClassName) {
		this.exceptionClassName = exceptionClassName;
	}
	public String getExceptionTemplateMessage() {
		return exceptionTemplateMessage;
	}
	public void setExceptionTemplateMessage(String exceptionTemplateMessage) {
		this.exceptionTemplateMessage = exceptionTemplateMessage;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<String> getImportList() {
		return importList;
	}
	public void setImportList(List<String> importList) {
		this.importList = importList;
	}
	public List<ValidationComponentOutputData> getValidationMethodList() {
		return validationMethodList;
	}
	public void setValidationMethodList(List<ValidationComponentOutputData> validationMethodList) {
		this.validationMethodList = validationMethodList;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getValidationMethodName() {
		return validationMethodName;
	}
	public void setValidationMethodName(String validationMethodName) {
		this.validationMethodName = validationMethodName;
	}
}
