package com.kekellisson.componentGenerator.useCases.classComponent;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.kekellisson.componentGenerator.useCases.InputBoundary;
import com.kekellisson.componentGenerator.useCases.OutputBoundary;
import com.kekellisson.componentGenerator.useCases.StringUtils;



/**
 * Caso de uso que gera classes java de acordo com os dados preenchidos no InputData
 * @author kelli
 *
 */
public class GenerateClassComponentUseCase implements InputBoundary<ComponentInputData> {
	
	private OutputBoundary<ComponentOutputData> outputBoundary;
	
	public GenerateClassComponentUseCase(OutputBoundary<ComponentOutputData> outputBoundary) {
		this.outputBoundary = outputBoundary;
	}
	
	private enum ComponentImports{

		DATE ("Date", "java.util.Date"),
		MAP ("Map", "java.util.Map"),
		HASH_MAP ("HashMap", "java.util.HashMap"),
		LIST ("List", "java.util.List");
		
		private final String type;
		private final String importType;
		
		ComponentImports(String typeOpcao, String importOpcao) {
			type = typeOpcao;
			importType = importOpcao;
		}

		public static String getImportText(String type) {
			for(ComponentImports componentImport : ComponentImports.values()) {
				if(type.contains("List") ){
					return ComponentImports.LIST.importType;
				}
				if(componentImport.type.equals(type))
					return componentImport.importType;
			}
			return null;
		}
	}

	@Override
	public void execute(ComponentInputData inputData) {
		List<String> constantNameFieldList = inputData.getFieldsName().stream()
													.map(field -> formatConstantName(field))
													.collect(Collectors.toList());
		
		Map<String, String> constantNameValueList = inputData.getFieldsName().stream()
														.collect(Collectors.toMap(
																	field -> formatConstantName(field), 
																	field -> formatConstantValue(field)));
		
		List<Parameter> parametersList = inputData.getFieldTypeMap()
											.entrySet()
											.stream()
											.map(parameter -> generateParameter(parameter.getKey(), parameter.getValue()))
											.collect(Collectors.toList());
		
		ComponentOutputData outputData = new ComponentOutputData();
		
		outputData.setPackageName(inputData.getPackageName());
		outputData.setClassName(formatClassName(inputData.getClassName()));
		outputData.setConstantFieldName(constantNameFieldList);
		outputData.setConstantFieldValue(constantNameValueList);
		outputData.setParametersList(parametersList);
		
		outputData.setImportsList(parametersList
										.stream()
										.map(parameter -> ComponentImports.getImportText(parameter.getType()))
										.distinct()
										.filter(Objects::nonNull)
										.collect(Collectors.toList()));
		
		outputBoundary.execute(outputData);
	}
	
	private String formatClassName(String className) {
		String capitalFirstLetter = className.substring(0, 1).toUpperCase();
		return capitalFirstLetter + className.substring(1);
	}
	
	private String formatConstantName(String constantField) {
		return StringUtils.snakeCase(constantField).toUpperCase();
	}
	
	private String formatConstantValue(String constantField) {
		String capitalFirstLetter = constantField.substring(0, 1).toUpperCase();
		return capitalFirstLetter + constantField.substring(1);
	}
	
	private Parameter generateParameter(String parameterName, String parameterType) {
		Parameter parameter = new Parameter();
		parameter.setFunctionName(StringUtils.upperFirst(parameterName));
		parameter.setName(StringUtils.lowerFirst(parameterName));
		parameter.setType(StringUtils.upperFirst(parameterType));
		
		return parameter;
	}
}
