package hechizos;

import modelos.Personaje;

public class Protego extends HechizoBase{
	public Protego(){
		super("Protego");
	}
	
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		lanzador.protegido = true;
		System.out.println(lanzador.getNombre() + " se protege con " + this.getNombre());
	}

}
