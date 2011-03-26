package delucas.mocking.engine.core;

/**
 * Defines the interface for the DataGenerators that can be used
 * inside and extending the mocking api.
 * 
 * @author lvidela
 *
 * @param <E> is the class of the generated datum
 */
public interface DataGenerator<E> {
	
	/**
	 * The main method of the interface. Should return some datum of E type
	 * 
	 * @return some datum
	 */
	public E generateDatum();
	
}
