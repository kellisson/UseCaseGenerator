package ${packageName};

public class ${className} {

	private String atributoNaoEncontrado = "${exceptionTemplateMessage}";

	private boolean ${validationMethodName}(Object object){
		return object == null;
	}

<#list validationMethodList as val>
	public void ${val.validationMethodName}(${val.className} ${val.objectName}) throws ${exceptionClassName}{
		
		StringBuilder mensagemErro = new StringBuilder();

		if(${validationMethodName}(${val.objectName})){
			mensagemErro.append(atributoNaoEncontrado)
				.append("${val.className}").append(".\n");
			throw new ${exceptionClassName}(mensagemErro.toString());
		}

<#list val.attributeDataList as att>
	<#if att.haveValidationMethod >
		${att.validationMethodName}(${val.objectName}.${att.methodGetName}());
	<#else>
		if(${validationMethodName}(${val.objectName}.${att.methodGetName}())){
			mensagemErro.append(atributoNaoEncontrado)
				.append("${att.className}").append(".\n");
		}
	</#if>
</#list>

		if(!mensagemErro.toString().isEmpty()){
			throw new ${exceptionClassName}(mensagemErro.toString());
		}
	}
	
</#list>
}