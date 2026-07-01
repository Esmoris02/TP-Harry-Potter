package modelos;

public class Auror extends Mago{
	
	private static final double PROBABILIDAD_IMPACTO_HECHIZO_FATAL = 0.4;
	private static final int TASA_RECUPERACION_MAGIA = 30;
	private static final double MULTIPLICADOR_DEFENSA = 1.8;
	private static final double MULTIPLICADOR_HECHIZO_OSCURO = 0.8;
	
	private static final int MAX_NIVEL_VIDA = 150;
	private static final int MAX_NIVEL_MAGIA = 100;

	public Auror() {
		//Nombre, puntos de magia, puntos de vida
        super("Auror de Élite", MAX_NIVEL_MAGIA, MAX_NIVEL_VIDA);
        this.maximoNivelMagia = MAX_NIVEL_MAGIA;
        this.maximoPuntosVida = MAX_NIVEL_VIDA;
    }

    // Solo sobrescribimos la defensa porque es el punto fuerte exclusivo del Auror
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
    public double obtenerMultiplicadorHechizoOscuro() {
        return MULTIPLICADOR_HECHIZO_OSCURO; 
    }
    
    @Override
    public double obtenerProbabilidadImpactoHechizoFatal() {
		return PROBABILIDAD_IMPACTO_HECHIZO_FATAL;
    }
    
    

}
