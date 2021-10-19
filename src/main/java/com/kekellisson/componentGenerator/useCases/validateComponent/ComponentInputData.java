package com.kekellisson.componentGenerator.useCases.validateComponent;

import java.util.List;

public class ComponentInputData {

	private String componentName;
	private List<String> requiredFieldsList;
	
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public List<String> getRequiredFieldsList() {
		return requiredFieldsList;
	}
	public void setRequiredFieldsList(List<String> requiredFieldsList) {
		this.requiredFieldsList = requiredFieldsList;
	}
	
}
