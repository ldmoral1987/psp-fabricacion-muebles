package com.ceslopedevega.fabricamuebles;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
	// Listas privadas de materiales y muebles
	private List<Material> materiales;
	private List<Mueble> muebles;

	public Almacen ()
	{
		// Se inicializan los arraylist de materiales y muebles
		materiales = new ArrayList<Material>();
		muebles = new ArrayList<Mueble>();
	}
	
	// Añade un nuevo material a la lista
	public synchronized void addMaterial (Material m)
	{
		materiales.add(m);
	}
	
	// Obtiene un material de la lista
	public synchronized Material getMaterial ()
	{
		// Se toma el primer material de la lista siempre y cuando
		// haya algún material
		if (materiales.size() >= 1)
		{
			Material m = materiales.get(0);
			materiales.remove(m);
			return m;
		}
		else
		{
			// Si no hay materiales en la lista, se devuelve null
			return null;
		}
	}
	
	// Devuelve el número de materiales de la lista
	public int getNumMateriales ()
	{
		return materiales.size();
	}
	
	// Devuelve el número de muebles de la lista
	public int getNumMuebles ()
	{
		return muebles.size();
	}
	
	// Añade un mueble a la lista
	public synchronized void addMueble (Mueble m)
	{
		muebles.add(m);
	}
}
