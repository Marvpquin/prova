import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Compilatore {

	public List<String> alfabeto;
	public List<String> esempio;
	public List<String> espressioni;
	public List<String> dizionario;

	public Compilatore() {
		// Costruttore vuoto
	}

	public void Iniziare() throws IOException {
		String linea;
		System.out.println("Inizio del compilatore...");

		LeggiFile lettore = new LeggiFile();
		alfabeto = lettore.leggi("C:\\codigo\\alfabeto.txt");
		esempio = lettore.leggi("C:\\codigo\\esempio.txt");
		espressioni = lettore.leggi("C:\\codigo\\espressioni.txt");
		dizionario = lettore.leggi("C:\\codigo\\dizionario.txt");

		for (int i = 0; i < alfabeto.size(); i++) {
			System.out.println(alfabeto.get(i));
		}
		System.out.println("--------------");

		AnalizzatoreLessicale lessico = new AnalizzatoreLessicale();
		for (int i = 0; i < esempio.size(); i++) {
			linea = esempio.get(i);
			lessico.analizzare(linea, alfabeto);
		}

		AnalizzatoreSintattico sintattico = new AnalizzatoreSintattico();
		for (int i = 0; i < esempio.size(); i++) {
			linea = esempio.get(i);
			sintattico.analizzare(linea, espressioni);
		}

		System.out.println("Analisi semantica in corso...");
		AnalizzatoreSemantico semantico = new AnalizzatoreSemantico();
		for (int i = 0; i < esempio.size(); i++) {
			linea = esempio.get(i);
			semantico.Analizzare(linea, dizionario);
		}
		System.out.println("Fine dell'analisi semantica");

		String codiceByte = "";
		GeneratoreCodiceByte generatore = new GeneratoreCodiceByte();
		codiceByte += "Scanner tastiera = new Scanner(System.in);\n";

		for (int i = 0; i < esempio.size(); i++) {
			linea = esempio.get(i);
			codiceByte += generatore.generare(linea) + "\n";
			System.out.print(codiceByte);
		}
	}
}
