package com.kekellisson.componentGenerator.useCases.classToMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kekellisson.componentGenerator.useCases.InputBoundary;
import com.kekellisson.componentGenerator.useCases.OutputBoundary;
import com.kekellisson.componentGenerator.useCases.classComponent.ComponentInputData;
import com.kekellisson.componentGenerator.useCases.classComponent.ComponentOutputData;
import com.kekellisson.componentGenerator.useCases.classComponent.GenerateClassComponentUseCase;
import com.kekellisson.componentGenerator.useCases.componentMapProvider.ComponentTemplate;
import com.kekellisson.componentGenerator.useCases.componentMapProvider.ComponentToMapProviderOutputData;
import com.kekellisson.componentGenerator.useCases.componentMapProvider.GenerateClassComponentMapProviderUseCase;
import com.kekellisson.componentGenerator.useCases.componentMapProvider.MapProviderInputData;



public class GenerateClassToMapUseCase implements InputBoundary<ClassToMapInputData> {

	private OutputBoundary<ComponentOutputData> componentOutputBoundary;
	
	private OutputBoundary<ComponentToMapProviderOutputData> componentToMapOutputBoundary;
	
	public GenerateClassToMapUseCase(OutputBoundary<ComponentOutputData> componentOutputBoundary,
			OutputBoundary<ComponentToMapProviderOutputData> componentToMapOutputBoundary) {
		this.componentOutputBoundary = componentOutputBoundary;
		this.componentToMapOutputBoundary = componentToMapOutputBoundary;
	}

	private <T> void executeUseCase(InputBoundary<T> useCase, T inputData) {
		try {
			useCase.execute(inputData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute(ClassToMapInputData inputData) {
		Set<String> componentSet = inputData.getComponentsParametersMap().keySet();
		for(String component : componentSet) {
			executeUseCase(new GenerateClassComponentUseCase(componentOutputBoundary), 
								generateComponentInputData(component, inputData.getPackageName(), 
															inputData.getComponentsParametersMap().get(component),
															inputData.getComponentsParametersTypeMap().get(component)));
		}
		
		executeUseCase(new GenerateClassComponentMapProviderUseCase(componentToMapOutputBoundary), 
							generateComponentMapProviderInputData(
									inputData.getClassName(), 
									inputData.getPackageName(),
									generateListComponentTemplate(inputData.getComponentsParametersMap())
							));
		
	}

	private static ComponentInputData generateComponentInputData(String className,  String packageName, List<String> parameters, 
			Map<String, String> parametersTypeMap) {
		ComponentInputData inputData = new ComponentInputData();
		inputData.setClassName(className);
		inputData.setPackageName(packageName);
		inputData.setFieldsName(parameters);
		inputData.setFieldTypeMap(parametersTypeMap);
		
		return inputData;
	}
	
	private MapProviderInputData generateComponentMapProviderInputData(String className, String packageName, List<ComponentTemplate> componentTemplateList) {
		MapProviderInputData inputData = new MapProviderInputData();
		inputData.setClassName(className);
		inputData.setPackageName(packageName);
		inputData.setComponentTemplateList(componentTemplateList);
		
		return inputData;
	}
	
	private List<ComponentTemplate> generateListComponentTemplate(Map<String,List<String>> componentsDataMap){
		List<ComponentTemplate> componentTemplateList = new ArrayList<ComponentTemplate>();
		Set<String> keySet = componentsDataMap.keySet();
		for(String key : keySet) {
			componentTemplateList.add(generateComponentTemplate(key, componentsDataMap.get(key)));
		}
		return componentTemplateList;
	}
	
	private ComponentTemplate generateComponentTemplate(String name, List<String> parameters) {
		ComponentTemplate componentTemplate = new ComponentTemplate();
		
		componentTemplate.setName(name);
		componentTemplate.setParameters(parameters);
		return componentTemplate;
	}
}
