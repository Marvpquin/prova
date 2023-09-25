import java.util.ArrayList;
import java.util.List;

public class AnalizzatoreSemantico {

	public List<String> tabellaSimboli;

	public AnalizzatoreSemantico() {
		tabellaSimboli = new ArrayList<>();
	}

	public void Analizzare(String linea, List<String> dizionario) {
		linea = linea.replace(";", "");
		String[] token = linea.split(" ");
		if (token[0].equals("intero") ||
				token[0].equals("int")) {
			// Aggiungi alla tabella dei simboli
			if (èNellaTabellaSimboli(token[1])) {
				System.out.println("Variabile già dichiarata: " + token[1]);
				return;
			}
			tabellaSimboli.add(token[1]);
			return;
		}

		// Percorre tutte le parole della linea
		for (int i = 0; i < token.length; i++) {
			// Verifica se è una variabile
			if (èVariabile(token[i], dizionario)) {
				if (èNellaTabellaSimboli(token[i])) {
					return;
				} else {
					System.out.println("Variabile non dichiarata: " + token[i]);
				}
			}
		}
	}

	public boolean èVariabile(String parola, List<String> dizionario) {
		if (parola.matches("[a-z][a-z0-9]{0,9}")) {
			for (int i = 0; i < dizionario.size(); i++) {
				if (dizionario.get(i).equals(parola)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean èNellaTabellaSimboli(String parola) {
		for (int i = 0; i < tabellaSimboli.size(); i++) {
			if (tabellaSimboli.get(i).equals(parola)) {
				return true;
			}
		}
		return false;
	}
}