package hechizos;

import efectos.Efecto;
import modelos.Personaje;

public abstract class HechizoAtaque extends Hechizo {
	protected double cantidadDaño;
	

	protected HechizoAtaque(String nombre, double coste) {
		super(nombre, coste);
	}

	public abstract void ejecutar(Personaje lanzador, Personaje objetivo);
	
	

}
