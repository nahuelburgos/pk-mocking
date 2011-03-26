package delucas.mocking.engine.generic;

import delucas.mocking.engine.core.DataGenerator;

public abstract class RandomRestrictedGenerator<E> implements DataGenerator<E> {

	protected E upperLimit;
	protected E lowerLimit;
	
	public RandomRestrictedGenerator(E lowerLimit, E upperLimit) {
		super();
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}
	
}
