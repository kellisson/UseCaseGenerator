package com.kekellisson.componentGenerator.useCases;

public interface OutputBoundary<T> {

	public void execute(T outputData);
	
}
