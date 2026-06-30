package modelos;

public class Estudiante extends Mago{
	public Estudiante() {
		//Nombre, puntos de magia, puntos de vida
        super("Estudiante de Hogwarts", 50, 100);
    }

    // El estudiante todavía está aprendiendo, curación es mucho menor que la de un mago nermal
    @Override
    public double obtenerMultiplicadorCuracion() {
        return 0.8; 
    }

    // Escudos mágicos débiles
    @Override
    public double obtenerMultiplicadorDefensa() {
        return 0.7; 
    }

    //Si por alguna razón intenta usar magia oscura, el efecto es casi nulo
    @Override
    public double obtenerMultiplicadorHechizoOscuro() {
        return 0.2; 
    }

}
