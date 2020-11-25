package com.ceslopedevega.fabricamuebles;

public class ProductorTablones extends Thread {
	// Número de serie del productor de tablones y referencia al almacén
	private int numSerie = 1;
	private Almacen almacen = null;
	
	public ProductorTablones (Almacen almacen, String nombre)
	{
		super(nombre);
		this.almacen = almacen;
	}
	
	public void run ()
	{
		// El productor de tablones se ejecuta indefinidamente
		while (true)
		{
			// Si hay menos de 5 tablones en el almacén, me pongo a trabajar
			if (almacen.getNumMateriales() < 5)
			{
				// Crea un material y lo añade al almacén
				Material m = new Material(numSerie);
				almacen.addMaterial(m);
				
				System.out.println("Productor " + getName() + ": he creado 1 material (" + getName() + "-" + numSerie++ + ")");
	
				try 
				{
					// Después duerme un tiempo (2s), que simboliza la creación del material
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				try 
				{
					// Si hay 5 o más materiales en el almacén, despierto a
					// los consumidores que puedan estar dormidos y me echo a dormir
					synchronized (almacen)
					{
						almacen.notifyAll();
						almacen.wait();
					}
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
