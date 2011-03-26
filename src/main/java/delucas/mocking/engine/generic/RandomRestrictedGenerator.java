package delucas.mocking.engine.generic;

import delucas.mocking.engine.core.DataGenerator;

/**
 * Abstract level of implementation of DataGenerator. It holds the boundaries
 * of the value to be picked. Subsequent implementations should return values
 * according to data types
 * 
 * @author Lucas Videla
 *
 * @param <E> is the type of the random datum
 */
public abstract class RandomRestrictedGenerator<E> implements DataGenerator<E> {

	protected E upperLimit;
	protected E lowerLimit;
	
	/**
	 * You may initialize any RandomRestrictedGenerator with both limit values
	 * @param lowerLimit the lower limit
	 * @param upperLimit the upper limit
	 */
	public RandomRestrictedGenerator(E lowerLimit, E upperLimit) {
		super();
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}
	
}
