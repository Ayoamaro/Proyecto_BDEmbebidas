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
public class Update {

	private static String nom = "C:\\Users\\Ayoze\\eclipse-workspace\\Proyecto_BDEmbebidas\\src\\main\\resources\\report\\dbPeliculas.db";
	private static String url = "jdbc:sqlite:";
	private static Scanner sc = new Scanner(System.in);
	
	/*
	 * --- MODIFICACIÓN ---
	 * Modificación de un actor existente en la base de datos
	 */
	public static void updateActor(String codActor) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url + nom);
			String sql = "UPDATE actores SET nombreActor=?, nacionalidad=? WHERE codActores = " + codActor;
			PreparedStatement consult = con.prepareStatement(sql);

			String sql2 = "SELECT * FROM actores WHERE codActores = " + codActor;
			PreparedStatement modify = con.prepareStatement(sql2);
			ResultSet result = modify.executeQuery();

			if (result.next()) {
				System.out.println("");
				System.out.println("-------------------------");
				System.out.println("MODIFICACIÓN DE UN ACTOR");
				System.out.print("Nombre del actor (Actual: " + result.getString("nombreActor") + "): ");
				String newNomActor = sc.nextLine();
				System.out.print("Nacionalidad (Actual: " + result.getString("nacionalidad") + "): ");
				String newNationality = sc.nextLine();
				System.out.println("-------------------------");
				System.out.println("");

				consult.setString(1, newNomActor);
				consult.setString(2, newNationality);
			}
			consult.executeUpdate();
			con.close();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/*
	 * --- MODIFICACIÓN ---
	 * Modificación de una película existente en la base de datos
	 */
	public static void updateFilm(String codFilm) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url + nom);
			String sql = "UPDATE peliculas SET nombrePelicula=?, genero=?, codActores=?, codProductoras=? WHERE codPeliculas = " + codFilm;
			PreparedStatement consult = con.prepareStatement(sql);
			
			String sql2 = "SELECT * FROM peliculas INNER JOIN actores ON actores.codActores = peliculas.codActores "
					+ "INNER JOIN productoras ON productoras.codProductora = peliculas.codProductoras WHERE codPeliculas = " + codFilm;
			PreparedStatement modify = con.prepareStatement(sql2);
			ResultSet result = modify.executeQuery();

			if (result.next()) {
				System.out.println("");
				System.out.println("-------------------------");
				System.out.println("MODIFICACIÓN DE UNA PELÍCULA");
				System.out.print("Nombre de la película (Actual: " + result.getString("nombrePelicula") + "): ");
				String newNomFilm = sc.nextLine();
				System.out.print("Género (Actual: " + result.getString("genero") + "): ");
				String newGenre = sc.nextLine();
				System.out.print("Código de Actor (Actual: " + result.getString("nombreActor") + "): ");
				String newCodActor = sc.nextLine();
				System.out.print("Código de Productora (Actual: " + result.getString("nombreProductora") + "): ");
				String newCodProducer = sc.nextLine();
				System.out.println("-------------------------");
				System.out.println("");

				consult.setString(1, newNomFilm);
				consult.setString(2, newGenre);
				consult.setInt(3, Integer.parseInt(newCodActor));
				consult.setInt(4, Integer.parseInt(newCodProducer));
			}
			consult.executeUpdate();
			con.close();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/*
	 * --- MODIFICACIÓN ---
	 * Modificación de un actor existente en la base de datos
	 */
	public static void updateProducer(String codProducer) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url + nom);
			String sql = "UPDATE productoras SET nombreProductora=?, pais=?, fundacion=? WHERE codProductora = " + codProducer;
			PreparedStatement consult = con.prepareStatement(sql);

			String sql2 = "SELECT * FROM productoras WHERE codProductora = " + codProducer;
			PreparedStatement modify = con.prepareStatement(sql2);
			ResultSet result = modify.executeQuery();

			if (result.next()) {
				System.out.println("");
				System.out.println("-------------------------");
				System.out.println("MODIFICACIÓN DE UNA PRODUCTORA");
				System.out.print("Nombre de la productora (Actual: " + result.getString("nombreProductora") + "): ");
				String newNomProducer = sc.nextLine();
				System.out.print("País (Actual: " + result.getString("pais") + "): ");
				String newCountry = sc.nextLine();
				System.out.print("Fundación (Actual: " + result.getString("fundacion") + "): ");
				String newFoundation = sc.nextLine();
				System.out.println("-------------------------");
				System.out.println("");

				consult.setString(1, newNomProducer);
				consult.setString(2, newCountry);
				consult.setInt(3, Integer.parseInt(newFoundation));
			}
			consult.executeUpdate();
			con.close();
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
