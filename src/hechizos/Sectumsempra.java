package hechizos;

import efectos.Daño;
import efectos.EfectoProlongado;
import modelos.Personaje;

public class Sectumsempra extends HechizoBase {
	private static final String NOMBRE_HECHIZO = "Sectumsempra";
	private static final int COSTE_MAGIA = 50;
	private static final String NOMBRE_EFECTO_PROLONGADO = "Sangrado";
	private static final int DAÑO_ADICIONAL = 20;
	private static final int DAÑO_BASE = 55;
	protected int duracionEnTurnos = 3;

	public Sectumsempra() {
		super(NOMBRE_HECHIZO, COSTE_MAGIA);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double dañoBaseFinal = (DAÑO_BASE * lanzador.obtenerMultiplicadorHechizoOscuro())
				/ objetivo.obtenerMultiplicadorDefensa();
		this.efectoCausado = new EfectoProlongado(new Daño(dañoBaseFinal), new Daño(DAÑO_ADICIONAL), duracionEnTurnos,
				NOMBRE_EFECTO_PROLONGADO);

		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.obtenerNombre() + " ataca con " + this.getNombre() + " a " + objetivo.obtenerNombre());
	}
}
