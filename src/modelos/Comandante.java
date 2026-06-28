package modelos;

public class Comandante extends Mortifago{
	public Comandante() {
		//Nombre, puntos de magia, puntos de vida
        super("Comandante Oscuro", 110, 160);
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
