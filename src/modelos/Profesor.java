package modelos;

public class Profesor extends Mago{
	public Profesor() {
		//Nombre, puntos de magia, puntos de vida
        super("Profesor Experimentado", 80, 120);
    }

    // El Profesor es un maestro en magia, así que tiene curacion mejorada
    @Override
    public double obtenerMultiplicadorCuracion() {
        return 2.0; 
    }

}
