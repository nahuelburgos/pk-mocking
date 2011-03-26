package delucas.mocking.engine.core;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the main concept of a helper  whose
 * main function is to fill some object's fields. It keeps
 * track of the Field and the corresponding DataGenerator
 * 
 * @author Lucas Videla
 *
 * @param <E> is the generic class
 */
public class DataFiller<E> {

	private Map<Field, DataGenerator<? extends Object>> bindings;
	
	/**
	 * Simple constructor. Initializes the collection of bindings
	 */
	public DataFiller() {
		bindings = new HashMap<Field, DataGenerator<? extends Object>>();
	}
	
	/**
	 * Fills the object according to the bindings previously added
	 * 
	 * @param object is the instance to fill with
	 */
	public void fill(E object) {
		
		try {
			for (Field field : bindings.keySet()){
				if (!field.isAccessible()){
					field.setAccessible(true);
				}
				field.set(object, bindings.get(field).generateDatum());
			}
		} catch (Exception e) {
			System.out.println("Ocurrió un error al llenar el objeto");
			e.printStackTrace();
		}
	    
	}
	
	/**
	 * Binds some field to a certain DataGenerator
	 * 
	 * @param field is the field to bind
	 * @param generator is the DataGenerator to use
	 */
	public void bind (Field field, DataGenerator<? extends Object> generator){
		this.bindings.put(field, generator);
	}

}
