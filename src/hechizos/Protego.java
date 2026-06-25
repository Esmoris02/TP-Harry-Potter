package hechizos;

import modelos.Personaje;

public class Protego implements Hechizo{
	
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.protegido = true;
	}

}
