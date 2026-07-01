package modelos;

public class Seguidor extends Mortifago{
	private static final int TASA_RECUPERACION_MAGIA = 25;
	private static final double MULTIPLICADOR_DEFENSA = 0.6;
	private static final double MULTIPLICADOR_CURACION = 0.4;
	private static final double MULTIPLICADOR_HECHIZO_OSCURO = 0.8;
	private static final int MAX_PUNTOS_VIDA = 110;
	private static final int MAX_NIVEL_MAGIA = 70;

	public Seguidor() {
		//Nombre, puntos de magia, puntos de vida
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
    
    // Recuperacion de nivel de magia estándar
    @Override
    public double obtenerTasaRecuperacionMagia() {
		return TASA_RECUPERACION_MAGIA;
    }

}
