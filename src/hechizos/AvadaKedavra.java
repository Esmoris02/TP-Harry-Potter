package hechizos;

import java.util.Random;

import efectos.Daño;
import modelos.Personaje;

public class AvadaKedavra extends HechizoBase{
	protected double dañoBase = 999;
	
	public AvadaKedavra() {
		//Nombre, Coste MP
		super("AvadaKedabra", 75);
	}
	
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		Random rand = new Random();
		double resultado = rand.nextDouble();
		if(resultado < lanzador.obtenerProbabilidadImpactoHechizoFatal()) {
			this.efectoCausado = new Daño(dañoBase);
			objetivo.recibirEfecto(efectoCausado);
			System.out.println(lanzador.getNombre() + " ataca con " + this.getNombre() + " a " + objetivo.getNombre() + " y acierta.");
		} else {
			System.out.println(lanzador.getNombre() + " ataca con " + this.getNombre() + " a " + objetivo.getNombre() + " pero no acierta.");
		}
	}
	
	
	
}
