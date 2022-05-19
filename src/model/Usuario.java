package com.dam.model;

public class Usuario {
	private int id;
	private String password;
	private String apeNom;
	
	public Usuario(int id, String password, String apeNom) {
		this.id = id;
		this.password = password;
		this.apeNom = apeNom;
	}

	public String getApeNom() {
		return apeNom;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

}
