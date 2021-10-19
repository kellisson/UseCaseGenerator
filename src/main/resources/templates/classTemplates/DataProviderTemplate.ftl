package ${packageName};

public class ${className} {
 	
 	<#list attributesList as attributes>
 	public get${className}(){
 		${attributes.className} ${attributes.objectName} = new ${attributes.className}();
 		
 		return ${attributes.objectName};
 	}
 	</#list>
 	
}