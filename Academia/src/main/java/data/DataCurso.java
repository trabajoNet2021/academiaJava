package data;

import java.sql.*;
import java.util.LinkedList;

import entities.Curso;

public class DataCurso{
	

		
	public LinkedList<Curso> list() {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		LinkedList<Curso> crs = new LinkedList<>();
		
		try {
			
			
			
			stmt = DbConnector.getInstancia().getConn().createStatement();
			
			rs = stmt.executeQuery("select * from curso");
			
			while (rs != null && rs.next()) {
				Curso c = new Curso ();
				
				c.setIdCurso(rs.getInt("id_curso"));
				c.setCupo(rs.getInt("cupo"));
				c.setDescripcion(rs.getString("descripcion"));
				c.setAnioCalendario(rs.getInt("anio_calendario"));
				
				crs.add(c);
			}
			
			return crs;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(stmt != null) {stmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();}	
		}
	}
	
	
	
	public Curso search (Curso c) {
		
		
		PreparedStatement stmt = null;
		ResultSet rs= null;
		
		Curso cr = new Curso();
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from curso where id_curso=?");
			
			stmt.setInt(1, c.getIdCurso());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				cr.setIdCurso(rs.getInt("id_curso"));
				cr.setCupo(rs.getInt("cupo"));
				cr.setDescripcion(rs.getString("descripcion"));
				cr.setAnioCalendario(rs.getInt("anio_calendario"));
			}
			
			return cr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();}	
		}
		
	}
	
	
	
	public void newCurso(Curso newCr) {
		
		ResultSet keyRS = null;
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("insert into curso(cupo,descripcion,anio_calendario) "+"values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, newCr.getCupo());
			stmt.setString(2, newCr.getDescripcion());
			stmt.setInt(3, newCr.getAnioCalendario());
			
			stmt.executeUpdate();
			
			keyRS = stmt.getGeneratedKeys();
			
			if(keyRS != null && keyRS.next()) {
				newCr.setIdCurso(keyRS.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(keyRS != null) {keyRS.close();}
				if(stmt != null) {stmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();}
		}
	}
	
	
	
	public void delete(Curso c) {
		
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from curso where id_curso=?");
			
			stmt.setInt(1, c.getIdCurso());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {stmt.close();}
			} catch(SQLException e) {
				e.printStackTrace();}
		}
	}
	
	
	
	public void update(Curso updCr) {
		
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("update curso "+"set cupo = ?,descripcion = ?,anio_calendario = ? "+"where id_curso = ?");
			stmt.setInt(1, updCr.getCupo());
			stmt.setString(2, updCr.getDescripcion());
			stmt.setInt(3, updCr.getAnioCalendario());
			stmt.setInt(4, updCr.getIdCurso());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {stmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();}
		}
	}

}