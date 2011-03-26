package delucas.mocking.instances;

import java.util.Calendar;
import java.util.Date;

import delucas.mocking.engine.generic.RandomRestrictedGenerator;

/**
 * Implementation of RandomRestrictedGenerator, returns a Date into the
 * original range.
 * 
 * @author Lucas Videla
 *
 */
public class RandomDateGenerator extends RandomRestrictedGenerator<Date> {

	/**
	 * If it is initialized without specifying any boundary, it will pick
	 * the first day of the Date representation and today as limits.
	 */
	@SuppressWarnings("deprecation")
	public RandomDateGenerator() {
		super(new Date(0,Calendar.JANUARY, 1), new Date());
	}
	
	/**
	 * You can initialize any RandomDateGenerator with both limit date values
	 * @param lowerLimit the lower limit
	 * @param upperLimit the upper limit
	 */
	public RandomDateGenerator(Date lowerLimit, Date upperLimit) {
		super(lowerLimit, upperLimit);
	}
	
	/**
	 * The main method of the interface. Should return some datum of Date type
	 * 
	 * @return some randomly picked Date
	 */
	public Date generateDatum() {
		Long scale = upperLimit.getTime() - lowerLimit.getTime();
		Long random = (long)(Math.random() * scale);
		return new Date(lowerLimit.getTime() + random);
	}

}
