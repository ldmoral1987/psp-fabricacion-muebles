package com.ceslopedevega.fabricamuebles;

//Clase mueble: clase dummy que �nicamente tiene un id (n�mero de serie)
public class Mueble {
  private int id;
	
	public Mueble(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
