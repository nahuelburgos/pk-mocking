package delucas.mocking.instances;

import java.util.List;

import delucas.mocking.engine.generic.RandomDatumPicker;

public class RandomStringPicker extends RandomDatumPicker<String>{

	public RandomStringPicker(List<String> dataList) {
		super(dataList);
	}

}
