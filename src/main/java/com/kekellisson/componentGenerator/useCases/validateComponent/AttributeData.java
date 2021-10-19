package com.kekellisson.componentGenerator.useCases.validateComponent;

public class AttributeData {

	private String  className;
	private String  validationMethodName;
	private String  methodGetName;
	private boolean haveValidationMethod;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodGetName() {
		return methodGetName;
	}
	public void setMethodGetName(String methodGetName) {
		this.methodGetName = methodGetName;
	}
	public boolean isHaveValidationMethod() {
		return haveValidationMethod;
	}
	public void setHaveValidationMethod(boolean haveValidationMethod) {
		this.haveValidationMethod = haveValidationMethod;
	}
	public String getValidationMethodName() {
		return validationMethodName;
	}
	public void setValidationMethodName(String validationMethodName) {
		this.validationMethodName = validationMethodName;
	}
}
