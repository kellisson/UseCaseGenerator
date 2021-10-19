package com.kekellisson.componentGenerator.presenters;

import java.io.IOException;
import java.io.Writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kekellisson.componentGenerator.io.IOBoundary;
import com.kekellisson.componentGenerator.useCases.classComponent.ComponentOutputData;

import freemarker.template.TemplateException;

@Component
public class FreemarkerComponentGenerator extends AbstractFreemarkerGenerator<ComponentOutputData> {

	private final IOBoundary io;
	private final String templateName;
	
	@Autowired
	public FreemarkerComponentGenerator(IOBoundary ioBoundary, TemplateBoundary templateBoundary) throws IOException{
		this.io = ioBoundary;
		this.templateBoundary = templateBoundary;
		
		templateName = "ClassComponentTemplate.ftl";
	}

	@Override
	public void execute(ComponentOutputData outputData) {
		try {
			Writer writer = io.getWriter(outputData.getClassName()+".java");
			processTemplate(outputData, templateBoundary.getTemplate(templateName), writer);
			io.flushAndClose(writer);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

}