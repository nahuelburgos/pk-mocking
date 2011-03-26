package delucas.mocking.code;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CodeGenerator {

	private static final String BOOLEAN_VALUE = "true";
	private static final String DOUBLE_VALUE = "1.0";
	private static final String FLOAT_VALUE = "1.0F";
	private static final String CHAR_VALUE = "'a'";
	private static final String BYTE_VALUE = "(byte) 1";
	private static final String SHORT_VALUE = "(short) 1";
	private static final String INT_VALUE = "1";
	private static final String LONG_VALUE = "1L";
	
	private static CodeGenerator instance = new CodeGenerator();
	
	private CodeGenerator(){}
	
	public static CodeGenerator getInstance() {
		return instance;
	}
	
	public String makeCodeFromSample(Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
		return this.makeCodeFromSample(obj, obj.getClass().getSimpleName().toLowerCase());
	}
	
	public String makeCodeFromSample(Object obj, String objectName) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
		// Clase obj = new Clase();
		Class<?> clazz = obj.getClass();
		
		String retorno = "// Begin of stub for object from Class " + clazz.getSimpleName() + "\n";
		retorno += clazz.getSimpleName() + " " + objectName + " = new " + clazz.getSimpleName() + "();\n\n";
		
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("set")){
				Class<?> tipoDelParametro = method.getParameterTypes()[0];
				
				String valorParametro = "";
				
				// chequeamos por primitivos
				if (tipoDelParametro.isPrimitive() || tipoDelParametro.getPackage().getName().startsWith("java.lang")){
					Object retornoLocal = clazz.getMethod("g" + method.getName().substring(1), new Class<?>[]{}).invoke(obj, new Object[]{});
					if ("String".equals(retornoLocal.getClass().getSimpleName())) {
						valorParametro = "\"" + retornoLocal + "\""; 
					} else {
						valorParametro = "" + retornoLocal;
					}
				} else {
					valorParametro = "new " + tipoDelParametro.getSimpleName() + "()";
				}
				
				
				// es un tipo fuera de la API de Java, hay que inicializarlo
				if (!tipoDelParametro.isPrimitive() && !tipoDelParametro.getPackage().getName().startsWith("java.lang")){
					Object parametro = clazz.getMethod("g" + method.getName(), new Class<?>[]{}).invoke(obj, new Object[]{});
					retorno += "\n" + this.makeCodeFromSample(parametro , method.getName() + "Value");
				} else {
				// TipoAlgo valueForSetAlgo = new TipoAlgo();
					retorno += tipoDelParametro.getSimpleName() + " " + method.getName() + "Value = " + valorParametro + ";\n";
				}
				
				// obj.setAlgo(valorAlgo);
				retorno += objectName + "." + method.getName() + "(" + method.getName() + "Value);\n";
			}
		}
		
		retorno += "// End of stub for Class " + clazz.getSimpleName() + "\n\n";		
		return retorno;
	}

	public String makeStubCode(Class<?> clazz){
		return this.makeStubCode(clazz, clazz.getSimpleName().toLowerCase());
	}
	
	public String makeStubCode(Class<?> clazz, String objectName){
		// Clase obj = new Clase();
		String retorno = "// Begin of stub for Class " + clazz.getSimpleName() + "\n";
		retorno += clazz.getSimpleName() + " " + objectName + " = new " + clazz.getSimpleName() + "();\n\n";
		
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("set")){
				Class<?> tipoDelParametro = method.getParameterTypes()[0];
				
				String valorParametro = "";
				
				// chequeamos por primitivos
				if (tipoDelParametro.isPrimitive()){
					if (tipoDelParametro.equals(long.class)){
						valorParametro = LONG_VALUE;
					}
					if (tipoDelParametro.equals(int.class)){
						valorParametro = INT_VALUE;
					}
					if (tipoDelParametro.equals(short.class)){
						valorParametro = SHORT_VALUE;
					}
					if (tipoDelParametro.equals(byte.class)){
						valorParametro = BYTE_VALUE;
					}
					if (tipoDelParametro.equals(char.class)){
						valorParametro = CHAR_VALUE;
					}
					if (tipoDelParametro.equals(float.class)){
						valorParametro = FLOAT_VALUE;
					}
					if (tipoDelParametro.equals(double.class)){
						valorParametro = DOUBLE_VALUE;
					}
					if (tipoDelParametro.equals(boolean.class)){
						valorParametro = BOOLEAN_VALUE;
					}
				} else {
					valorParametro = "new " + tipoDelParametro.getSimpleName() + "()";
				}
				
				
				// es un tipo fuera de la API de Java, hay que inicializarlo
				if (!tipoDelParametro.isPrimitive() && !tipoDelParametro.getPackage().getName().startsWith("java.lang")){
					retorno += "\n" + this.makeStubCode(tipoDelParametro, method.getName() + "Value");
				} else {
				// TipoAlgo valueForSetAlgo = new TipoAlgo();
					retorno += tipoDelParametro.getSimpleName() + " " + method.getName() + "Value = " + valorParametro + ";\n";
				}
				
				// obj.setAlgo(valorAlgo);
				retorno += objectName + "." + method.getName() + "(" + method.getName() + "Value);\n";
			}
		}
		
		retorno += "// End of stub for Class " + clazz.getSimpleName() + "\n\n";		
		return retorno;
	}
	
}
