import java.util.Scanner;

public class GeneratoreByteCode {

	public GeneratoreByteCode() {
		// Costruttore vuoto
	}

	public String generare(String linea) {
		String[] token = linea.split(" ");

		if (token[0].equals("intero")) {
			return "int " + token[1];
		}
		if (token[0].equals("int")) {
			return "int " + token[1];
		}

		if (token[0].equals("leggi")) {
			return token[1].replace(";", "") + "=tastiera.nextInt();";
		}
		if (token[1].equals("=")) {
			return linea;
		}

		return "";
	}
}