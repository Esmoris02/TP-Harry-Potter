package hechizos;

import efectos.Daño;
import efectos.EfectoProlongado;
import modelos.Personaje;

public class Episkey extends HechizoBase{
	protected double curacionBase = 16.6;
	protected int duracionEnTurnos = 2;
	protected String nombreEfectoProlongado = "Regeneracion";
	
	
	public Episkey() {
		//Nombre, Coste MP
		super("Episkey", 30);
	}
	
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		double curacionBaseFinal = curacionBase * objetivo.obtenerMultiplicadorCuracion();
		this.efectoCausado = new EfectoProlongado(new Daño(curacionBaseFinal), new Daño(curacionBaseFinal), duracionEnTurnos, nombreEfectoProlongado);
		
		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.getNombre() + " cura con " + this.getNombre() + " a " + objetivo.getNombre());
	}

}
