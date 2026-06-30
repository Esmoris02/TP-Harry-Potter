package modelos;

public class Seguidor extends Mortifago{
	public Seguidor() {
		//Nombre, puntos de magia, puntos de vida
        super("Seguidor Común", 70, 110);
    }

    // Aunque posee afinidad, es un mago de bajo nivel
    @Override
    public double obtenerMultiplicadorHechizoOscuro() {
        return 0.8; 
    }

    // Penalizacion por mortifago
    @Override
    public double obtenerMultiplicadorCuracion() {
        return 0.4; 
    }

    // Mago de bajo nivel
    @Override
    public double obtenerMultiplicadorDefensa() {
        return 0.6;
    }
    
    // Recuperacion de nivel de magia estándar
    @Override
    public double obtenerTasaRecuperacionMagia() {
    	return 25;
    }

}
