package com.kekellisson.componentGenerator.presenters;

import java.io.IOException;
import java.io.Writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kekellisson.componentGenerator.io.IOBoundary;
import com.kekellisson.componentGenerator.useCases.validateComponent.ValidateComponentOutputData;

import freemarker.template.TemplateException;

@Component
public class FreemarkerValidateMethodGenerator  extends AbstractFreemarkerGenerator<ValidateComponentOutputData> {
	
	private final IOBoundary io;
	private final String templateName;
	
	@Autowired
	public FreemarkerValidateMethodGenerator(IOBoundary ioBoundary, TemplateBoundary templateBoundary) throws IOException{
		this.io = ioBoundary;
		this.templateBoundary = templateBoundary;
		
		templateName = "ValidateMethodTemplate.ftl";
	}

	@Override
	public void execute(ValidateComponentOutputData outputData) {
		try {
			Writer writer = io.getWriter(outputData.getClassName()+".java");
			processTemplate(outputData, templateBoundary.getTemplate(templateName), writer);
			io.flushAndClose(writer);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}
}
