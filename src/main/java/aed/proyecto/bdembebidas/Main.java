package aed.proyecto.bdembebidas;

import java.util.Scanner;

import aed.proyecto.bdembebidas.functions.Create;
import aed.proyecto.bdembebidas.functions.Read;
import aed.proyecto.bdembebidas.functions.Update;

/**
 * @author Ayoze Amaro
 *
 */
public class Main {

	private static boolean exit = false;
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (exit == false) {
			optionMenu();
		}
	}

	private static void optionMenu() {
		try {
			System.out.println("Bienvenido al Proyecto Java de 'dbPeliculas' realizado con SQLITE");
			System.out.println("");
			System.out.println("1. Listar datos");
			System.out.println("2. Insertar datos");
			System.out.println("3. Eliminar datos");
			System.out.println("4. Modificar datos");
			System.out.println("5. Salir");
			System.out.print("Opción: ");
			String select = sc.nextLine();

			switch (select) {
				case "1":
					readData();
					break;
				case "2":
					createData();
					break;
				case "3":
					break;
				case "4":
					updateData();
					break;
				case "5":
					exit = true;
					System.out.println("");
					System.out.println("¡ADIÓS!");
					break;
				default:
					break;
			}
		} catch(Exception ex) {
			System.out.println("ERROR: " + ex);
		}
	}
	
	private static void readData() {
		try {
			System.out.println("");
			System.out.println("ELIGE LOS DATOS A MOSTRAR");
			System.out.println("1. Actores");
			System.out.println("2. Películas");
			System.out.println("3. Productoras");
			System.out.println("4. Salir");
			System.out.print("Opción: ");
			String select = sc.nextLine();

			switch (select) {
				case "1":
					Read.readActors();
					break;
				case "2":
					Read.readFilms();
					break;
				case "3":
					Read.readProducers();
					break;
				case "4":
					exit = true;
					System.out.println("");
					System.out.println("¡ADIÓS!");
					break;
				default:
					break;
			}
		} catch(Exception ex) {
			System.out.println("ERROR: " + ex);
		}
	}
	
	private static void createData() {
		try {
			System.out.println("");
			System.out.println("¿QUE DESEAS INSERTAR?");
			System.out.println("1. Actores");
			System.out.println("2. Películas");
			System.out.println("3. Productoras");
			System.out.println("4. Salir");
			System.out.print("Opción: ");
			String select = sc.nextLine();

			switch (select) {
				case "1":
					Create.createActor();
					break;
				case "2":
					Create.createFilm();
					break;
				case "3":
					Create.createProducer();
					break;
				case "4":
					exit = true;
					System.out.println("");
					System.out.println("¡ADIÓS!");
					break;
				default:
					break;
			}
		} catch(Exception ex) {
			System.out.println("ERROR: " + ex);
		}
	}
	
	private static void deleteData() {
		try {
			System.out.println("");
			System.out.println("¿QUE DESEAS ELIMINAR?");
			System.out.println("1. Actores");
			System.out.println("2. Películas");
			System.out.println("3. Productoras");
			System.out.println("4. Salir");
			System.out.print("Opción: ");
			String select = sc.nextLine();

			switch (select) {
				case "1":
					break;
				case "2":
					break;
				case "3":
					break;
				case "4":
					exit = true;
					System.out.println("");
					System.out.println("¡ADIÓS!");
					break;
				default:
					break;
			}
		} catch(Exception ex) {
			System.out.println("ERROR: " + ex);
		}
	}
	
	private static void updateData() {
		try {
			System.out.println("");
			System.out.println("¿QUE DESEAS MODIFICAR?");
			System.out.println("1. Actores");
			System.out.println("2. Películas");
			System.out.println("3. Productoras");
			System.out.println("4. Salir");
			System.out.print("Opción: ");
			String select = sc.nextLine();

			switch (select) {
				case "1":
					Read.readActors();
					System.out.print("Elige el actor a modificar: ");
					String codModificarActor = sc.nextLine();
					Update.updateActor(codModificarActor);
					break;
				case "2":
					break;
				case "3":
					Read.readProducers();
					System.out.print("Elige la productora a modificar: ");
					String codModificarProducer = sc.nextLine();
					Update.updateProducer(codModificarProducer);
					break;
				case "4":
					exit = true;
					System.out.println("");
					System.out.println("¡ADIÓS!");
					break;
				default:
					break;
			}
		} catch(Exception ex) {
			System.out.println("ERROR: " + ex);
		}
	}
}
