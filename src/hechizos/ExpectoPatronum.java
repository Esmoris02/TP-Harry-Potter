package hechizos;

import modelos.Personaje;

public class ExpectoPatronum extends Hechizo{
	public ExpectoPatronum() {
		super("ExpectoPatronum", 15);
	}
	
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.recibirCuracion(lanzador.obtenerMultiplicadorCuracion() * 30);
		System.out.println(lanzador.getNombre() + " se cura con " + this.getNombre());
	}
}
