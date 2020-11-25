package com.ceslopedevega.fabricamuebles;

public class ConsumidorTablones extends Thread {
	// N�mero de serie del consumidor de tablones y referencia al almac�n
	private int numSerie = 1;
	private Almacen almacen = null;
	
	public ConsumidorTablones (Almacen almacen, String nombre)
	{
		super(nombre);
		this.almacen = almacen;
	}
	
	public void run ()
	{
		// El consumidor de tablones se ejecuta indefinidamente
		while (true)
		{
			// Se obtiene un material del almac�n
			Material m = almacen.getMaterial();
			
			if (m != null)
			{
				// Si el material no es nulo, lo transformo en un mueble
				try 
				{
					// Duermo 10 segundos, el tiempo que se estima en fabricar el mueble
					Thread.sleep(10000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				
				// Creo el mueble con su n�mero de serie
				Mueble mueble = new Mueble(numSerie);
				
				// A�ado el mueble al almac�n
				System.out.println("Consumidor " + getName() + ": he creado el mueble (" + getName() + "-" + numSerie++ + ") con el material (" + m.getId() + ")");
				almacen.addMueble(mueble);
			}
			else
			{
				// Si el material que he recibido del almac�n es nulo
				// despierto a todos los productores y me duermo yo
				synchronized (almacen)
				{
					try 
					{
						almacen.notifyAll();
						almacen.wait();
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
}
