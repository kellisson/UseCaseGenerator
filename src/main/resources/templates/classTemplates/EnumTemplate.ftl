package ${packageName};

public enum ${enumName} {
	
<#list enumItemList as enum>
	${enum.name}(${enum.value}),
</#list>;
	
<#list attributesMap as fieldName, fieldType>
	public ${fieldType} ${fieldName};
</#list>
 	
 	private ${enumName}(<#list attributesMap as fieldName, fieldType>${fieldType} ${fieldName}</#list>){
 	<#list attributesMap as fieldName, fieldType>
 		this.${fieldName} = ${fieldName};
 	</#list>
 	}
}