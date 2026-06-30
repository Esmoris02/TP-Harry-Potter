package modelos;


public abstract class Mortifago extends Personaje{
	public Mortifago(String nombre, double nivelMagia, double puntosVida) {
        super(nombre, nivelMagia, puntosVida);
    }

    // Bonificación por uso de magia oscura
    @Override
    public double obtenerMultiplicadorHechizoOscuro() {
        return 1.8; 
    }

    // PenaliZación por uso de magia de curación
    @Override
    public double obtenerMultiplicadorCuracion() {
        return 0.4; 
    }

    // Defensa estandar disminuida
    @Override
    public double obtenerMultiplicadorDefensa() {
        return 0.8;
    }
    
    // Recuperacion de nivel de magia estándar
    @Override
    public double obtenerTasaRecuperacionMagia() {
    	return 20;
    }
    
    @Override
    public double obtenerProbabilidadImpactoHechizoFatal() {
    	return 0.75;
    }

}
