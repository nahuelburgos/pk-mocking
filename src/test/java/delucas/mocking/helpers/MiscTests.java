package delucas.mocking.helpers;

import junit.framework.Assert;

import org.junit.Test;

public class MiscTests {

	private static final int N = 100000;

	@Test
	public void testDistribution(){
		
		// vamos a probar que del 0 al 9 salen todos
		int randomIndex;
		
		int[] ocurrencias = new int[10];
		for (int i=0; i<N; i++){
			randomIndex = (int)(Math.random() * 10);
			ocurrencias[randomIndex]++;
		}
		for (int i = 0; i<ocurrencias.length; i++){
			Assert.assertTrue(ocurrencias[i]>0);
		}
	}
	
}
