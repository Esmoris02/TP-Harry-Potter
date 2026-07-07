package modelos;

public class Seguidor extends Mortifago {
	private static final double MULTIPLICADOR_DEFENSA = 0.6;
	private static final double MULTIPLICADOR_CURACION = 0.4;
	private static final double MULTIPLICADOR_HECHIZO_OSCURO = 0.8;
	private static final int MAX_PUNTOS_VIDA = 110;
	private static final int MAX_NIVEL_MAGIA = 70;

	public Seguidor(String nombre) {
		super(nombre, MAX_NIVEL_MAGIA, MAX_PUNTOS_VIDA);
		this.maximoNivelMagia = MAX_NIVEL_MAGIA;
		this.maximoPuntosVida = MAX_PUNTOS_VIDA;
	}

	public Seguidor() {
		super("Seguidor Común", MAX_NIVEL_MAGIA, MAX_PUNTOS_VIDA);
		this.maximoNivelMagia = MAX_NIVEL_MAGIA;
		this.maximoPuntosVida = MAX_PUNTOS_VIDA;
	}

	// Aunque posee afinidad, es un mago de bajo nivel
	@Override
	public double obtenerMultiplicadorHechizoOscuro() {
		return MULTIPLICADOR_HECHIZO_OSCURO;
	}

	// Penalizacion por mortifago
	@Override
	public double obtenerMultiplicadorCuracion() {
		return MULTIPLICADOR_CURACION;
	}

	// Mago de bajo nivel
	@Override
	public double obtenerMultiplicadorDefensa() {
		return MULTIPLICADOR_DEFENSA;
	}

}
