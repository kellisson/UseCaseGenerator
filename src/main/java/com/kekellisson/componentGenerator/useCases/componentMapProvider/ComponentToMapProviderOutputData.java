package com.kekellisson.componentGenerator.useCases.componentMapProvider;

import java.util.List;

public class ComponentToMapProviderOutputData {

	private List<ComponentToMapTemplate> mappedComponentList;
	private String className;
	private String packageName;
	
	public List<ComponentToMapTemplate> getMappedComponentList() {
		return mappedComponentList;
	}

	public void setMappedComponentList(List<ComponentToMapTemplate> mappedComponentList) {
		this.mappedComponentList = mappedComponentList;
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
