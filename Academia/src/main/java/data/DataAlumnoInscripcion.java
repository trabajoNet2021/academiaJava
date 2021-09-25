package data;

import java.sql.*;
import java.util.LinkedList;

import entities.AlumnoInscripcion;

public class DataAlumnoInscripcion {

	
	public LinkedList <AlumnoInscripcion> list(){
		
		Statement stmt = null;
		ResultSet rs = null;
		
		
		LinkedList<AlumnoInscripcion> alus = new LinkedList <>();
		
		try {
			
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM alumno_inscripcion");
			
			while (rs != null && rs.next()) {
				
				AlumnoInscripcion a = new AlumnoInscripcion();
				
				a.setIdInscripcion(rs.getInt("id_inscripcion"));
				a.setIdAlumno(rs.getInt("id_alumno"));
				alus.add(a);
			}
			
			return alus;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
		}
	}

	

	public AlumnoInscripcion search(AlumnoInscripcion a) {

		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		AlumnoInscripcion alu = new AlumnoInscripcion();
	
		try {
			
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement("SELECT * FROM alumno_inscripcion WHERE id_inscripcion = ?");
			stmt.setInt(1, a.getIdInscripcion());
		
			rs = stmt.executeQuery();
		
			if (rs.next()) {
				alu.setIdInscripcion(rs.getInt("id_inscripcion"));
				alu.setIdAlumno(rs.getInt("id_alumno"));
			}
		
			return alu;
		
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbConnector.CloseConnections(rs, stmt);
		}
	}
	
	
	
	public void newAlumno(AlumnoInscripcion newAlu) {
		
		
		ResultSet keyRS = null;
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("INSERT INTO alumno_inscripcion(id_alumno) "+"VALUES(?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, newAlu.getIdAlumno());
			stmt.executeUpdate();
			keyRS = stmt.getGeneratedKeys();
			
			if(keyRS!=null && keyRS.next()) {
				newAlu.setIdInscripcion(keyRS.getInt(1));
			}

			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(keyRS, stmt);
		}
	}
	
	
	
	public void delete(AlumnoInscripcion updAlu) {
		
		PreparedStatement stmt = null;
		
		try {

			stmt = DbConnector.getInstancia().getConn().prepareStatement("DELETE FROM alumno_inscripcion WHERE id_inscripcion=? ");
			stmt.setInt(1, updAlu.getIdInscripcion());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			DbConnector.CloseConnections(stmt);
		}
	}
	
	
	
	public void update(AlumnoInscripcion updAlu) {
		
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("update alumno_inscripcion " + "set id_alumno = ? " + "where id_inscripcion = ?");
			stmt.setInt(1, updAlu.getIdAlumno());
			stmt.setInt(2, updAlu.getIdInscripcion());

			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbConnector.CloseConnections(stmt);
		}
	}
	
}