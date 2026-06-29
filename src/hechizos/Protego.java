package hechizos;

import modelos.Personaje;

public class Protego extends Hechizo{
	public Protego(){
		super("Protego", 25);
	}
	
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		lanzador.setProtegido(true);
		System.out.println(lanzador.getNombre() + " se protege con " + this.getNombre());
	}

}
