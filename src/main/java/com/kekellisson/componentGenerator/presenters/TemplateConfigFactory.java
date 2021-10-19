package com.kekellisson.componentGenerator.presenters;

import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

@Component
public class TemplateConfigFactory implements TemplateBoundary {

	private Configuration cfg;

	public TemplateConfigFactory(Version version, @Value("${templateconfig.templatelocation}") String templateLocation,
			@Value("${templateconfig.defaultencoding}") String defaultEncoding,
			@Value("${templateconfig.autoflush}") boolean isAutoFlush) throws IOException {
		cfg = new Configuration(version);
		cfg.setDirectoryForTemplateLoading(Paths.get(".", templateLocation).toFile());
		cfg.setDefaultEncoding(defaultEncoding);
		cfg.setAutoFlush(isAutoFlush);
	}

	@Override
	public Template getTemplate(String templateName) throws IOException {
		return cfg.getTemplate(templateName);
	}
}
