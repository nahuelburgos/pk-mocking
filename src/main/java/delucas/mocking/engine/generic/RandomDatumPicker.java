package delucas.mocking.engine.generic;

import java.util.List;

import delucas.mocking.engine.core.DataGenerator;

/**
 * Abstract level of implementation of DataGenerator. It holds a list of
 * values from whom will pick one on demand randomly.
 * 
 * @author Lucas Videla
 *
 * @param <E> is the type of the random datum
 */
public abstract class RandomDatumPicker<E> implements DataGenerator<E> {

	protected List<E> dataList;
	
	/**
	 * You may instantiate the RandomDatumPicker with the list of values 
	 * @param dataList the list of values
	 */
	public RandomDatumPicker(List<E> dataList){
		this.dataList = dataList;
	}
	
	/**
	 * To pick datum on demand
	 * 
	 * @return the datum from the list.
	 */
	public E generateDatum() {
		Integer randomIndex = (int)(Math.random() * this.dataList.size());
		return this.dataList.get(randomIndex);
	}

}
