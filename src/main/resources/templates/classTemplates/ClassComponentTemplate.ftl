package ${packageName};

<#list importsList as importName>
<#if importName??>
import ${importName};
</#if>
</#list>

public class ${className} {

	<#list constantFieldValue as fieldKey, fieldValue>
    public static final String ${fieldKey} = "${fieldValue}";
 	</#list>   
 	
 	<#list parametersList as parameter>
    private ${parameter.type} ${parameter.name};
 	</#list> 
 	
 	<#list parametersList as parameter>
    public ${parameter.type} get${parameter.functionName}(){
    	return this.${parameter.name};
 	}
 	
 	public void set${parameter.functionName}(${parameter.type} ${parameter.name}){
    	this.${parameter.name} = ${parameter.name};
    }
    
 	</#list> 
}