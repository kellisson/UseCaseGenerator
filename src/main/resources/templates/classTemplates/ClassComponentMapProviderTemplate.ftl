package ${packageName};

import java.util.HashMap;
import java.util.Map;

public class ${className} {

	<#list mappedComponentList as object>
	public static Map<String, Object> ${object.methodName}(${object.setterClass} ${object.setterVariableName}){
		Map<String, Object> ${object.mapName} = new HashMap<String, Object>();
		
		<#list object.parameters as parameter>
		${object.mapName}.put(${object.setterClass}.${parameter},"");
		</#list>

		return ${object.mapName};
	}
	
	</#list>  
}