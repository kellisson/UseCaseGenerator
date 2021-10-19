package com.kekellisson.componentGenerator.useCases.dataProvider;

import java.util.List;

public class DataProviderInputData {

	private String packageName;
	private List<MethodData> component;
	
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public List<MethodData> getComponent() {
		return component;
	}
	public void setComponent(List<MethodData> component) {
		this.component = component;
	}
	
}
