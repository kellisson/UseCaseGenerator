package com.kekellisson.componentGenerator.useCases.componentMapProvider;

import java.util.List;

public class ComponentToMapTemplate {
	
	private String methodName;
	private String mapName;
	private String setterClass;
	private String setterVariableName;
	private List<String> parameters;
	
	public String getMethodName() {
		return methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public String getMapName() {
		return mapName;
	}
	
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}
	
	public List<String> getParameters() {
		return parameters;
	}
	
	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}

	public String getSetterClass() {
		return setterClass;
	}

	public void setSetterClass(String setterClass) {
		this.setterClass = setterClass;
	}

	public String getSetterVariableName() {
		return setterVariableName;
	}

	public void setSetterVariableName(String setterVariableName) {
		this.setterVariableName = setterVariableName;
	}
}
