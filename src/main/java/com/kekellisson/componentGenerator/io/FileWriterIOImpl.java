package com.kekellisson.componentGenerator.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component
public class FileWriterIOImpl implements IOBoundary {

	private final String OUTPUT_RELATIVE_FOLDER_PATH = "\\useCaseOutput"; 
	
	private Path path;
	
	public FileWriterIOImpl() {
		this.path = Paths.get(".", OUTPUT_RELATIVE_FOLDER_PATH);
		path.toFile().mkdir();
	}
	
	@Override
	public String getFilePathDestiny() {
		return path.toAbsolutePath().toString();
	}

	@Override
	public Writer getWriter(String fileName) throws IOException {
		return new FileWriter(getFilePathDestiny()+"\\"+fileName);
	}

	@Override
	public void flushAndClose(Writer writer) throws IOException {
		writer.flush();
		writer.close();
	}

}
