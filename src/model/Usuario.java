package com.dam.model;

public class Usuario {
	private int id;
	private String contrasena;
	private String apeNom;
	
	public Usuario(int id, String contrasena, String apeNom) {
		this.id = id;
		this.contrasena = contrasena;
		this.apeNom = apeNom;
	}

	public String getApeNom() {
		return apeNom;
	}

	public int getId() {
		return id;
	}

	public String getContrasena() {
		return contrasena;
	}

}
