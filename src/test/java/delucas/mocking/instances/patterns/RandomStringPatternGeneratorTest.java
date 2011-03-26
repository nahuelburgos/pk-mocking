package delucas.mocking.instances.patterns;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import delucas.mocking.engine.core.DataGenerator;
import delucas.mocking.instances.RandomStringPatternGenerator;
import delucas.mocking.instances.RandomStringPicker;
import delucas.mocking.util.NameDictionaryFactory;

public class RandomStringPatternGeneratorTest {

	@Test
	public void testPatronSimple(){
		
		String pattern = "¡Hola, :nombre:!";
		RandomStringPatternGenerator generator = new RandomStringPatternGenerator(pattern);
		List<String> dataList = NameDictionaryFactory.getInstance().getSpanishMaleNames();
		DataGenerator<String> dataGenerator = new RandomStringPicker(dataList );
		generator.addParameter("nombre", dataGenerator );
		
		String resultado = generator.generateDatum();
		
		Assert.assertNotNull(resultado);
		
	}
	
}
