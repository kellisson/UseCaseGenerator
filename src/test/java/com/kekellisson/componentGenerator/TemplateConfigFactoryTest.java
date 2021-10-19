package com.kekellisson.componentGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kekellisson.componentGenerator.presenters.TemplateConfigFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;
import freemarker.template.Version;
import freemarker.template.utility.NullArgumentException;

public class TemplateConfigFactoryTest {

	@Test
	void nullTemplateName() {
		
		TemplateConfigFactory templateConfig = null;
		Version version = Configuration.VERSION_2_3_29;
		String templateLocation = "\\src\\main\\resources\\templates\\classTemplates";
		String defaultEncoding = "ISO-8859-1";
		boolean isAutoFlush = false;
		
		try {
			templateConfig = new TemplateConfigFactory(version, templateLocation, defaultEncoding, isAutoFlush);
		} catch (Exception e) {
			Assertions.fail();
		}
		
		String templateName = null;
		
		try {
			templateConfig.getTemplate(templateName);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(NullArgumentException.class);
		}
	}
	
	@Test
	void invalidTemplateName() {
		TemplateConfigFactory templateConfig = null;
		Version version = Configuration.VERSION_2_3_29;
		String templateLocation = "\\src\\main\\resources\\templates\\classTemplates";
		String defaultEncoding = "ISO-8859-1";
		boolean isAutoFlush = false;
		
		try {
			templateConfig = new TemplateConfigFactory(version, templateLocation, defaultEncoding, isAutoFlush);
		} catch (IOException e) {
			Assertions.fail();
		}
		
		String templateName = "";
		
		try {
			templateConfig.getTemplate(templateName);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(TemplateNotFoundException.class);
		}
	}
	
	@Test
	void validTemplateName() {
		TemplateConfigFactory templateConfig = null;
		Version version = Configuration.VERSION_2_3_29;
		String templateLocation = "\\src\\main\\resources\\templates\\classTemplates";
		String defaultEncoding = "ISO-8859-1";
		boolean isAutoFlush = false;
		
		try {
			templateConfig = new TemplateConfigFactory(version, templateLocation, defaultEncoding, isAutoFlush);
		} catch (IOException e) {
			Assertions.fail();
		}
		
		String templateName = "ClassComponentMapProviderTemplate.ftl";
		Template template = null;
		
		try {
			template = templateConfig.getTemplate(templateName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(template != null);
	}
}
