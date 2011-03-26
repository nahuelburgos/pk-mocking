package delucas.mocking.instances;

import delucas.mocking.engine.generic.RandomRestrictedGenerator;


public class RandomIntegerGenerator extends RandomRestrictedGenerator<Integer> {

	public RandomIntegerGenerator() {
		super(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public RandomIntegerGenerator(Integer lowerLimit, Integer upperLimit) {
		super(lowerLimit, upperLimit);
	}
	
	public Integer generateDatum() {
		Long scale = (long)upperLimit - (long)lowerLimit;
		Long random = (long)(Math.random() * scale);
		return (int)(lowerLimit + random);
	}

}
