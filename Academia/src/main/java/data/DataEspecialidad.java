package data;

import java.sql.*;
import java.util.LinkedList;
import entities.Especialidad;


public class DataEspecialidad {


	public LinkedList<Especialidad> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Especialidad> especialidades = new LinkedList<Especialidad>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT id_especialidad, descripcion, "
					+ "id_plan FROM especialidad");
			
			if(rs != null) {
				while(rs.next()) {
					Especialidad esp = new Especialidad();
					esp.setIdEspecialidad(rs.getInt("id_especialidad"));
					esp.setDescripcion(rs.getString("descripcion"));
					esp.setIdPlan(rs.getInt("id_plan"));
					especialidades.add(esp);
				}
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return especialidades;
	}
	

	public Especialidad getOne(Especialidad especialidad) {
		Especialidad esp = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("SELECT "
					+ "id_especialidad, descripcion, id_plan "
					+ "FROM especialidad WHERE id_especialidad = ?");
			stmt.setInt(1, especialidad.getIdEspecialidad());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				esp = new Especialidad();
				esp.setIdEspecialidad(rs.getInt("id_especialidad"));
				esp.setDescripcion(rs.getString("descripcion"));
				esp.setIdPlan(rs.getInt("id_plan"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return esp;
	}
	
	
	public void insert(Especialidad especialidad) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("INSERT "
					+ "INTO especialidad (descripcion, id_plan) "
					+ "VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, especialidad.getDescripcion());
			stmt.setInt(2, especialidad.getIdPlan());
			stmt.executeUpdate();
			
			keyResultSet = stmt.getGeneratedKeys();
			
			if(keyResultSet != null && keyResultSet.next()) {
				especialidad.setIdEspecialidad(keyResultSet.getInt(1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbConnector.CloseConnections(keyResultSet, stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	
	public void delete(Especialidad especialidad) {
		PreparedStatement stmt = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("DELETE "
					+ "FROM especialidad WHERE id_especialidad = ?");
			stmt.setInt(1, especialidad.getIdEspecialidad());
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
	}
	
	
	public void update(Especialidad especialidad) {
		PreparedStatement stmt = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("UPDATE especialidad "
					+ "SET descripcion = ?, id_plan = ? WHERE id_especialidad = ?");
			stmt.setString(1, especialidad.getDescripcion());
			stmt.setInt(2, especialidad.getIdPlan());
			stmt.setInt(3, especialidad.getIdEspecialidad());
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	
}
