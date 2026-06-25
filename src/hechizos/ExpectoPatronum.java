package hechizos;

import modelos.Personaje;

public class ExpectoPatronum implements Hechizo{
	
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.recibirCuracion(lanzador.obtenerMultiplicadorCuracion() * 30);
	}
}
