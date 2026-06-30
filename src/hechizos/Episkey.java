package hechizos;

import efectos.Daño;
import efectos.EfectoProlongado;
import modelos.Personaje;

public class Episkey extends HechizoBase {
	private static final String NOMBRE_HECHIZO = "Episkey";
	private static final int COSTE_MAGIA = 30;
	private static final String NOMBRE_EFECTO_PROLONGADO = "Regeneracion";
	private static final double CURACION_BASE = 16.6;
	protected int duracionEnTurnos = 2;

	public Episkey() {
		super(NOMBRE_HECHIZO, COSTE_MAGIA);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double curacionBaseFinal = CURACION_BASE * objetivo.obtenerMultiplicadorCuracion();
		this.efectoCausado = new EfectoProlongado(new Daño(curacionBaseFinal), new Daño(curacionBaseFinal),
				duracionEnTurnos, NOMBRE_EFECTO_PROLONGADO);

		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.getNombre() + " cura con " + this.getNombre() + " a " + objetivo.getNombre());
	}

}
