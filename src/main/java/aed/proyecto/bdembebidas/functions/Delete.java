package aed.proyecto.bdembebidas.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @author Ayoze Amaro
 *
 */
public class Delete {

	private static String nom = "C:\\Users\\Ayoze\\eclipse-workspace\\Proyecto_BDEmbebidas\\src\\main\\resources\\report\\dbPeliculas.db";
	private static String url = "jdbc:sqlite:";
	private static Scanner sc = new Scanner(System.in);
	
	/*
	 * --- BORRAR ---
	 * Borrado de un actor existente en la base de datos
	 */
	public static void deleteActor(String codActor) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url + nom);
			String sql = "SELECT * FROM actores WHERE codActores = " + codActor;
			PreparedStatement consult = con.prepareStatement(sql);
			ResultSet resultActor = consult.executeQuery();

			boolean delete = false;
			if (resultActor.next()) {
				String codActors = resultActor.getString("codActores");
				String name = resultActor.getString("nombreActor");
				String nationality = resultActor.getString("nacionalidad");
				
				System.out.println("");
				System.out.println("-------------------------");
				System.out.println("BORRADO DE UN ACTOR");
				System.out.println("{" + codActors + "}:" + " " + name + " - " + nationality);
				System.out.println("");
				System.out.print("¿Seguro que quiere borrar este actor? (SI = true o NO = false): ");
				String select = sc.nextLine();
				System.out.println("-------------------------");
				System.out.println("");

				if (select.toLowerCase().equals("si")) {
					delete = true;
				}
			}
			
			if (delete == true) {
				String deleteSQL = "DELETE FROM actores WHERE codActores = " + codActor;
				PreparedStatement deleteActor = con.prepareStatement(deleteSQL);
				deleteActor.executeUpdate();
				
				System.out.println("-- ACTOR BORRADO CON ÉXITO --");
				System.out.println("");
			}
			con.close();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/*
	 * --- BORRAR ---
	 * Borrado de una película existente en la base de datos
	 */
	public static void deleteFilm(String codFilm) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url + nom);
			String sql = "SELECT * FROM peliculas INNER JOIN actores ON actores.codActores = peliculas.codActores "
					+ "INNER JOIN productoras ON productoras.codProductora = peliculas.codProductoras WHERE codPeliculas = " + codFilm;
			PreparedStatement consult = con.prepareStatement(sql);
			ResultSet resultFilm = consult.executeQuery();

			boolean delete = false;
			if (resultFilm.next()) {
				String codFilms = resultFilm.getString("codPeliculas");
				String name = resultFilm.getString("nombrePelicula");
				String country = resultFilm.getString("genero");
				String actor = resultFilm.getString("nombreActor");
				String producer = resultFilm.getString("nombreProductora");
				
				System.out.println("");
				System.out.println("-------------------------");
				System.out.println("BORRADO DE UNA PELÍCULA");
				System.out.println("{" + codFilms + "}:" + " " + name + " - " + country + " - " + actor + " - " + producer);
				System.out.println("");
				System.out.print("¿Seguro que quiere borrar esta película? (SI = true o NO = false): ");
				String select = sc.nextLine();
				System.out.println("-------------------------");
				System.out.println("");

				if (select.toLowerCase().equals("si")) {
					delete = true;
				}
			}
			
			if (delete == true) {
				String deleteSQL = "DELETE FROM peliculas WHERE codPeliculas = " + codFilm;
				PreparedStatement deleteFilm = con.prepareStatement(deleteSQL);
				deleteFilm.executeUpdate();
				
				System.out.println("-- PELÍCULA BORRADA CON ÉXITO --");
				System.out.println("");
			}
			con.close();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/*
	 * --- BORRAR ---
	 * Borrado de una productora existente en la base de datos
	 */
	public static void deleteProducer(String codProducer) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url + nom);
			String sql = "SELECT * FROM productoras WHERE codProductora = " + codProducer;
			PreparedStatement consult = con.prepareStatement(sql);
			ResultSet resultProducer = consult.executeQuery();

			boolean delete = false;
			if (resultProducer.next()) {
				String codProducers = resultProducer.getString("codProductora");
				String name = resultProducer.getString("nombreProductora");
				String country = resultProducer.getString("pais");
				String foundation = resultProducer.getString("fundacion");
				
				System.out.println("");
				System.out.println("-------------------------");
				System.out.println("BORRADO DE UNA PRODUCTORA");
				System.out.println("{" + codProducers + "}:" + " " + name + " - " + country + " - " + foundation);
				System.out.println("");
				System.out.print("¿Seguro que quiere borrar esta productora? (SI = true o NO = false): ");
				String select = sc.nextLine();
				System.out.println("-------------------------");
				System.out.println("");

				if (select.toLowerCase().equals("si")) {
					delete = true;
				}
			}
			
			if (delete == true) {
				String deleteSQL = "DELETE FROM productoras WHERE codProductora = " + codProducer;
				PreparedStatement deleteProducer = con.prepareStatement(deleteSQL);
				deleteProducer.executeUpdate();
				
				System.out.println("-- PRODUCTORA BORRADA CON ÉXITO --");
				System.out.println("");
			}
			con.close();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
