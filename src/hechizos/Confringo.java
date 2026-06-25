package hechizos;

import modelos.Personaje;

//Hace que el objetivo estalle en llamas, causando gran daño destructivo.
public class Confringo implements Hechizo{
	
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double danio = (40 * lanzador.obtenerMultiplicadorAtaqueOscuro())/objetivo.obtenerMultiplicadorDefensa();
		objetivo.recibirDanio(danio);
	}
	
}
