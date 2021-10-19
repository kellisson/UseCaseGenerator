package com.kekellisson.componentGenerator.useCases.enumParser;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.kekellisson.componentGenerator.useCases.InputBoundary;
import com.kekellisson.componentGenerator.useCases.OutputBoundary;
import com.kekellisson.componentGenerator.useCases.StringUtils;



public class EnumParserUseCase implements InputBoundary<ValidateComponentInputData> {

	OutputBoundary<EnumParserOutputData> outputBoundary;
	
	public EnumParserUseCase(OutputBoundary<EnumParserOutputData> outputBoundary) {
		this.outputBoundary = outputBoundary;
	}

	@Override
	public void execute(ValidateComponentInputData inputData) {
		EnumParserOutputData outputData = new EnumParserOutputData();
		
		outputData.setEnumName(generateEnumName(inputData.getEnumName()));
		outputData.setPackageName(generatePackageName(inputData.getEnumPackage()));
		outputData.setAttributesMap(generateEnumAttributesMap());
		outputData.setEnumItemList(inputData.getEnumValuesList()
				.stream()
				.map(enumValue -> generateEnumItem(enumValue))
				.collect(Collectors.toList())
				);
		
		outputBoundary.execute(outputData);
	}

	private EnumItem generateEnumItem(String enumValue) {
		EnumItem item = new EnumItem();
		item.setName(generateEnumItemName(enumValue));
		item.setValue(generateEnumItemValue(enumValue));
		return item;
	}
	
	private String generateEnumItemName(String enumItem) {
		enumItem = enumItem.replace(" ", "");
		enumItem = Normalizer.normalize(enumItem, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		
		if(enumItem.length() > 3)
			 enumItem = StringUtils.snakeCase(enumItem);
		return enumItem.toUpperCase().substring(0, enumItem.length() < 15 ? enumItem.length() : 15);
	}

	private String generateEnumItemValue(String enumValue) {
		StringBuilder enumValueBuilder = new StringBuilder();
		enumValueBuilder.append("\"").append(enumValue).append("\"");
		return enumValueBuilder.toString();
	}

	private Map<String, String> generateEnumAttributesMap() {
		Map<String, String> enumAttributeMap = new HashMap<String, String>();
		enumAttributeMap.put("value", "String");
		return enumAttributeMap;
	}

	private String generatePackageName(String enumPackage) {
		return enumPackage.toLowerCase();
	}

	private String generateEnumName(String enumName) {
		return StringUtils.upperFirst(enumName);
	}

}
