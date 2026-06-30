package hechizos;

import efectos.Daño;
import modelos.Personaje;

public class Expelliarmus extends HechizoBase {
	private static final String NOMBRE_HECHIZO = "Expelliarmus";
	private static final int COSTE_MAGIA = 20;
	private static final int DAÑO_BASE = 15;

	public Expelliarmus() {
		super(NOMBRE_HECHIZO, COSTE_MAGIA);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double dañoFinal = DAÑO_BASE / objetivo.obtenerMultiplicadorDefensa();
		this.efectoCausado = new Daño(dañoFinal);
		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.getNombre() + " ataca con " + this.getNombre() + " a " + objetivo.getNombre());
	}

}
