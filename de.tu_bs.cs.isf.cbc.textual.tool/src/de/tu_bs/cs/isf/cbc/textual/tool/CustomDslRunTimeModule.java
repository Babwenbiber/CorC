package de.tu_bs.cs.isf.cbc.textual.tool;

import org.eclipse.xtext.generator.IGenerator;

import de.tu_bs.cs.isf.cbc.textual.tool.generator.CustomJvmModelGenerator;

public class CustomDslRunTimeModule extends AbstractDslRuntimeModule {
	
	@Override
	public Class<? extends IGenerator> bindIGenerator() {
		return CustomJvmModelGenerator.class;
	}


}
