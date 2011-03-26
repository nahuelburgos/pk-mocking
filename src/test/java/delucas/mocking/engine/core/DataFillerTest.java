package delucas.mocking.engine.core;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import delucas.mocking.helpers.model.Persona;
import delucas.mocking.instances.RandomIntegerGenerator;
import delucas.mocking.instances.RandomStringPicker;

public class DataFillerTest {

	@Test
	public void testSimpleFill() throws SecurityException, NoSuchFieldException{
		
		// we define an entity
		Persona p = new Persona();
		
		// we define also the Filler
		DataFiller<Persona> df = new DataFiller<Persona>();

		// simply the set of possible values
		List<String> namesList = new LinkedList<String>();
		namesList.add("Lucas");
		namesList.add("Ernesto");
		namesList.add("Juan");
		
		// the generators
		RandomStringPicker rsp = new RandomStringPicker(namesList);
		RandomIntegerGenerator rig = new RandomIntegerGenerator(10,20);
		
		// we add the binding between some fields and some generators
		Field field = Persona.class.getDeclaredField("nombre");
		df.bind(field, rsp );
		
		field = Persona.class.getDeclaredField("edad");
		df.bind(field, rig);
		
		// we ask the filler to fill our entity object
		df.fill(p);
		
		// we assert for the entity to have the fields not null
		Assert.assertNotNull(p.getNombre());
		Assert.assertNotNull(p.getEdad());
		
	}
	
}
