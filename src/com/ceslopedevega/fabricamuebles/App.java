package com.ceslopedevega.fabricamuebles;

// Esta aplicación resuelve un problema de programación concurrente clásico productor-consumidor
// El productor crea tablones de madera y el consumidor los consume para transformarlos en muebles
public class App {

	public static void main(String[] args) 
	{
		// Se crea el objeto compartido (almacén)
		Almacen almacen = new Almacen();
		
		// Se crean los productores y los consumidores
		// Cada hilo recibe su identificador (int) y el objeto compartido
		ProductorTablones productor1 = new ProductorTablones(almacen, "1");
		ProductorTablones productor2 = new ProductorTablones(almacen, "2");
		ConsumidorTablones consumidor1 = new ConsumidorTablones(almacen, "1");
		ConsumidorTablones consumidor2 = new ConsumidorTablones(almacen, "2");
		ConsumidorTablones consumidor3 = new ConsumidorTablones(almacen, "3");
		
		// Se inician los productores y los consumidores
		productor1.start();
		productor2.start();
		consumidor1.start();
		consumidor2.start();
		consumidor3.start();
	}
}
