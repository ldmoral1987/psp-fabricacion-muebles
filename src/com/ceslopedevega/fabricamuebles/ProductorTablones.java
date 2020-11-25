package com.ceslopedevega.fabricamuebles;

public class ProductorTablones extends Thread {
	// N�mero de serie del productor de tablones y referencia al almac�n
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
			// Si hay menos de 5 tablones en el almac�n, me pongo a trabajar
			if (almacen.getNumMateriales() < 5)
			{
				// Crea un material y lo a�ade al almac�n
				Material m = new Material(numSerie);
				almacen.addMaterial(m);
				
				System.out.println("Productor " + getName() + ": he creado 1 material (" + getName() + "-" + numSerie++ + ")");
	
				try 
				{
					// Despu�s duerme un tiempo (2s), que simboliza la creaci�n del material
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
					// Si hay 5 o m�s materiales en el almac�n, despierto a
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
