package delucas.mocking.engine.generic;

import java.util.List;

import delucas.mocking.engine.core.DataGenerator;

public abstract class RandomDatumPicker<E> implements DataGenerator<E> {

	protected List<E> dataList;
	
	public RandomDatumPicker(List<E> dataList){
		this.dataList = dataList;
	}
	
	public E generateDatum() {
		Integer randomIndex = (int)(Math.random() * this.dataList.size());
		return this.dataList.get(randomIndex);
	}

}
