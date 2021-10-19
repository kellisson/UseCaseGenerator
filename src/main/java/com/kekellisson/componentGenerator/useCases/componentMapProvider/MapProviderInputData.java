package com.kekellisson.componentGenerator.useCases.componentMapProvider;

import java.util.List;

public class MapProviderInputData {

	private String packageName;
	private String className;
	private List<ComponentTemplate> componentTemplateList;

	public List<ComponentTemplate> getComponentTemplateList() {
		return componentTemplateList;
	}

	public void setComponentTemplateList(List<ComponentTemplate> componentTemplateList) {
		this.componentTemplateList = componentTemplateList;
	}

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
}
