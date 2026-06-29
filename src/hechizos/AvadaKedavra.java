package hechizos;

import modelos.Personaje;

public class AvadaKedavra extends HechizoAtaque{
	
	
	public AvadaKedavra() {
		super("AvadaKedabra", 75);
	}
	
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double danio = (150 * lanzador.obtenerMultiplicadorAtaqueOscuro())/objetivo.obtenerMultiplicadorDefensa();
		objetivo.recibirDanio(danio);
		System.out.println(lanzador.getNombre() + " ataca con " + this.getNombre() + " a " + objetivo.getNombre());
	}
	
}
