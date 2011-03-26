package delucas.mocking.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class NameDictionaryFactory {

	private static NameDictionaryFactory instance = new NameDictionaryFactory();

	private NameDictionaryFactory() {
	}

	public static NameDictionaryFactory getInstance() {
		return instance;
	}

	private static final String ASIAN_FEMALE_NAMES = "dictionaries/names/asian_female_names";
	private static final String ASIAN_MALE_NAMES = "dictionaries/names/asian_male_names";
	private static final String ASIAN_SURNAMES = "dictionaries/names/asian_surnames";
	private static final String ENGLISH_FEMALE_NAMES = "dictionaries/names/ english_female_names";
	private static final String ENGLISH_MALE_NAMES = "dictionaries/names/english_male_names";
	private static final String ENGLISH_SURNAMES = "dictionaries/names/english_surnames";
	
	private static final String SPANISH_FEMALE_NAMES = "dictionaries/names/spanish_female_names";
	private static final String SPANISH_MALE_NAMES = "dictionaries/names/spanish_male_names";
	private static final String SPANISH_SURNAMES = "dictionaries/names/spanish_surnames";
	
	private List<String> spanishFemaleNames;
	private List<String> spanishMaleNames;
	private List<String> spanishSurnames;

	private List<String> asianFemaleNames;
	private List<String> asianMaleNames;
	private List<String> asianSurnames;
	
	private List<String> englishFemaleNames;
	private List<String> englishMaleNames;
	private List<String> englishSurames;
	
	public List<String> getSpanishMaleNames() {
		if (spanishMaleNames == null) {
			spanishMaleNames = loadFromFile(SPANISH_MALE_NAMES);
		}
		return spanishMaleNames;
	}

	public List<String> getSpanishFemaleNames() {
		if (spanishFemaleNames == null) {
			spanishFemaleNames = loadFromFile(SPANISH_FEMALE_NAMES);
		}
		return spanishFemaleNames;
	}

	public List<String> getSpanishSurnames() {
		if (spanishSurnames == null) {
			spanishSurnames = loadFromFile(SPANISH_SURNAMES);
		}
		return spanishSurnames;
	}

	private List<String> loadFromFile(String filename) {
		List<String> retorno = new LinkedList<String>();
		
		try {
			InputStream isr = this.getClass().getClassLoader().getResourceAsStream(filename);

			BufferedReader d = new BufferedReader(new InputStreamReader(isr));

			String line = null;
			while ((line = d.readLine()) != null) {
				retorno.add(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retorno;
	}

}
