package hechizos;

import efectos.Aturdimiento;
import modelos.Personaje;

public class Stupefy extends HechizoBase{

	public Stupefy() {
		// Nombre, Coste MP
		super("Stupefy", 30);
	}

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		this.efectoCausado = new Aturdimiento();
		objetivo.recibirEfecto(efectoCausado);
		System.out.println(lanzador.getNombre() + " aturde con " + this.getNombre() + " a " + objetivo.getNombre());
	}
}
