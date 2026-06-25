package hechizos;

import modelos.Personaje;

public class Expelliarmus implements Hechizo{
	
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double danio = (20 * lanzador.obtenerMultiplicadorAtaqueOscuro())/objetivo.obtenerMultiplicadorDefensa();
		objetivo.recibirDanio(danio);
	}
	
}
