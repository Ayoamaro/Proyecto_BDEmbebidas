package aed.proyecto.bdembebidas.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @author Ayoze Amaro
 *
 */
public class Create {

	private static String nom = "C:\\Users\\Ayoze\\eclipse-workspace\\Proyecto_BDEmbebidas\\src\\main\\resources\\report\\dbPeliculas.db";
	private static String url = "jdbc:sqlite:";
	private static Scanner sc = new Scanner(System.in);
	
	/*
	 * --- INSERTAR ---
	 * Insercción de un nuevo actor en la base de datos
	 */
	public static void createActor() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url + nom);
			String sql = "INSERT INTO actores (nombreActor, nacionalidad) VALUES (?,?)";
			PreparedStatement consult = con.prepareStatement(sql);
			
			System.out.println("");
			System.out.println("-------------------------");
			System.out.println("INSERCIÓN DE UN ACTOR");
			System.out.print("Nombre del actor: ");
			String name = sc.nextLine();
			System.out.print("Nacionalidad: ");
			String nationality = sc.nextLine();
			System.out.println("-------------------------");
			System.out.println("");

			consult.setString(1, name);
			consult.setString(2, nationality);
			consult.executeUpdate();
			con.close();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/*
	 * --- INSERTAR ---
	 * Insercción de un nueva película en la base de datos
	 */
	public static void createFilm() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url + nom);
			String sql = "INSERT INTO peliculas (nombrePelicula, genero, codActores, codProductoras) VALUES (?,?,?,?)";
			PreparedStatement consult = con.prepareStatement(sql);
			
			System.out.println("");
			System.out.println("-------------------------");
			System.out.println("INSERCIÓN DE UNA PELÍCULA");
			System.out.print("Nombre de la película: ");
			String name = sc.nextLine();
			System.out.print("Género: ");
			String genre = sc.nextLine();
			System.out.print("Código del actor: ");
			String codActor = sc.nextLine();
			System.out.print("Código de la productora: ");
			String codProducer = sc.nextLine();
			System.out.println("-------------------------");
			System.out.println("");

			consult.setString(1, name);
			consult.setString(2, genre);
			consult.setInt(3, Integer.parseInt(codActor));
			consult.setInt(4, Integer.parseInt(codProducer));
			consult.executeUpdate();
			con.close();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/*
	 * --- INSERTAR ---
	 * Insercción de un nueva productora en la base de datos
	 */
	public static void createProducer() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url + nom);
			String sql = "INSERT INTO productoras (nombreProductora, pais, fundacion) VALUES (?,?,?)";
			PreparedStatement consult = con.prepareStatement(sql);
			
			System.out.println("");
			System.out.println("-------------------------");
			System.out.println("INSERCIÓN DE UNA PRODUCTORA");
			System.out.print("Nombre de la productora: ");
			String name = sc.nextLine();
			System.out.print("País: ");
			String country = sc.nextLine();
			System.out.print("Fundación: ");
			String foundation = sc.nextLine();
			System.out.println("-------------------------");
			System.out.println("");

			consult.setString(1, name);
			consult.setString(2, country);
			consult.setInt(3, Integer.parseInt(foundation));
			consult.executeUpdate();
			con.close();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
