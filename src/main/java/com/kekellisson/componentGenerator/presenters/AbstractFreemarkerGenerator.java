package com.kekellisson.componentGenerator.presenters;

import java.io.IOException;
import java.io.Writer;

import com.kekellisson.componentGenerator.useCases.OutputBoundary;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public abstract class AbstractFreemarkerGenerator<T> implements OutputBoundary<T> {

	protected TemplateBoundary templateBoundary;
	
	protected Writer processTemplate(Object outputData, Template template, Writer writer) throws TemplateException, IOException {
		template.process(outputData, writer);
		return writer;
	}

	protected Template loadTemplate(String templateName) {
		try {
			return templateBoundary.getTemplate(templateName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
