package delucas.mocking.engine.numeric;

import org.junit.Assert;
import org.junit.Test;

import delucas.mocking.instances.RandomIntegerGenerator;

public class RandomIntegerGeneratorTest {

	@Test
	public void testSinParametrosEstaEnRango(){
		
		RandomIntegerGenerator randomIntegerGenerator = new RandomIntegerGenerator();
		Integer aleatorio = randomIntegerGenerator.generateDatum();
		
		Assert.assertTrue(aleatorio > Integer.MIN_VALUE);
		Assert.assertTrue(aleatorio < Integer.MAX_VALUE);
		
	}
	
	@Test
	public void testConParametrosEstaEnRango(){
		
		Integer lowerLimit = 0;
		Integer upperLimit = 10;

		RandomIntegerGenerator randomIntegerGenerator = new RandomIntegerGenerator(lowerLimit, upperLimit);
		Integer aleatorio = randomIntegerGenerator.generateDatum();
		
		Assert.assertTrue(aleatorio > lowerLimit);
		Assert.assertTrue(aleatorio < upperLimit);
		
	}
	
	@Test
	public void testTraeDato(){
		
		RandomIntegerGenerator randomIntegerGenerator = new RandomIntegerGenerator();
		Integer aleatorio = randomIntegerGenerator.generateDatum();
		
		Assert.assertNotNull(aleatorio);
		
	}
	
}
