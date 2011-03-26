package delucas.mocking.instances;

import java.util.Calendar;
import java.util.Date;

import delucas.mocking.engine.generic.RandomRestrictedGenerator;


public class RandomDateGenerator extends RandomRestrictedGenerator<Date> {

	public RandomDateGenerator() {
		super(new Date(0,Calendar.JANUARY, 1), new Date());
	}
	
	public RandomDateGenerator(Date lowerLimit, Date upperLimit) {
		super(lowerLimit, upperLimit);
	}
	
	public Date generateDatum() {
		Long scale = upperLimit.getTime() - lowerLimit.getTime();
		Long random = (long)(Math.random() * scale);
		return new Date(lowerLimit.getTime() + random);
	}

}
