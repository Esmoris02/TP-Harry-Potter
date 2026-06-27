package hechizos;

import modelos.Personaje;

public class Expelliarmus extends HechizoBase{
	public Expelliarmus(){
		super("Expelliarmus");
	}
	
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double danio = (20 * lanzador.obtenerMultiplicadorAtaqueOscuro())/objetivo.obtenerMultiplicadorDefensa();
		objetivo.recibirDanio(danio);
		System.out.println(lanzador.getNombre() + " ataca con " + this.getNombre() + " a " + objetivo.getNombre());
	}
	
}
