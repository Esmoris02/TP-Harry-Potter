package hechizos;

import java.util.Random;

import efectos.Daño;
import modelos.Personaje;

public class AvadaKedavra extends HechizoBase {
	private static final String NOMBRE_HECHIZO = "AvadaKedabra";
	private static final double DAÑO_BASE = 999;
	private static final double COSTE_MAGIA = 75;

	public AvadaKedavra() {
		super(NOMBRE_HECHIZO, COSTE_MAGIA);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		Random rand = new Random();
		double resultado = rand.nextDouble();
		if (resultado < lanzador.obtenerProbabilidadImpactoHechizoFatal()) {
			this.efectoCausado = new Daño(DAÑO_BASE);
			objetivo.recibirEfecto(efectoCausado);
			System.out.println(lanzador.getNombre() + " ataca con " + this.getNombre() + " a " + objetivo.getNombre()
					+ " y acierta.");
		} else {
			System.out.println(lanzador.getNombre() + " ataca con " + this.getNombre() + " a " + objetivo.getNombre()
					+ " pero no acierta.");
		}
	}

}
