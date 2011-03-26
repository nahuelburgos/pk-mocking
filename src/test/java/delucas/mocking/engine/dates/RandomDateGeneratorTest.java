package delucas.mocking.engine.dates;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import delucas.mocking.instances.RandomDateGenerator;

public class RandomDateGeneratorTest {

	@Test
	public void testSinParametrosEstaEnRango(){
		
		RandomDateGenerator randomDateGenerator = new RandomDateGenerator();
		Date aleatorio = randomDateGenerator.generateDatum();
		
		Assert.assertTrue(aleatorio.after(new Date(0,Calendar.JANUARY,1)));
		Assert.assertTrue(aleatorio.before(new Date()));
		
	}
	
	@Test
	public void testConParametrosEstaEnRango(){
		
		Date lowerLimit = new Date(85, Calendar.FEBRUARY, 14);
		Date upperLimit = new Date();

		RandomDateGenerator randomDateGenerator = new RandomDateGenerator(lowerLimit, upperLimit);
		Date aleatorio = randomDateGenerator.generateDatum();
		
		Assert.assertTrue("Se obtuvo: " + aleatorio, aleatorio.after(lowerLimit));
		Assert.assertTrue("Se obtuvo: " + aleatorio, aleatorio.before(upperLimit));
		
	}
	
	@Test
	public void testTraeDato(){
		
		RandomDateGenerator randomDateGenerator = new RandomDateGenerator();
		Date aleatorio = randomDateGenerator.generateDatum();
		
		Assert.assertNotNull(aleatorio);
		
	}
	
}
