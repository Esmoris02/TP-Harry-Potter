package hechizos;

import efectos.Aturdimiento;
import efectos.EfectoProlongado;
import modelos.Personaje;

public class PetrificusTotalus extends HechizoBase {
	private static final String NOMBRE_HECHIZO = "Petrificus Totalus";
	private static final int COSTE_MAGIA = 45;
	private static final String NOMBRE_EFECTO_PROLONGADO = "Parálisis";
	protected int duracionEnTurnos = 1;

	public PetrificusTotalus() {
		super(NOMBRE_HECHIZO, COSTE_MAGIA);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		this.efectoCausado = new EfectoProlongado(new Aturdimiento(), new Aturdimiento(), duracionEnTurnos,
				NOMBRE_EFECTO_PROLONGADO);
		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.obtenerNombre() + " aturde con " + this.getNombre() + " a " + objetivo.obtenerNombre());
	}
}
