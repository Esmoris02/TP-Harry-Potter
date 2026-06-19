package modelos;

public class Profesor extends Mago{
	public Profesor(String nombre, double nivelMagia, double puntosVida) {
        super(nombre, nivelMagia, puntosVida);
    }

    // El Profesor es un maestro en magia, así que tiene curacion mejorada
    @Override
    public double obtenerMultiplicadorCuracion() {
        return 2.0; 
    }

}
