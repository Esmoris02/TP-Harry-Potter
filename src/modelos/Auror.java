package modelos;

public class Auror extends Mago{
	
	public Auror() {
		//Nombre, puntos de magia, puntos de vida
        super("Auror de Élite", 100, 150);
        this.maximoNivelMagia = 100;
        this.maximoPuntosVida = 150;
    }

    // Solo sobrescribimos la defensa porque es el punto fuerte exclusivo del Auror
    @Override
    public double obtenerMultiplicadorDefensa() {
        return 1.8; 
    }
    
    // Recuperacion de nivel de magia estándar
    @Override
    public double obtenerTasaRecuperacionMagia() {
    	return 30;
    }
    
    public double obtenerProbabilidadImpactoHechizoFatal() {
    	return 0.4;
    }

}
