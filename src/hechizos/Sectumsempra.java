package hechizos;

import efectos.Daño;
import efectos.EfectoProlongado;
import modelos.Personaje;

public class Sectumsempra extends HechizoBase{
	protected double dañoBase = 55;
	protected double dañoAdicional = 20;
	protected int duracionEnTurnos = 3;
	protected String nombreEfectoProlongado = "Sangrado";
	
	
	public Sectumsempra() {
		//Nombre, Coste MP
		super("Sectumsempra", 50);
	}
	
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double dañoBaseFinal = (dañoBase * lanzador.obtenerMultiplicadorHechizoOscuro()) / objetivo.obtenerMultiplicadorDefensa();
		this.efectoCausado = new EfectoProlongado(new Daño(dañoBaseFinal), new Daño(dañoAdicional), duracionEnTurnos, nombreEfectoProlongado);
		
		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.getNombre() + " ataca con " + this.getNombre() + " a " + objetivo.getNombre());
	}
}
