package com.kekellisson.componentGenerator.presenters;

import java.io.IOException;

import freemarker.template.Template;

public interface TemplateBoundary {

	public Template getTemplate(String path) throws IOException;
	
}
