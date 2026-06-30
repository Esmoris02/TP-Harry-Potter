package hechizos;

import efectos.Proteccion;
import modelos.Personaje;

public class Protego extends HechizoBase {
	protected double proteccionBase = 50;

	public Protego() {
		//Nombre, Coste MP
		super("Protego", 25);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double proteccionFinal = proteccionBase * lanzador.obtenerMultiplicadorDefensa();
		this.efectoCausado = new Proteccion(proteccionFinal);
		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.getNombre() + " crea una proteccion con " + this.getNombre());
	}

}
