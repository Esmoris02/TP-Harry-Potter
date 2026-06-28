package modelos;

public class Auror extends Mago{
	
	public Auror() {
		//Nombre, puntos de magia, puntos de vida
        super("Auror de Élite", 100, 150);
    }

    // Solo sobrescribimos la defensa porque es el punto fuerte exclusivo del Auror
    @Override
    public double obtenerMultiplicadorDefensa() {
        return 1.8; 
    }

}
