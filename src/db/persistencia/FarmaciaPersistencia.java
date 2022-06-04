package com.dam.db.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dam.db.AccesoDB;
import com.dam.model.Usuario;

public class FarmaciaPersistencia {
	private AccesoDB acceso;
	
	public FarmaciaPersistencia() {
		acceso = new AccesoDB();
	}

	public Usuario validarUsuario(String nombreUsuario) {
		Usuario user = null;
		
		String query = "SELECT " + FarmaciaContract.EMP_APENOM + ", " + FarmaciaContract.EMP_CONTRASENA + " FROM " + FarmaciaContract.NOM_TAB_EMP + 
				" WHERE " + FarmaciaContract.EMP_APENOM  + " = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		String nomUser = "";
		String pwd = "";
		
		try {
			con = acceso.getConexion();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nombreUsuario);
			
			rslt = pstmt.executeQuery();
			
			if (rslt.next()) {
				nomUser = rslt.getString(1);
				pwd = rslt.getString(2);
				
				user = new Usuario(pwd, nomUser);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) rslt.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public int crearUsuarioNuevo(String usuario, String pwd) {
		
		int num = 0;
		
		String query = "INSERT INTO " + FarmaciaContract.NOM_TAB_EMP + " (" + FarmaciaContract.EMP_CONTRASENA + ", " + FarmaciaContract.EMP_APENOM + 
				") VALUES (?, ?)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = acceso.getConexion();
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, pwd);
			pstmt.setString(2, usuario);
			
			num = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) pstmt.close(); 
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		return num;
	}
	
	
}
