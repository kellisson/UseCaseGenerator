package com.kekellisson.componentGenerator.useCases.validateComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kekellisson.componentGenerator.useCases.InputBoundary;
import com.kekellisson.componentGenerator.useCases.OutputBoundary;
import com.kekellisson.componentGenerator.useCases.StringUtils;


public class ValidateComponentUseCase implements InputBoundary<ValidateComponentInputData>{

	OutputBoundary<ValidateComponentOutputData> outputBoundary;
	
	public ValidateComponentUseCase(OutputBoundary<ValidateComponentOutputData> outputBoundary) {
		this.outputBoundary = outputBoundary;
	}
	
	@Override
	public void execute(ValidateComponentInputData inputData) {
		ValidateComponentOutputData outputData = new ValidateComponentOutputData();
		
		outputData.setClassName(inputData.getClassName());
		outputData.setPackageName(inputData.getPackageName());
		outputData.setExceptionClassName("Exception");
		outputData.setValidationMethodName("isAtributoVazio");
		outputData.setExceptionTemplateMessage("O seguinte dado não foi encontrado: ");
		outputData.setImportList(generateImportList());
		
		Map<String, ValidationComponentOutputData> validationMethodMap = inputData.getComponentInputDataList()
																				.stream()
																				.collect(Collectors.toMap(
																						 ComponentInputData::getComponentName, 
																						 component -> generateValidationComponent(component)));
		
		List<ValidationComponentOutputData> validationComponentList = new ArrayList<ValidationComponentOutputData>();
		for(ComponentInputData component : inputData.getComponentInputDataList()){
			ValidationComponentOutputData validationComponent = validationMethodMap.get(component.getComponentName());
			List<AttributeData> attributesList = component.getRequiredFieldsList()
															.stream()
															.map( field -> generateValidationAttribute(field, validationMethodMap))
															.collect(Collectors.toList());
			validationComponent.setAttributeDataList(attributesList);
			validationComponentList.add(validationComponent);
		}
		
		outputData.setValidationMethodList(validationComponentList);
		
		outputBoundary.execute(outputData);
	}
	
	
	private AttributeData generateValidationAttribute(String field, Map<String, ValidationComponentOutputData> validationMethodMap) {
		ValidationComponentOutputData validationComponent = validationMethodMap.get(field);
		
		AttributeData attribute = new AttributeData();
		attribute.setHaveValidationMethod(validationComponent != null);
		if(attribute.isHaveValidationMethod()) {
			attribute.setValidationMethodName(validationMethodMap.get(field).getValidationMethodName());
			attribute.setClassName(validationComponent.getClassName());
		}else{
			attribute.setClassName(StringUtils.splitWhenUpperCase(field));
		}
		attribute.setMethodGetName("get"+StringUtils.upperFirst(field));
		
		return attribute;
	}

	private ValidationComponentOutputData generateValidationComponent(ComponentInputData component) {
		ValidationComponentOutputData validationComponentData = new ValidationComponentOutputData();
		validationComponentData.setClassName(StringUtils.upperFirst(component.getComponentName()));
		validationComponentData.setValidationMethodName("validate"+StringUtils.upperFirst(component.getComponentName()));
		validationComponentData.setObjectName(StringUtils.lowerFirst(component.getComponentName()));
		return validationComponentData;
	}

	private List<String> generateImportList() {
		return null;
	}

}
