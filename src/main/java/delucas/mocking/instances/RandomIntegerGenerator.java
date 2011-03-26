package delucas.mocking.instances;

import delucas.mocking.engine.generic.RandomRestrictedGenerator;

/**
 * Implementation of RandomRestrictedGenerator, returns an Integer into the
 * original range.
 * 
 * @author Lucas Videla
 *
 */
public class RandomIntegerGenerator extends RandomRestrictedGenerator<Integer> {

	/**
	 * If it is initialized without specifying any boundary, it will pick
	 * the minimum and maximum Integers as limits.
	 */
	public RandomIntegerGenerator() {
		super(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/**
	 * You can initialize any RandomIntegerGenerator with both limit Integer values
	 * @param lowerLimit the lower limit
	 * @param upperLimit the upper limit
	 */
	public RandomIntegerGenerator(Integer lowerLimit, Integer upperLimit) {
		super(lowerLimit, upperLimit);
	}
	
	/**
	 * The main method of the interface. Should return some datum of Integer type
	 * 
	 * @return some randomly picked Integer
	 */
	public Integer generateDatum() {
		Long scale = (long)upperLimit - (long)lowerLimit;
		Long random = (long)(Math.random() * scale);
		return (int)(lowerLimit + random);
	}

}
