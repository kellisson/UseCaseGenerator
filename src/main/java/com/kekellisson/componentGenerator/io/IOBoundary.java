package com.kekellisson.componentGenerator.io;

import java.io.IOException;
import java.io.Writer;

public interface IOBoundary {

	public String getFilePathDestiny();
	
	public Writer getWriter(String fileName) throws IOException;
	
	public void flushAndClose(Writer writer) throws IOException;
}
