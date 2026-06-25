package modelos;

public class Comandante extends Personaje{
	public Comandante(String nombre, double nivelMagia, double puntosVida) {
        super(nombre, nivelMagia, puntosVida);
    }

    // Bonificacion por uso de magia oscura
    @Override
    public double obtenerMultiplicadorAtaqueOscuro() {
        return 1.6; 
    }

    // Penalizacion por magia de curación
    @Override
    public double obtenerMultiplicadorCuracion() {
        return 0.5; 
    }

    // Defensa estandar mejorada
    @Override
    public double obtenerMultiplicadorDefensa() {
        return 1.4;
    }
}
