package delucas.mocking.engine.text;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import delucas.mocking.instances.RandomStringPicker;

public class RandomStringPickerTest {

	private RandomStringPicker randomStringPicker;

	@Before
	public void setUp(){
		
		LinkedList<String> dataList = new LinkedList<String>();
		
		dataList.add("TestString1");
		dataList.add("TestString2");
		dataList.add("TestString3");
		dataList.add("TestString4");
		dataList.add("TestString5");
		
		randomStringPicker = new RandomStringPicker(dataList);
	}
	
	@Test
	public void testTraeDato(){
		String aleatorio = randomStringPicker.generateDatum();
		
		Assert.assertNotNull(aleatorio);
	}
	
}
