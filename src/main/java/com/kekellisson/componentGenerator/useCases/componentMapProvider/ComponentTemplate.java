package com.kekellisson.componentGenerator.useCases.componentMapProvider;

import java.util.List;

public class ComponentTemplate {

	private String name;
	private List<String> parameters;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getParameters() {
		return parameters;
	}
	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
	
}
