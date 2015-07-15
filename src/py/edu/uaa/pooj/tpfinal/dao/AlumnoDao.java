package py.edu.uaa.pooj.tpfinal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import py.edu.uaa.pooj.tpfinal.model.Alumno;

/**
 * 
 * @author gsoria
 * Clase que maneja el acceso a la base de datos
 * Referencia: https://es.wikipedia.org/wiki/Data_Access_Object
 * 
 */

public class AlumnoDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/practica";
	private static final String DB_USER = "gsoria";
	private static final String DB_PASSWORD = "postgres";
	
 
	public boolean insertarAlumno(Alumno alumno) throws SQLException {
 
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
 
		String insertTableSQL = "INSERT INTO alumno"
				+ "(nro_cedula, nombre_apellido, email, nro_celular) VALUES"
				+ "(?,?,?,?)";
 
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
 
			//del alumno que se recibe como parametro se obtienen 
			//las propiedades que se tienen que insertar en la base de datos
			
			preparedStatement.setInt(1, alumno.getNroCedula());
			preparedStatement.setString(2, alumno.getNombreApellido());
			preparedStatement.setString(3, alumno.getEmail());
			preparedStatement.setString(4, alumno.getNroCelular());
 
			// execute insert SQL stetement
			preparedStatement.executeUpdate();
		
			System.out.println("Record is inserted into ALUMNO table!");
			return true;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				preparedStatement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
 
	}
 
	private static Connection getDBConnection() {
 
		Connection dbConnection = null;
 
		try {
 
			Class.forName(DB_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
 
			dbConnection = DriverManager.getConnection(
                            DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
 
	}
	
	
}
