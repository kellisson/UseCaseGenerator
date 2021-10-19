package com.kekellisson.componentGenerator;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kekellisson.componentGenerator.useCases.classToMap.ClassToMapInputData;
import com.kekellisson.componentGenerator.useCases.enumParser.ValidateComponentInputData;


@SpringBootApplication
public class CleanUseCaseGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanUseCaseGeneratorApplication.class, args);
		
		String fileRelativePath = "\\src\\main\\resources\\documentacaoAcademicaDefinitions.txt";
		String enumDefinitionPath = "\\src\\main\\resources\\enumDefinitions.txt";
		String diplomaDigitalDefinitionsPath = "\\src\\main\\resources\\diplomaDigitalMapProvider.txt";
	}	
		
	
	private static List<ValidateComponentInputData> loadEnumData(String relativePath) throws FileNotFoundException {
		Scanner scanner = new Scanner(Paths.get(".",relativePath).toFile());
		List<ValidateComponentInputData> listInputData = new ArrayList<ValidateComponentInputData>();
		String line = "";
		try {
			line = scanner.nextLine();
			String packageName = line;
			while(scanner.hasNext()) {
				ValidateComponentInputData inputData = new ValidateComponentInputData();
				inputData.setEnumPackage(packageName);
				
				line = scanner.nextLine();
				inputData.setEnumName(line);
				List<String> enumvaluesList = new ArrayList<String>();
				while(scanner.hasNext()) {
					line = scanner.nextLine();
					if(line.isEmpty() || line.equals("\n"))
						break;
					enumvaluesList.add(line);
					inputData.setEnumValuesList(enumvaluesList);
				}
				listInputData.add(inputData);
			}
		} catch (Exception e) {
			System.err.println("erro de parsing na linha: "+line);
		}
		
		return listInputData;
	}
	
	private static ClassToMapInputData getFileClassDescriptionData(String relativePath) throws FileNotFoundException {
		ClassToMapInputData classToMapInputData = new ClassToMapInputData();
		Scanner scanner = new Scanner(Paths.get(".",relativePath).toFile());
		Map<String, List<String>> componentParametersMap = new HashMap<String,List<String>>();
		Map<String,Map<String, String>> componentParametersTypeMap = new HashMap<String, Map<String,String>>();
		
		classToMapInputData.setClassName(scanner.nextLine());
		classToMapInputData.setPackageName(scanner.nextLine());
		
		while(scanner.hasNext()) {
			String className = scanner.nextLine();
			List<String> parameters = new ArrayList<String>();
			Map<String, String> parametersType = new HashMap<String, String>();
			
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				try {
					if(line.isEmpty() || line.equals("\n"))
						break;
					String[] params = line.split(" ");
					parameters.add(params[1]);
					parametersType.put(params[1], params[0]);
				} catch (Exception e){
					System.err.println("Erro de parsing da linha: "+line);
					e.printStackTrace();
				}
			}
			
			componentParametersTypeMap.put(className, parametersType);
			componentParametersMap.put(className, parameters);
		}
		
		classToMapInputData.setComponentsDataMap(componentParametersMap);
		classToMapInputData.setComponentsParametersTypeMap(componentParametersTypeMap);
		
		return classToMapInputData;
	}

}
