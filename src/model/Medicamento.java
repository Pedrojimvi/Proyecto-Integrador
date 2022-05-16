package com.dam.model;

public class Medicamento {
	private int id;
	private String nombre;
	private String tipo;
	private String farmaceutica;
	private double precio;
	private int stock;
	
	public Medicamento(int id, String nombre, String tipo, String farmaceutica, double precio, int stock) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.farmaceutica = farmaceutica;
		this.precio = precio;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getFarmaceutica() {
		return farmaceutica;
	}

	public double getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}
	
}
