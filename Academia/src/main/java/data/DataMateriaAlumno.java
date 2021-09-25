package data;
import java.sql.*;
import java.util.LinkedList;

import entities.MateriaAlumno;


public class DataMateriaAlumno{
	

	
	public LinkedList <MateriaAlumno> list(){
		
		
		Statement stmt = null;
		ResultSet rs = null;
		
		
		LinkedList<MateriaAlumno> matalu = new LinkedList <>();
		
		try {
			
			
			
			stmt = DbConnector.getInstancia().getConn().createStatement();
			
			rs = stmt.executeQuery("select * from materia_alumno");
			
			while (rs != null && rs.next()) {
				
				MateriaAlumno ma = new MateriaAlumno();
				
				ma.setIdMateria(rs.getInt("id_materia"));
				ma.setIdInscripcion(rs.getInt("id_inscripcion"));
				ma.setCondicion(rs.getString("condicion"));
				ma.setNota(rs.getInt("nota"));

				matalu.add(ma);
			}
			
			return matalu;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			
			try {
				if(rs != null) {rs.close();}
				if(stmt != null) {stmt.close();}
			} catch(SQLException e) {
				e.printStackTrace();}
		}
	}
	
	
	public MateriaAlumno search(MateriaAlumno ma) {
		
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		MateriaAlumno matalu = new MateriaAlumno();
	
		try {
			
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from materia_alumno where id_materia = ? and id_inscripcion = ?");
		
			stmt.setInt(1, ma.getIdMateria());
			stmt.setInt(2, ma.getIdInscripcion());
		
			rs = stmt.executeQuery();
		
			if (rs.next()) {
				matalu.setIdMateria(rs.getInt("id_materia"));
				matalu.setIdInscripcion(rs.getInt("id_inscripcion"));
				matalu.setCondicion(rs.getString("condicion"));
				matalu.setNota(rs.getInt("nota"));
			}
		
			return matalu;
		
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(stmt != null) {stmt.close();}
			} catch(SQLException e) {
				e.printStackTrace();}
		}
	}
	
	
	
	public void newMateriaAlumno (MateriaAlumno newMatAlu) {
		
		
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("insert into materia_alumno(id_materia,id_inscripcion,condicion,nota) "+"values(?,?,?,?)");
			
			stmt.setInt(1, newMatAlu.getIdMateria());
			stmt.setInt(2, newMatAlu.getIdInscripcion());
			stmt.setString(3, newMatAlu.getCondicion());
			stmt.setInt(4, newMatAlu.getNota());
			
			stmt.executeUpdate();
			

			
		} catch(SQLException e) {
		e.printStackTrace();
		}
		finally {
			try {
				if(stmt != null) {stmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();}
		}
	}
	
	
	public void delete(MateriaAlumno ma) {
		
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from materia_alumno where id_materia=? and id_inscripcion=?");
			
			stmt.setInt(1, ma.getIdMateria());
			stmt.setInt(2, ma.getIdInscripcion());
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null){stmt.close();}
			}catch(SQLException e) {
				e.printStackTrace();}
		}
		
	}
	
	
	
	public void update(MateriaAlumno updMatAlu) {
		
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("update materia_alumno " + "set condicion = ?, nota = ? " + "where id_materia = ? and id_inscripcion = ?");
			stmt.setString(1, updMatAlu.getCondicion());
			stmt.setInt(2, updMatAlu.getNota());
			stmt.setInt(3, updMatAlu.getIdMateria());
			stmt.setInt(4, updMatAlu.getIdInscripcion());

			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null){stmt.close();}
			}catch(SQLException e) {
				e.printStackTrace();}
		}
	}


}