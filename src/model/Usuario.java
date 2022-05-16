package com.dam.model;

public class Usuario {
	private String nomUser;
	private String contrasena;
	private String apeNom;
	
	public Usuario(String nomUser, String contrasena, String apeNom) {
		this.nomUser = nomUser;
		this.contrasena = contrasena;
		this.apeNom = apeNom;
	}

	public String getApeNom() {
		return apeNom;
	}

	public String getNomUser() {
		return nomUser;
	}

	public String getContrasena() {
		return contrasena;
	}

}
