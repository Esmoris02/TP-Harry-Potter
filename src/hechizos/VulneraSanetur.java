package hechizos;

import efectos.Curacion;
import modelos.Personaje;

public class VulneraSanetur extends HechizoBase {
	private static final String NOMBRE_HECHIZO = "Vulnera Sanetur";
	private static final int COSTE_MAGIA = 45;
	private static final int CURACION_BASE = 60;

	public VulneraSanetur() {
		super(NOMBRE_HECHIZO, COSTE_MAGIA);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double curacionFinal = CURACION_BASE * lanzador.obtenerMultiplicadorCuracion()
				* lanzador.obtenerMultiplicadorHechizoOscuro();

		this.efectoCausado = new Curacion(curacionFinal);
		lanzador.recibirEfecto(efectoCausado);
		System.out.println(lanzador.getNombre() + " se cura con " + this.getNombre());
	}

}
