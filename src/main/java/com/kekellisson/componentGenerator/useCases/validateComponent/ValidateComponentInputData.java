package com.kekellisson.componentGenerator.useCases.validateComponent;

import java.util.List;

public class ValidateComponentInputData {

	private String className;
	private String packageName;
	private List<ComponentInputData> componentInputDataList;

	public List<ComponentInputData> getComponentInputDataList() {
		return componentInputDataList;
	}

	public void setComponentInputDataList(List<ComponentInputData> componentInputDataList) {
		this.componentInputDataList = componentInputDataList;
	}

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
	
}
