package modelos;


public abstract class Mago extends Personaje{
	public Mago(String nombre, double nivelMagia, double puntosVida) {
        super(nombre, nivelMagia, puntosVida);
    }

    // Penalizacion por uso de magia oscura
    @Override
    public double obtenerMultiplicadorHechizoOscuro() {
        return 0.5; 
    }

    // Bonificacion por magia de curación
    @Override
    public double obtenerMultiplicadorCuracion() {
        return 1.5; 
    }

    // Defensa estandar mejorada
    @Override
    public double obtenerMultiplicadorDefensa() {
        return 1.2;
    }
    
    // Recuperacion de nivel de magia estándar
    @Override
    public double obtenerTasaRecuperacionMagia() {
    	return 20;
    }
    
    @Override
    public double obtenerProbabilidadImpactoHechizoFatal() {
    	return 0.4;
    }

}
