package hechizos;

import modelos.Personaje;

public class AvadaKedabra implements Hechizo{
	
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double danio = (100 * lanzador.obtenerMultiplicadorAtaqueOscuro())/objetivo.obtenerMultiplicadorDefensa();
		objetivo.recibirDanio(danio);
	}
	
}
