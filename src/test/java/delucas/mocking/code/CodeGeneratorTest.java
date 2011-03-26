package delucas.mocking.code;

import org.junit.Test;

import delucas.mocking.helpers.model.Persona;


public class CodeGeneratorTest {

	
	@Test
	public void generaPersonaStubTest(){
		CodeGenerator sg = CodeGenerator.getInstance();
		String resultado = sg.makeStubCode(Persona.class, "persona");
		System.out.println(resultado);
	}
	
	@Test
	public void generaPersonaFromSampleTest() throws Exception{
		CodeGenerator sg = CodeGenerator.getInstance();
		
		Persona p = new Persona();
		p.setEdad(25);
		p.setNombre("Lucas");
		
		String resultado = sg.makeCodeFromSample(p, "persona");
		System.out.println(resultado);
	}
	
}
