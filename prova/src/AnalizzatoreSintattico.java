import java.util.List;

public class AnalizzatoreSintattico {

	public AnalizzatoreSintattico() {
		// Costruttore vuoto
	}

	public void analizzare(String linea, List<String> espressioni) {
		boolean risultato = false;
		for (int i = 0; i < espressioni.size(); i++) {
			if (linea.trim().matches(espressioni.get(i))) {
				System.out.println(linea + ": ok");
				return;
			}
		}

		if (risultato) {
			System.out.println(linea + ": ok");
		} else {
			System.out.println("Errore nella linea: " + linea);
		}
	}
}