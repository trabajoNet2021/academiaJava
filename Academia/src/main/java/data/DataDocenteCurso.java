package data;

import java.sql.*;
import java.util.LinkedList;

import entities.DocenteCurso;

public class DataDocenteCurso {
	
	
	
	public LinkedList<DocenteCurso> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<DocenteCurso> docCursos = new LinkedList<DocenteCurso>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT id_dictado, cargo, "
					+ "id_curso, id_docente FROM docente");
			
			if(rs != null) {
				while(rs.next()) {
					DocenteCurso dc = new DocenteCurso();
					dc.setIdDictado(rs.getInt("id_dictado"));
					dc.setCargo(rs.getString("cargo"));
					dc.setIdCurso(rs.getInt("id_curso"));
					dc.setIdDocente(rs.getInt("id_docente"));
					docCursos.add(dc);
				}
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return docCursos;
	}
	
	
	public DocenteCurso getOne(DocenteCurso docCurso) {
		DocenteCurso dcu = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("SELECT "
					+ "id_dictado, cargo, id_curso, id_docente"
					+ " FROM docente WHERE id_dictado = ?");
			stmt.setInt(1, docCurso.getIdDictado());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				dcu = new DocenteCurso();
				dcu.setIdDictado(rs.getInt("id_dictado"));
				dcu.setCargo(rs.getString("cargo"));
				dcu.setIdCurso(rs.getInt("id_curso"));
				dcu.setIdDocente(rs.getInt("id_docente"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return dcu;
	}
	
	
	public void insert(DocenteCurso docCurso) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("INSERT "
					+ "INTO docente (cargo, id_curso, id_docente) "
					+ "VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, docCurso.getCargo());
			stmt.setInt(2, docCurso.getIdCurso());
			stmt.setInt(3, docCurso.getIdDocente());
			stmt.executeUpdate();
			
			keyResultSet = stmt.getGeneratedKeys();
			
			if(keyResultSet != null && keyResultSet.next()) {
				docCurso.setIdDictado(keyResultSet.getInt(1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbConnector.CloseConnections(keyResultSet, stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	
	public void delete(DocenteCurso docCurso) {
		PreparedStatement stmt = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("DELETE "
					+ "FROM docente WHERE id_dictado = ?");
			stmt.setInt(1, docCurso.getIdDictado());
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
	}
	
	//Done
	public void update(DocenteCurso docCurso) {
		PreparedStatement stmt = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("UPDATE docente "
					+ "SET cargo = ?, id_curso = ?, id_docente = ? "
					+ "WHERE id_dictado = ?");
			stmt.setString(1, docCurso.getCargo());
			stmt.setInt(2, docCurso.getIdCurso());
			stmt.setInt(3, docCurso.getIdDocente());
			stmt.setInt(4, docCurso.getIdDictado());
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
