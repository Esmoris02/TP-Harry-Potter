package hechizos;

import modelos.Personaje;

//Hace que el objetivo estalle en llamas, causando gran daño destructivo.
public class Confringo extends HechizoBase{
	public Confringo(){
		super("Confringo", 25);
	}
	
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double danio = (40 * lanzador.obtenerMultiplicadorAtaqueOscuro())/objetivo.obtenerMultiplicadorDefensa();
		objetivo.recibirDanio(danio);
		System.out.println(lanzador.getNombre() + " ataca con " + this.getNombre() + " a " + objetivo.getNombre());
	}
	
}
