package delucas.mocking.instances;

import java.util.List;

import delucas.mocking.engine.generic.RandomDatumPicker;

/**
 * This class is the implementation in String version of the
 * RandomDatumPicker. It holds a list of values and picks
 * one each time from that list, randomly.
 * 
 * @author Lucas Videla
 *
 */
public class RandomStringPicker extends RandomDatumPicker<String>{

	/**
	 * Tp pick a String on demand
	 * 
	 * @return the datum from the list.
	 */
	public RandomStringPicker(List<String> dataList) {
		super(dataList);
	}

}
