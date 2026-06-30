package hechizos;

import efectos.Daño;
import modelos.Personaje;

public class Crucio extends HechizoBase {
	private static final int DAÑO_BASE = 18;
	private static final int COSTE_MAGIA = 20;
	private static final String NOMBRE_HECHIZO = "Crucio";

	public Crucio() {
		super(NOMBRE_HECHIZO, COSTE_MAGIA);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double dañoFinal = (DAÑO_BASE * lanzador.obtenerMultiplicadorHechizoOscuro())
				/ objetivo.obtenerMultiplicadorDefensa();
		this.efectoCausado = new Daño(dañoFinal);
		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.obtenerNombre() + " ataca con " + this.getNombre() + " a " + objetivo.obtenerNombre());
	}
}
