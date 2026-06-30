package modelos;


public abstract class Mago extends Personaje{
	private static final double PROBABILIDAD_IMPACTO_HECHIZO_FATAL = 0.4;
	private static final int TASA_RECUPERACION_MAGIA = 20;
	private static final double MULTIPLICADOR_DEFENSA = 1.2;
	private static final double MULTIPLICADOR_CURACION = 1.5;
	private static final double MULTIPLICADOR_HECHIZO_OSCURO = 0.5;

	public Mago(String nombre, double nivelMagia, double puntosVida) {
        super(nombre, nivelMagia, puntosVida);
    }

    // Penalizacion por uso de magia oscura
    @Override
    public double obtenerMultiplicadorHechizoOscuro() {
        return MULTIPLICADOR_HECHIZO_OSCURO; 
    }

    // Bonificacion por magia de curación
    @Override
    public double obtenerMultiplicadorCuracion() {
        return MULTIPLICADOR_CURACION; 
    }

    // Defensa estandar mejorada
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
