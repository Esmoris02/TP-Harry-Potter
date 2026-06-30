package hechizos;

import efectos.Curacion;
import modelos.Personaje;

public class ExpectoPatronum extends HechizoBase {
	private static final String NOMBRE_HECHIZO = "Expecto Patronum";
	private static final int COSTE_MAGIA = 20;
	private static final int CURACION_BASE = 30;

	public ExpectoPatronum() {
		super(NOMBRE_HECHIZO, COSTE_MAGIA);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double curacionFinal = CURACION_BASE * lanzador.obtenerMultiplicadorCuracion();
		this.efectoCausado = new Curacion(curacionFinal);
		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.getNombre() + " se cura con " + this.getNombre());
	}
}
