package modelos;


public abstract class Mortifago extends Personaje{
	private static final double PROBABILIDAD_IMPACTO_HECHIZO_FATAL = 0.75;
	private static final int TASA_RECUPERACION_MAGIA = 20;
	private static final double MULTIPLICADOR_DEFENSA = 0.8;
	private static final double MULTIPLICADOR_CURACION = 0.4;
	private static final double MULTIPLICADOR_HECHIZO_OSCURO = 1.8;

	public Mortifago(String nombre, double nivelMagia, double puntosVida) {
        super(nombre, nivelMagia, puntosVida);
    }

    // Bonificación por uso de magia oscura
    @Override
    public double obtenerMultiplicadorHechizoOscuro() {
        return MULTIPLICADOR_HECHIZO_OSCURO; 
    }

    // PenaliZación por uso de magia de curación
    @Override
    public double obtenerMultiplicadorCuracion() {
        return MULTIPLICADOR_CURACION; 
    }

    // Defensa estandar disminuida
    @Override
    public double obtenerMultiplicadorDefensa() {
        return MULTIPLICADOR_DEFENSA;
    }
    
    // Recuperacion de nivel de magia estándar
    @Override
    public double obtenerTasaRecuperacionMagia() {
    	return TASA_RECUPERACION_MAGIA;
    }
    
    @Override
    public double obtenerProbabilidadImpactoHechizoFatal() {
		return PROBABILIDAD_IMPACTO_HECHIZO_FATAL;
    }

}
