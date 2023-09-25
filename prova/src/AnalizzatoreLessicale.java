import java.util.List;

public class AnalizzatoreLessicale {

	public AnalizzatoreLessicale() {
		// Costruttore vuoto
	}

	public void analizzare(String linea, List<String> alfabeto) {
		String caratteri = alfabeto.get(0);

		for (int i = 0; i < linea.length(); i++) {
			char lettera = linea.charAt(i);
			boolean errore = true;
			for (int j = 0; j < caratteri.length(); j++) {
				if (lettera == caratteri.charAt(j)) {
					errore = false;
				}
			}
			if (errore) {
				System.out.println("Carattere non valido: " + lettera);
				return;
			}
		}
		System.out.println("Analisi lessicale riuscita!");
	}
}