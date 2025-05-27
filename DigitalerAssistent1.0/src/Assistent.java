import java.util.Scanner;

public class Assistent {
	public static String save;

	public static String getSave() {
		return save;
	}

	public static void setSave(String save) {
		Assistent.save = save;
	}

	public static String echo(String teile) {//gibt die eingabe einfach zurück
		return teile;
	}

	public static String capitalecho(String rückgabe) {//schreibt es groß durch tuUppercase

		return rückgabe.toUpperCase();
	}

	public static void math(String[] wert) {//nimmt String an und wandelt es um durch valueof
		int ergebnis = 0;
		int anzahl = wert.length;
		int[] r;
		r = new int[anzahl - 2];

		for (int i = 0; i < r.length; i++) {

			r[i] = Integer.valueOf(wert[i + 1]);
		}

		if (wert[anzahl - 1].contains("+")) {
			for (int i = 0; i < r.length; i++) {

				ergebnis += r[i];
			}
			System.out.println(ergebnis);

		}
		if (wert[anzahl - 1].contains("*")) {
			ergebnis = 1;
			for (int i = 0; i < r.length; i++) {

				ergebnis *= r[i];
			}
			System.out.println(ergebnis);
		}

	}

	public static void mathdec(String[] wert) {//double rechner
		double ergebnis = 0;
		int anzahl = wert.length;
		double[] r;
		r = new double[anzahl - 2];

		for (int i = 0; i < r.length; i++) {

			r[i] = Double.valueOf(wert[i + 1]);
		}

		if (wert[anzahl - 1].contains("+")) {
			for (int i = 0; i < r.length; i++) {

				ergebnis += r[i];
			}
			System.out.println(ergebnis);

		}
		if (wert[anzahl - 1].contains("*")) {
			ergebnis = 1;
			for (int i = 0; i < r.length; i++) {

				ergebnis *= r[i];
			}
			System.out.println(ergebnis);
		}
	}

	public static boolean exit() {
		return false;

	}

	public static void main(String[] args) {
		System.out.println("Willkommen bei Digitaler Assistent Version 1.0!");
		boolean kondition = true;
		Scanner scanner = new Scanner(System.in);
		
		while (kondition) {
			System.out.println("Was darf ich für Sie tun?");
			String eingabe = scanner.nextLine();
			String[] teile = eingabe.split(" ");
			//übergabe an die methode
			if (teile[0].equals("echo")) {
				for (int i = 1; i < teile.length; i++) {
					System.out.print(echo(teile[i] + " "));
				}
				System.out.println();
			}
			if (teile[0].equals("capitalecho")) {
				for (int i = 1; i < teile.length; i++) {
					System.out.print(capitalecho(teile[i] + " "));
				}
				System.out.println();

			}
			if (teile[0].equals("math")) {
				math(teile);
			}
			if (teile[0].equals("mathdec")) {
				mathdec(teile);
			}

			if (teile[0].equals("store")) {
				String show = eingabe.replaceAll(teile[0], "");
				save = show;//speichert auf save
				System.out.println("Stored" + "'" + save + "'");

			}
			if (teile[0].equals("show")) {//holt es von save ab
				System.out.println("Stored" + "'" + save + "'");
			}
			if (teile[0].equals("exit")) {//beendet das Programm durch false
				kondition = exit();
				System.out.println("BYE,BYE!!!");
			}
		}scanner.close();
	}
}
