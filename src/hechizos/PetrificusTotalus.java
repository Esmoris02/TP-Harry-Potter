package hechizos;

import efectos.Aturdimiento;
import efectos.EfectoProlongado;
import modelos.Personaje;

public class PetrificusTotalus extends HechizoBase{
	protected int duracionEnTurnos = 1; 
	protected String nombreEfectoProlongado = "Parálisis";
	
	
	public PetrificusTotalus() {
		//Nombre, Coste MP
		super("Petrificus Totalus", 45);
	}
	
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		this.efectoCausado = new EfectoProlongado(new Aturdimiento(), new Aturdimiento(), duracionEnTurnos, nombreEfectoProlongado);
		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.getNombre() + " aturde con " + this.getNombre() + " a " + objetivo.getNombre());
	}
}
