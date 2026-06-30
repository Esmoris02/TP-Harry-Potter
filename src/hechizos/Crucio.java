package hechizos;

import efectos.Daño;
import modelos.Personaje;

public class Crucio extends HechizoBase{
	protected double dañoBase = 18;

	public Crucio() {
		//Nombre, Coste MP
		super("Crucio", 20);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double dañoFinal = (dañoBase * lanzador.obtenerMultiplicadorHechizoOscuro()) / objetivo.obtenerMultiplicadorDefensa();
		this.efectoCausado = new Daño(dañoFinal);
		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.getNombre() + " ataca con " + this.getNombre() + " a " + objetivo.getNombre());
	}
}
