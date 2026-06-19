package modelos;

public class Auror extends Mago{
	public Auror(String nombre, double nivelMagia, double puntosVida) {
        super(nombre, nivelMagia, puntosVida);
    }

    // Solo sobrescribimos la defensa porque es el punto fuerte exclusivo del Auror
    @Override
    public double obtenerMultiplicadorDefensa() {
        return 1.8; 
    }

}
