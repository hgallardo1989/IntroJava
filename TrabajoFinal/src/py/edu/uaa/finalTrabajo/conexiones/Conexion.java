package py.edu.uaa.finalTrabajo.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import py.edu.uaa.finalTrabajo.*;

public class Conexion {
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/registros";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "12345";
	
	
	
//	public static boolean validarSiAlumnoEstaEnCurso(JTextField textnrocedula, JTextField textcodmateria) throws SQLException{
//				Connection dbConnection = null;
//				PreparedStatement preparedStatement = null;
//		 
//				String selectSQL = "select * from curso where nro_cedula = ? and cod_materia = ? ";
//		
//				
//				try {
//					dbConnection = getDBConnection();
//					preparedStatement = dbConnection.prepareStatement(selectSQL);
//		 
//					//se pasan como parametro los valores de nro de cedula (obtenido de alumno) y nro de curso (obtenido de curso), para
//					//consultar en la tabla que tiene las relaciones de cuales son los cursos a los que esta inscripto un alumno
//					
//					preparedStatement.setInt(1, textnrocedula.getNroCedula());
//					preparedStatement.setInt(2, textcodmateria.getCodigoMateria());
//		
//					// execute insert SQL stetement
//					ResultSet rs = 	preparedStatement.executeQuery();
//					if (rs.next()) {
//						System.out.println("Alumno está en matriculado en el curso");
//						return true;
//					} else {
//						System.out.println("Alumno NO está en matriculado en el curso");
//						return false;
//				}
//		 
//				} catch (SQLException e) {
//		 
//					System.out.println(e.getMessage());
//					return false;
//					
//		 
//				} finally {
//		 
//					if (preparedStatement != null) {
//						preparedStatement.close();
//					}
//		 
//					if (dbConnection != null) {
//						dbConnection.close();
//					}
//		
//				}
//				
//			}
//	 
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
