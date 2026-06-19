package modelos;

public class Mago extends Personaje{
	public Mago(String nombre, double nivelMagia, double puntosVida) {
        super(nombre, nivelMagia, puntosVida);
    }

    // Penalizacion por uso de magia oscura
    @Override
    public double obtenerMultiplicadorAtaqueOscuro() {
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

}
