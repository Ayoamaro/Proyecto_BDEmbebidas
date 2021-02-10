package aed.proyecto.bdembebidas.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Ayoze Amaro
 *
 */
public class Read {

	private static String nom = "C:\\Users\\Ayoze\\eclipse-workspace\\Proyecto_BDEmbebidas\\src\\main\\resources\\report\\dbPeliculas.db";
	private static String url = "jdbc:sqlite:";
	
	/*
	 * --- MOSTRAR ---
	 * Mostrado de todos los actores de la base de datos
	 */
	public static void readActors() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url + nom);
			String sql = "SELECT * FROM actores ORDER BY codActores ASC";
			PreparedStatement consult = con.prepareStatement(sql);
			ResultSet result = consult.executeQuery();
			System.out.println("");
			System.out.println("-------------------------");
			System.out.println("LISTADO DE LOS ACTORES");
			
			while (result.next()) {
				String codActors = result.getString("codActores");
				String name = result.getString("nombreActor");
				String nationality = result.getString("nacionalidad");
				
				System.out.println("{" + codActors + "}:" + " " + name + " - " + nationality);
			}
			System.out.println("-------------------------");
			System.out.println("");
			con.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	
	/*
	 * --- MOSTRAR ---
	 * Mostrado de todos las películas de la base de datos
	 */
	public static void readFilms() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url + nom);
			String sql = "SELECT * FROM peliculas INNER JOIN actores ON actores.codActores = peliculas.codActores "
					+ "INNER JOIN productoras ON productoras.codProductora = peliculas.codProductoras ORDER BY codPeliculas ASC";
			PreparedStatement consult = con.prepareStatement(sql);
			ResultSet result = consult.executeQuery();
			System.out.println("");
			System.out.println("-------------------------");
			System.out.println("LISTADO DE LAS PELÍCULAS");
			
			while (result.next()) {
				String codProducer = result.getString("codPeliculas");
				String name = result.getString("nombrePelicula");
				String genre = result.getString("genero");
				String actor = result.getString("nombreActor");
				String producer = result.getString("nombreProductora");
				
				System.out.println("{" + codProducer + "}:" + " " + name + " - " + genre + " - " + actor + " - " + producer);
			}
			System.out.println("-------------------------");
			System.out.println("");
			con.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	
	/*
	 * --- MOSTRAR ---
	 * Mostrado de todos las productoras de la base de datos
	 */
	public static void readProducers() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url + nom);
			String sql = "SELECT * FROM productoras ORDER BY codProductora ASC";
			PreparedStatement consult = con.prepareStatement(sql);
			ResultSet result = consult.executeQuery();
			System.out.println("");
			System.out.println("-------------------------");
			System.out.println("LISTADO DE LAS PRODUCTORAS");
			
			while (result.next()) {
				String codProducer = result.getString("codProductora");
				String name = result.getString("nombreProductora");
				String country = result.getString("pais");
				String foundation = result.getString("fundacion");
				
				System.out.println("{" + codProducer + "}:" + " " + name + " - " + country + " - " + foundation);
			}
			System.out.println("-------------------------");
			System.out.println("");
			con.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	
}
