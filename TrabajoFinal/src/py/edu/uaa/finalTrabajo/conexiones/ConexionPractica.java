package py.edu.uaa.finalTrabajo.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import py.edu.uaa.finalTrabajo.Practica;

public class ConexionPractica {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/registros";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "12345";
	
	
	public boolean insertarPractica(Practica practica) throws SQLException {
 
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
 
		String insertTableSQL = "INSERT INTO practica"
				+ "(nro_cedula, cod_materia, fecha, cantidad_horas) VALUES"
				+ "(?,?,?,?)";
 
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
 
			
			preparedStatement.setInt(1, practica.getNroCedula());
			preparedStatement.setInt(2, practica.getCodigoMateria());
			preparedStatement.setString(3, practica.getFecha());
			preparedStatement.setInt(4, practica.getCantidadHoras());
			
 
			// execute insert SQL stetement
			preparedStatement.executeUpdate();
		
			System.out.println("Record is inserted into PRACTICA table!");
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
