package hechizos;

import efectos.Aturdimiento;
import modelos.Personaje;

public class Stupefy extends HechizoBase {
	private static final String NOMBRE_HECHIZO = "Stupefy";
	private static final int COSTE_MAGIA = 30;

	public Stupefy() {
		super(NOMBRE_HECHIZO, COSTE_MAGIA);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		this.efectoCausado = new Aturdimiento();
		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.obtenerNombre() + " aturde con " + this.getNombre() + " a " + objetivo.obtenerNombre());
	}
}
