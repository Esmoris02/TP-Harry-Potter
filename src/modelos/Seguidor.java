package modelos;

public class Seguidor extends Mortifago{
	public Seguidor(String nombre, double nivelMagia, double puntosVida) {
        super(nombre, nivelMagia, puntosVida);
    }

    // Aunque posee afinidad, es un mago de bajo nivel
    @Override
    public double obtenerMultiplicadorAtaqueOscuro() {
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

}
