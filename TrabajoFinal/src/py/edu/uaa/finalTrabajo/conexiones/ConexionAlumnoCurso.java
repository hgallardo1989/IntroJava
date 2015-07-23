package py.edu.uaa.finalTrabajo.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import py.edu.uaa.finalTrabajo.AlumnoCurso;

public class ConexionAlumnoCurso {
	
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/registros";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "12345";
	
	
	
	 
	public boolean insertarAlumnoCurso(AlumnoCurso curso) throws SQLException {
 
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
 
		String insertTableSQL = "INSERT INTO curso"
				+ "(nro_cedula, cod_materia) VALUES"
				+ "(?,?)";
 
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
 
			//del alumno que se recibe como parametro se obtienen 
			//las propiedades que se tienen que insertar en la base de datos
			
			preparedStatement.setInt(1, curso.getNroCedula());
			preparedStatement.setInt(2, curso.getCodMateria());
			
			// execute insert SQL stetement
			preparedStatement.executeUpdate();
		
			System.out.println("Record is inserted into CURSO table!");
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
