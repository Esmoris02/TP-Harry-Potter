package hechizos;

import efectos.Curacion;
import modelos.Personaje;

public class VulneraSanetur extends HechizoBase {
	protected double curacionBase = 60;

	public VulneraSanetur() {
		// Nombre, Coste MP
		super("Vulnera Sanetur", 45);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double curacionFinal = curacionBase * lanzador.obtenerMultiplicadorCuracion()
				* lanzador.obtenerMultiplicadorHechizoOscuro();

		this.efectoCausado = new Curacion(curacionFinal);
		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.getNombre() + " se cura con " + this.getNombre());
	}

}
