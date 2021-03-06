package delucas.mocking.instances;

import java.util.HashMap;
import java.util.Map;

import delucas.mocking.engine.core.DataGenerator;

public class RandomStringPatternGenerator implements DataGenerator<String>{

	private String pattern;
	private Map<String,DataGenerator<String>> replacements = new HashMap<String, DataGenerator<String>>();
	
	public RandomStringPatternGenerator(String pattern) {
		this.pattern = pattern;
	}
	
	public void addParameter(String replacement, DataGenerator<String> dataGenerator) {
		this.replacements.put(":" + replacement + ":", dataGenerator);
	}
	
	public String generateDatum() {
		String returnValue = new String(pattern);
		
		for (String replacement : replacements.keySet()){
			returnValue = returnValue.replace(replacement, replacements.get(replacement).generateDatum());
		}
		
		return returnValue;
	}



}
