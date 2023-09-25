import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeggiFile {

	public LeggiFile() {

	}

	public List<String> leggi(String nomeFile) throws IOException {
		List<String> dati = new ArrayList<>();
		String linea;
		try {
			FileReader lettore = new FileReader(nomeFile);
			BufferedReader buffer = new BufferedReader(lettore);

			while ((linea = buffer.readLine()) != null) {
				dati.add(linea);
			}

			buffer.close();
			lettore.close();

		} catch (java.io.FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file " + nomeFile);
		}

		return dati;
	}
}