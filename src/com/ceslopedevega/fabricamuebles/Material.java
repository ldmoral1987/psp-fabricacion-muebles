package com.ceslopedevega.fabricamuebles;

// Clase material: clase dummy que únicamente tiene un id (número de serie)
public class Material {
	private int id;
	
	public Material(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
