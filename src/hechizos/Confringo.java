package hechizos;

import efectos.Daño;
import efectos.EfectoProlongado;
import modelos.Personaje;

public class Confringo extends HechizoBase {
	private static final String NOMBRE_EFECTO_PROLONGADO = "Quemadura";
	private static final int DAÑO_ADICIONAL = 10;
	private static final int DAÑO_BASE = 20;
	private static final int COSTE_MAGIA = 27;
	private static final String CONFRINGO = "Confringo";
	protected int duracionEnTurnos = 2;

	public Confringo() {
		super(CONFRINGO, COSTE_MAGIA);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double dañoBaseFinal = DAÑO_BASE / objetivo.obtenerMultiplicadorDefensa();
		this.efectoCausado = new EfectoProlongado(new Daño(dañoBaseFinal), new Daño(DAÑO_ADICIONAL), duracionEnTurnos,
				NOMBRE_EFECTO_PROLONGADO);

		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.obtenerNombre() + " ataca con " + this.getNombre() + " a " + objetivo.obtenerNombre());
	}

}
