package com.kekellisson.componentGenerator.useCases.componentMapProvider;

import java.util.stream.Collectors;

import com.kekellisson.componentGenerator.useCases.InputBoundary;
import com.kekellisson.componentGenerator.useCases.OutputBoundary;
import com.kekellisson.componentGenerator.useCases.StringUtils;


/**
 * Caso de uso que cria os conversores das classes para seu Map correspondente
 * @author kelli
 *
 */
public class GenerateClassComponentMapProviderUseCase implements InputBoundary<MapProviderInputData> {

	private OutputBoundary<ComponentToMapProviderOutputData> outputBoundary;
	
	public GenerateClassComponentMapProviderUseCase(OutputBoundary<ComponentToMapProviderOutputData> outputBoundary) {
		this.outputBoundary = outputBoundary;
	}

	@Override
	public void execute(MapProviderInputData inputData) {
		ComponentToMapProviderOutputData outputData = new ComponentToMapProviderOutputData ();
		
		outputData.setClassName(inputData.getClassName());
		outputData.setPackageName(inputData.getPackageName());
		outputData.setMappedComponentList(
				inputData.getComponentTemplateList().stream()
					.map(item -> generateComponentTemplateObject(item))
					.collect(Collectors.toList()));
		
		outputBoundary.execute(outputData);
	}

	private ComponentToMapTemplate generateComponentTemplateObject(ComponentTemplate componentTemplate) {
		ComponentToMapTemplate componentToMapObject = new ComponentToMapTemplate();
		componentToMapObject.setMapName(StringUtils.lowerFirst(componentTemplate.getName())+"Map");
		componentToMapObject.setMethodName("get"+StringUtils.upperFirst(componentTemplate.getName()));
		componentToMapObject.setParameters(componentTemplate.getParameters().stream()
											.map(parameter -> StringUtils.snakeCase(parameter).toUpperCase())
											.collect(Collectors.toList()));
		componentToMapObject.setSetterClass(StringUtils.upperFirst(componentTemplate.getName()));
		componentToMapObject.setSetterVariableName(StringUtils.lowerFirst(componentTemplate.getName()));
		
		return componentToMapObject;
	}

}
