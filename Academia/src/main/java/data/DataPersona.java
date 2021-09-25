package data;

import java.sql.*;
import java.util.LinkedList;

import entities.Persona;

public class DataPersona{
	

	
	public LinkedList <Persona> list(){
		
		
		Statement stmt = null;
		ResultSet rs = null;
		
		
		LinkedList<Persona> pers = new LinkedList <>();
		
		try {
			

			stmt = DbConnector.getInstancia().getConn().createStatement();
			
			rs = stmt.executeQuery("select * from persona");
			
			while (rs != null && rs.next()) {
				
				Persona p = new Persona();
				
				p.setIdPersona(rs.getInt("id_persona"));
				p.setLegajo(rs.getInt("legajo"));
				p.setTipoPersona(rs.getString("tipo_persona"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDireccion(rs.getString("direccion"));
				p.setEmail(rs.getString("email"));
				p.setTelefono(rs.getString("telefono"));
				p.setFechaNacimiento(rs.getString("fecha_nac"));
				p.setNombreUsuario(rs.getString("nombre_usuario"));
				p.setClave(rs.getString("clave"));

				pers.add(p);
			}
			
			return pers;
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
	
	
	
	public Persona search(Persona p) {
		
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		Persona per = new Persona();
	
		try {
			
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from persona where id_persona = ?");
		
			stmt.setInt(1, p.getIdPersona());
		
			rs = stmt.executeQuery();
		
			if (rs.next()) {
				per.setIdPersona(rs.getInt("id_persona"));
				per.setLegajo(rs.getInt("legajo"));
				per.setTipoPersona(rs.getString("tipo_persona"));
				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				per.setDireccion(rs.getString("direccion"));
				per.setEmail(rs.getString("email"));
				per.setTelefono(rs.getString("telefono"));
				per.setFechaNacimiento(rs.getString("fecha_nac"));
				per.setNombreUsuario(rs.getString("nombre_usuario"));
				per.setClave(rs.getString("clave"));
			}
		
			return per;
		
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
	
	
	
	public void newPersona (Persona newPer) {
		
		
		ResultSet keyRS = null;
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("insert into persona(nombre,apellido,direccion,email,telefono,fecha_nac,legajo,tipo_persona,nombre_usuario,clave) "+"values(?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, newPer.getNombre());
			stmt.setString(2, newPer.getApellido());
			stmt.setString(3, newPer.getDireccion());
			stmt.setString(4, newPer.getEmail());
			stmt.setString(5, newPer.getTelefono());
			stmt.setString(6, newPer.getFechaNacimiento());
			stmt.setInt(7, newPer.getLegajo());
			stmt.setString(8, newPer.getTipoPersona());
			stmt.setString(9, newPer.getNombreUsuario());
			stmt.setString(10, newPer.getClave());
			
			
			stmt.executeUpdate();
			
			keyRS = stmt.getGeneratedKeys();
			
			if(keyRS!=null && keyRS.next()) {
				newPer.setIdPersona(keyRS.getInt(1));
			}

			
		} catch(SQLException e) {
		e.printStackTrace();
		}
		finally {
			try {
				if(keyRS!=null){keyRS.close();}
				if(stmt != null) {stmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();}
		}
	}
	
	
	public void delete (Persona updPer) {
		
		PreparedStatement stmt = null;
		
		try {

			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from persona where id_persona=? ");
			
			stmt.setInt(1, updPer.getIdPersona());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if(stmt!=null) {stmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void update(Persona updPer) {
		
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("update persona " + "set nombre = ?, apellido = ?, direccion = ?, email = ?, telefono = ?, fecha_nac = ?, legajo = ?, tipo_persona = ?, nombre_usuario = ?, clave = ?" + "where id_persona = ?");
			stmt.setString(1, updPer.getNombre());
			stmt.setString(2, updPer.getApellido());
			stmt.setString(3,updPer.getDireccion());
			stmt.setString(4, updPer.getEmail());
			stmt.setString(5, updPer.getTelefono());
			stmt.setString(6, updPer.getFechaNacimiento());
			stmt.setInt(7, updPer.getLegajo());
			stmt.setString(8, updPer.getTipoPersona());
			stmt.setString(9, updPer.getNombreUsuario());
			stmt.setString(10, updPer.getClave());
			stmt.setInt(11, updPer.getIdPersona());
			

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