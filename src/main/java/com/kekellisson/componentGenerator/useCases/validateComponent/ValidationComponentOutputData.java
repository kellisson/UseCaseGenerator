package com.kekellisson.componentGenerator.useCases.validateComponent;

import java.util.List;

public class ValidationComponentOutputData {

    private String className;
    private String validationMethodName;
    private String objectName;
    private List<AttributeData> attributeDataList;
    
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getValidationMethodName() {
		return validationMethodName;
	}
	public void setValidationMethodName(String validationMethodName) {
		this.validationMethodName = validationMethodName;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public List<AttributeData> getAttributeDataList() {
		return attributeDataList;
	}
	public void setAttributeDataList(List<AttributeData> attributeDataList) {
		this.attributeDataList = attributeDataList;
	}

}
