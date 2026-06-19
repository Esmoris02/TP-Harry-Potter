package modelos;

public class Mortifago extends Personaje{
	public Mortifago(String nombre, double nivelMagia, double puntosVida) {
        super(nombre, nivelMagia, puntosVida);
    }

    // Bonificación por uso de magia oscura
    @Override
    public double obtenerMultiplicadorAtaqueOscuro() {
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

}
