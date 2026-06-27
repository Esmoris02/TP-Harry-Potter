package hechizos;

import modelos.Personaje;

public class ExpectoPatronum extends HechizoBase{
	public ExpectoPatronum() {
		super("ExpectoPatronum");
	}
	
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.recibirCuracion(lanzador.obtenerMultiplicadorCuracion() * 30);
		System.out.println(lanzador.getNombre() + " se cura con " + this.getNombre());
	}
}
