package hechizos;

import efectos.Proteccion;
import modelos.Personaje;

public class Protego extends HechizoBase {
	private static final String NOMBRE_HECHIZO = "Protego";
	private static final int COSTE_MAGIA = 25;
	private static final int PROTECCION_BASE = 50;

	public Protego() {
		super(NOMBRE_HECHIZO, COSTE_MAGIA);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double proteccionFinal = PROTECCION_BASE * lanzador.obtenerMultiplicadorDefensa();
		this.efectoCausado = new Proteccion(proteccionFinal);
		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.getNombre() + " crea una proteccion con " + this.getNombre());
	}

}
