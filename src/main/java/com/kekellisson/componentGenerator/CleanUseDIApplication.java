package com.kekellisson.componentGenerator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kekellisson.componentGenerator.configuration.ApplicationConfig;
import com.kekellisson.componentGenerator.useCases.InputBoundary;
import com.kekellisson.componentGenerator.useCases.OutputBoundary;
import com.kekellisson.componentGenerator.useCases.validateComponent.ComponentInputData;
import com.kekellisson.componentGenerator.useCases.validateComponent.ValidateComponentInputData;
import com.kekellisson.componentGenerator.useCases.validateComponent.ValidateComponentOutputData;
import com.kekellisson.componentGenerator.useCases.validateComponent.ValidateComponentUseCase;

public class CleanUseDIApplication {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		 
		OutputBoundary<ValidateComponentOutputData> outputBoundary = context.getBean("freemarkerValidateMethodGenerator", OutputBoundary.class);
		String fileRelativePath = "\\src\\main\\resources\\docTeste.txt";
		try {
			validateGeneratorUseCase(loadInputData(fileRelativePath), outputBoundary);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			context.close();
		}
	}
	
	private static void validateGeneratorUseCase(ValidateComponentInputData inputData, OutputBoundary<ValidateComponentOutputData> outputBoundary) throws IOException {
		InputBoundary<ValidateComponentInputData> useCase = new ValidateComponentUseCase(outputBoundary);
		useCase.execute(inputData);
	}

	private static ValidateComponentInputData loadInputData(String fileRelativePath) throws FileNotFoundException {
		Scanner scanner = new Scanner(Paths.get(".",fileRelativePath).toFile());
		List<ComponentInputData> listInputData = new ArrayList<ComponentInputData>();
		String line = "";
		ValidateComponentInputData validateComponentInputData = new ValidateComponentInputData();
		try {
			validateComponentInputData.setPackageName(scanner.nextLine());
			validateComponentInputData.setClassName(scanner.nextLine());
			while(scanner.hasNext()) {
				ComponentInputData inputData = new ComponentInputData();
				line = scanner.nextLine();
				inputData.setComponentName(line);
				
				List<String> requiredFieldsList = new ArrayList<String>();
				while(scanner.hasNext()) {
					line = scanner.nextLine();
					if(line.isEmpty() || line.equals("\n"))
						break;
					requiredFieldsList.add(line);
				}
				inputData.setRequiredFieldsList(requiredFieldsList);
				listInputData.add(inputData);
			}
		} catch (Exception e) {
			System.err.println("erro de parsing na linha: "+line);
		}
		
		validateComponentInputData.setComponentInputDataList(listInputData);
		
		return validateComponentInputData;
	}

}
